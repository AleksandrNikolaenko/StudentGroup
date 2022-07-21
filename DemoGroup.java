package com.gmail.nikostar0709.lesson5.groupStudent;

import com.gmail.nikostar0709.lesson5.groupStudent.exceptions.GroupOverflowException;
import com.gmail.nikostar0709.lesson5.groupStudent.exceptions.IllegalCSVFileStudentFormatException;
import com.gmail.nikostar0709.lesson5.groupStudent.exceptions.IllegalStudentsGroupFormatException;

import java.io.File;
import java.io.FileNotFoundException;

public class DemoGroup {

    public static void main(String[] args) {
        File workFolder = new File("src\\com\\gmail\\nikostar0709\\lesson5\\groupStudent\\");
        GroupFileStorage gfs = new GroupFileStorage();
        Group studentsGroup = null;
        try {
            studentsGroup = gfs.loadGroupFromCSV(gfs.findFileByGroupName("bestgroup", workFolder));
        } catch (IllegalCSVFileStudentFormatException | GroupOverflowException | FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(studentsGroup);
        try {
            studentsGroup.addStudent();
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }
        studentsGroup.setGroupName("bestgroupWithSpiderman");
        try {
            gfs.saveGroupToCSV(studentsGroup);
        } catch (IllegalStudentsGroupFormatException e) {
            e.printStackTrace();
        }
        Group spidermanGroup = null;
        try {
            spidermanGroup = gfs.loadGroupFromCSV(gfs.findFileByGroupName("bestgroupWithSpiderman", workFolder));
            studentsGroup = gfs.loadGroupFromCSV(gfs.findFileByGroupName("bestgroup", workFolder));
        } catch (IllegalCSVFileStudentFormatException | GroupOverflowException | FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(studentsGroup);
        System.out.println(spidermanGroup);
    }
}
