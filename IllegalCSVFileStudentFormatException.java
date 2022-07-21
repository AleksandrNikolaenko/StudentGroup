package com.gmail.nikostar0709.lesson5.groupStudent.exceptions;

public class IllegalCSVFileStudentFormatException extends Exception{
    public IllegalCSVFileStudentFormatException() {
    }

    public IllegalCSVFileStudentFormatException(String message) {
        super(message);
    }

    public IllegalCSVFileStudentFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalCSVFileStudentFormatException(Throwable cause) {
        super(cause);
    }
}
