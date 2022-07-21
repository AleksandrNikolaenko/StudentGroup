package com.gmail.nikostar0709.lesson5.groupStudent.exceptions;

public class IllegalCSVStringFormatStudentException extends Exception{
    public IllegalCSVStringFormatStudentException() {
    }

    public IllegalCSVStringFormatStudentException(String message) {
        super(message);
    }

    public IllegalCSVStringFormatStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalCSVStringFormatStudentException(Throwable cause) {
        super(cause);
    }
}
