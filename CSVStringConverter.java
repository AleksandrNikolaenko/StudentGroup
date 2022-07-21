package com.gmail.nikostar0709.lesson5.groupStudent;

import com.gmail.nikostar0709.lesson5.groupStudent.exceptions.*;

public class CSVStringConverter implements StringConverter {

    private final StudentTools studentTools = new StudentTools();

    @Override
    public String toStringRepresentation(Student student) {

        StringBuilder sb = new StringBuilder();
        try {
            addStudentNameInCSVString(student, sb);
            sb.append(",");
            addStudentLastNameInCSVString(student, sb);
            sb.append(",");
            addStudentGenderInCSVString(student, sb);
            sb.append(",");
            addStudentIDInCSVString(student, sb);
            sb.append(",");
            addStudentGroupNameInCSVString(student, sb);
        } catch (IllegalFormatNameException | IllegalFormatLastNameException | IllegalFormatGenderException |
                 IllegalFormatIDException | IllegalFormatGroupNameException e) {
            e.printStackTrace();
            sb = null;
        }
        return (sb == null) ? null : sb.toString();
    }

    @Override
    public Student fromStringRepresentation(String str) {
        String[] arrayFromStudentField = str.split(",");
        try {
            if (arrayFromStudentField.length != 5) throw new IllegalCSVStringFormatStudentException("illegal CSV format");
        } catch (IllegalCSVStringFormatStudentException e) {
            e.printStackTrace();
            return null;
        }

        Student student = new Student();
        try {
            setStudentName(student, arrayFromStudentField[0]);
            setStudentLastName(student, arrayFromStudentField[1]);
            setStudentGender(student, arrayFromStudentField[2]);
            setStudentID(student, arrayFromStudentField[3]);
            setStudentGroupName(student, arrayFromStudentField[4]);
        } catch (IllegalFormatNameException | IllegalFormatLastNameException | IllegalFormatGenderException |
                 IllegalFormatIDException | IllegalFormatGroupNameException e) {
            e.printStackTrace();
            student = null;
        }
        return student;
    }

    private void addStudentNameInCSVString(Student student, StringBuilder sb) throws IllegalFormatNameException {
        if (studentTools.isWord(student.getName())) {
            sb.append(studentTools.getWordFormatToLowerCaseAndToUpperCaseFirstChar(student.getName()));
        } else {
            throw new IllegalFormatNameException("illegal 'name' format");
        }
    }

    private void addStudentLastNameInCSVString(Student student, StringBuilder sb) throws IllegalFormatLastNameException {
        if (studentTools.isWord(student.getLastName())) {
            sb.append(studentTools.getWordFormatToLowerCaseAndToUpperCaseFirstChar(student.getLastName()));
        } else {
            throw new IllegalFormatLastNameException("illegal 'lastName' format");
        }
    }

    private void addStudentGenderInCSVString(Student student, StringBuilder sb) throws IllegalFormatGenderException {
        if (studentTools.isGender(student.getGender().toString())) {
            sb.append(student.getGender().toString());
        } else {
            throw new IllegalFormatGenderException("illegal 'gender' format");
        }
    }

    private void addStudentIDInCSVString(Student student, StringBuilder sb) throws IllegalFormatIDException {
        if (studentTools.isID(Integer.toString(student.getId()))) {
            sb.append(student.getId());
        } else {
            throw new IllegalFormatIDException("illegal 'id' format");
        }
    }

    private void addStudentGroupNameInCSVString(Student student, StringBuilder sb) throws IllegalFormatGroupNameException {
        if (studentTools.isGroupName(student.getGroupName())) {
            sb.append(student.getGroupName());
        } else {
            throw new IllegalFormatGroupNameException("illegal 'groupName format");
        }
    }

    private void setStudentName(Student student, String name) throws IllegalFormatNameException {
        if (studentTools.isWord(name)) {
            student.setName(studentTools.getWordFormatToLowerCaseAndToUpperCaseFirstChar(name));
        } else {
            throw new IllegalFormatNameException("illegal 'name' format");
        }
    }

    private void setStudentLastName(Student student, String lastName) throws IllegalFormatLastNameException {
        if (studentTools.isWord(lastName)) {
            student.setLastName(studentTools.getWordFormatToLowerCaseAndToUpperCaseFirstChar(lastName));
        } else {
            throw new IllegalFormatLastNameException("illegal 'lastName' format");
        }
    }

    private void setStudentGender(Student student, String gender) throws IllegalFormatGenderException {
        if (studentTools.isGender(gender)) {
            student.setGender(studentTools.getGenderFromString(gender));
        } else {
            throw new IllegalFormatGenderException("illegal 'gender' format");
        }
    }

    private void setStudentID(Student student, String id) throws IllegalFormatIDException {
        if (studentTools.isID(id)) {
            student.setId(Integer.parseInt(id));
        } else {
            throw new IllegalFormatIDException("illegal 'id' format");
        }
    }

    private void setStudentGroupName(Student student, String groupName) throws IllegalFormatGroupNameException {
        if (studentTools.isGroupName(groupName)) {
            student.setGroupName(groupName);
        } else {
            throw new IllegalFormatGroupNameException("illegal 'group' format");
        }
    }

    @Override
    public String toString() {
        return "CSVStringConverter{" +
                "studentTools=" + studentTools +
                '}';
    }
}
