package com.gmail.nikostar0709.lesson5.groupStudent;

import java.util.Comparator;

public class GroupComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;
        String lastName1 = student1.getLastName();
        String lastName2 = student2.getLastName();
        if (lastName1.compareToIgnoreCase(lastName2) > 0) return 1;
        if (lastName1.compareToIgnoreCase(lastName2) < 0) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "GroupComparator{not has fields}";
    }
}
