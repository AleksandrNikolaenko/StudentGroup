package com.gmail.nikostar0709.lesson5.groupStudent;

import com.gmail.nikostar0709.lesson5.groupStudent.exceptions.*;
import javax.swing.JOptionPane;

public class StudentTools {

    public Student getNewStudent() {
        Student student = new Student();
        try {
            setStudentName(student);
            setStudentLastName(student);
            setStudentGender(student);
            setStudentID(student);
            setStudentGroupName(student);
        } catch (IllegalFormatNameException | IllegalFormatLastNameException | IllegalFormatGenderException |
                 IllegalFormatIDException | IllegalFormatGroupNameException e) {
            e.printStackTrace();
            student = null;
        }
        return student;
    }

    public void setStudentName(Student student) throws IllegalFormatNameException {
        String name = JOptionPane.showInputDialog(null, "Input student name", "Create new student", JOptionPane.QUESTION_MESSAGE);
        if (isWord(name)) {
            name = getWordFormatToLowerCaseAndToUpperCaseFirstChar(name);
            student.setName(name);
            return;
        }
        JOptionPane.showMessageDialog(null,"Error entering name.\nOperation cancelled.", "Cancel operation", JOptionPane.ERROR_MESSAGE);
        throw new IllegalFormatNameException("Error entering name");
    }
    public void setStudentLastName(Student student) throws IllegalFormatLastNameException {
        String lastName = JOptionPane.showInputDialog(null, "Input student last name", "Create new student", JOptionPane.QUESTION_MESSAGE);
        if (isWord(lastName)) {
            lastName = getWordFormatToLowerCaseAndToUpperCaseFirstChar(lastName);
            student.setLastName(lastName);
            return;
        }
        JOptionPane.showMessageDialog(null,"Error entering last name.\nOperation cancelled.", "Cancel operation", JOptionPane.ERROR_MESSAGE);
        throw new IllegalFormatLastNameException("Error entering last name");
    }
    public void setStudentGender(Student student) throws IllegalFormatGenderException {
        String gender = JOptionPane.showInputDialog(null, "Input student gender", "Create new student", JOptionPane.QUESTION_MESSAGE);
        if (isGender(gender)) {
            student.setGender(getGenderFromString(gender));
            return;
        }
        JOptionPane.showMessageDialog(null,"Error entering gender.\nOperation cancelled.", "Cancel operation", JOptionPane.ERROR_MESSAGE);
        throw new IllegalFormatGenderException("Error entering gender");
    }
    public void setStudentID(Student student) throws IllegalFormatIDException {
        String id = JOptionPane.showInputDialog(null, "Input student id", "Create new student", JOptionPane.QUESTION_MESSAGE);
        if (isID(id)) {
            student.setId(Integer.parseInt(id));
            return;
        }
        JOptionPane.showMessageDialog(null,"Error entering id.\nOperation cancelled.", "Cancel operation", JOptionPane.ERROR_MESSAGE);
        throw new IllegalFormatIDException("Error entering id");
    }
    public void setStudentGroupName(Student student) throws IllegalFormatGroupNameException {
        String groupName = JOptionPane.showInputDialog(null, "Input student group name", "Create new student", JOptionPane.QUESTION_MESSAGE);
        if (isGroupName(groupName)) {
            student.setGroupName(groupName);
            return;
        }
        JOptionPane.showMessageDialog(null,"Error entering group name.\nOperation cancelled.", "Cancel operation", JOptionPane.ERROR_MESSAGE);
        throw new IllegalFormatGroupNameException("Error entering group name");
    }

    public boolean isWord(String name){
        if (name == null) return false;
        if (name.length() < 2) return false;
        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j <= 26; j++) {
                if (name.charAt(i) == (char) 65 + j || name.charAt(i) == (char) 97 + j) break;
                if (j == 26) return false;
            }
        }
        return true;
    }

    public String getWordFormatToLowerCaseAndToUpperCaseFirstChar(String name) {
        name = name.toLowerCase();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public boolean isGender(String gender) {
        for (Gender g : Gender.values()){
            if (g.toString().equals(gender)) return true;
        }
        return false;
    }

    public Gender getGenderFromString(String gender) {
        for (Gender g : Gender.values()){
            if (g.toString().equals(gender)) return g;
        }
        return null;
    }

    public boolean isID(String id) {
        if (id == null) return false;
        for (int i = 0; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) return false;
        }
        return true;
    }

    public boolean isGroupName(String groupName) {
        if (groupName == null) return false;
        return groupName.length() >= 2;
    }

    @Override
    public String toString() {
        return "GroupTools{not has fields}";
    }
}
