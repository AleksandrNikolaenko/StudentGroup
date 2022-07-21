package com.gmail.nikostar0709.lesson5.groupStudent;

import com.gmail.nikostar0709.lesson5.groupStudent.exceptions.*;
import java.util.Arrays;
import java.util.Comparator;

public class Group {

    private String groupName;
    private Student[] students = new Student[10];
    private final StudentTools studentTools = new StudentTools();

    public Group() {
    }

    public Group(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException, IllegalFormatNameException,
            IllegalFormatLastNameException, IllegalFormatGenderException,
            IllegalFormatIDException, IllegalFormatGroupNameException {

        Integer freeIndex = getFreeIndex();
        if (freeIndex == null) throw new GroupOverflowException("Group overflow");
        if (student.getName() == null) throw new IllegalFormatNameException("because name is null");
        if (!studentTools.isWord(student.getName())) throw new IllegalFormatNameException("illegal name format");
        if (student.getLastName() == null) throw new IllegalFormatLastNameException("because lastName is null");
        if (!studentTools.isWord(student.getLastName())) throw new IllegalFormatLastNameException("illegal lastName format");
        if (student.getGender() == null) throw new IllegalFormatGenderException("because gender is null");
        if (student.getId() < 1) throw new IllegalFormatIDException("illegal id format");
        if (student.getGroupName() == null) throw new IllegalFormatGroupNameException("because groupName is null");
        if (!studentTools.isGroupName(student.getGroupName())) throw new IllegalFormatGroupNameException("illegal groupName  format");
        student.setName(studentTools.getWordFormatToLowerCaseAndToUpperCaseFirstChar(student.getName()));
        student.setLastName(studentTools.getWordFormatToLowerCaseAndToUpperCaseFirstChar(student.getLastName()));
        students[freeIndex] = student;
    }

    public void addStudent() throws GroupOverflowException {
        Integer freeIndex = getFreeIndex();
        if (freeIndex == null) throw new GroupOverflowException("Group overflow");
        students[freeIndex] = studentTools.getNewStudent();
    }

    private Integer getFreeIndex(){
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) return i;
        }
        return null;
    }

    public Student getStudentByLastName(String lastName) throws StudentNotFoundException {
        Integer studentIndex = getStudentIndex(lastName);
        if (studentIndex == null) throw new StudentNotFoundException("Student not found");
        return students[studentIndex];
    }

    private Integer getStudentIndex(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getLastName() != null && students[i].getLastName().equals(lastName)) return i;
        }
        return null;
    }

    private Integer getStudentIndex(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) return i;
        }
        return null;
    }

    public boolean removeStudentByID(int id) {
        Integer studentIndex = getStudentIndex(id);
        if (studentIndex == null) return false;
        students[studentIndex] = null;
        return true;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public StudentTools getStudentTools() {
        return studentTools;
    }

    public void sortStudentByLastName() {
        Arrays.sort(students, Comparator.nullsLast(new GroupComparator()));
    }

    private String createToString() {
        StringBuilder sb  = new StringBuilder("\nStudent group : " + groupName + "\n");
        int amountStudents = 0;
        for (Student student : students) {
            if (student != null) {
                sb.append(student).append("\n");
                amountStudents++;
            }
        }
        if (amountStudents == 0) sb.append("empty\n");
        else sb.append("Students in group: ").append(amountStudents).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        sortStudentByLastName();
        return createToString();
    }
}
