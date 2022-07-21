package com.gmail.nikostar0709.lesson5.groupStudent;

import com.gmail.nikostar0709.lesson5.groupStudent.exceptions.GroupOverflowException;
import com.gmail.nikostar0709.lesson5.groupStudent.exceptions.IllegalCSVFileStudentFormatException;
import com.gmail.nikostar0709.lesson5.groupStudent.exceptions.IllegalStudentsGroupFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {

    public void saveGroupToCSV(Group gr) throws IllegalStudentsGroupFormatException {
        if (!isStudentsGroup(gr)) throw new IllegalStudentsGroupFormatException("one or more Students has illegal format");
        gr.sortStudentByLastName();
        CSVStringConverter csv = new CSVStringConverter();
        File file = getGroupFileName(gr);
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < gr.getStudents().length; i++) {
                if (gr.getStudents()[i] == null) return;
                pw.println(csv.toStringRepresentation(gr.getStudents()[i]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private File getGroupFileName(Group gr) {
        String path = "src\\com\\gmail\\nikostar0709\\lesson5\\groupStudent\\" + gr.getGroupName() + ".group";
        return new File(path);
    }

    private boolean isStudentsGroup(Group gr) {
        if (gr.getStudents() == null || gr.getGroupName() == null) return false;
        for (int i = 0; i < gr.getStudents().length; i++) {
            if (gr.getStudents()[i] != null) {
                if (!gr.getStudentTools().isWord(gr.getStudents()[i].getName())) return false;
                if (!gr.getStudentTools().isWord(gr.getStudents()[i].getLastName())) return false;
                if (!gr.getStudentTools().isGender(gr.getStudents()[i].getGender().toString())) return false;
                if (!gr.getStudentTools().isID(Integer.toString(gr.getStudents()[i].getId()))) return false;
                if (!gr.getStudentTools().isGroupName(gr.getStudents()[i].getGroupName())) return false;
            }
        }
        return true;
    }
    public Group loadGroupFromCSV(File file) throws IllegalCSVFileStudentFormatException, GroupOverflowException {
        Group gr = new Group();
        if (!isCSVStudentFile(file, gr.getStudentTools())) throw new IllegalCSVFileStudentFormatException("illegal CSV format for Student ");
        gr.setGroupName(file.getName().substring(0, file.getName().indexOf(".")));
        Student[] stud = new Student[10];
        CSVStringConverter csv = new CSVStringConverter();
        try (Scanner scanner = new Scanner(file)) {
            for (int i = 0;scanner.hasNextLine(); i++){
                if (i == stud.length) throw new GroupOverflowException("group overflow");
                Student student = csv.fromStringRepresentation(scanner.nextLine());
                stud[i] = student;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        gr.setStudents(stud.clone());
        return gr;
    }

    private boolean isCSVStudentFile(File file, StudentTools studentTools) {
        try (Scanner scanner = new Scanner(file)) {
            String[] st = scanner.nextLine().split(",");
            if (st.length != 5) return false;
            if (!studentTools.isWord(st[0])) return false;
            if (!studentTools.isWord(st[1])) return false;
            if (!studentTools.isGender(st[2])) return false;
            if (!studentTools.isID(st[3])) return false;
            if (!studentTools.isGroupName(st[4])) return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public File findFileByGroupName(String groupName, File workFolder) throws FileNotFoundException{
        File[] files = workFolder.listFiles();
        if (files == null) throw new FileNotFoundException("folder '" + workFolder + " is empty");
        for (File file : files) {
            if (file.isFile() && file.getName().equals(groupName + ".group")) return file;
        }
        throw new FileNotFoundException("file '" + groupName + ".group' not found");
    }

    @Override
    public String toString() {
        return "GroupFileStorage{not has field}";
    }
}
