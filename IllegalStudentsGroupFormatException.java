package com.gmail.nikostar0709.lesson5.groupStudent.exceptions;

public class IllegalStudentsGroupFormatException extends Exception{
    public IllegalStudentsGroupFormatException() {
    }

    public IllegalStudentsGroupFormatException(String message) {
        super(message);
    }

    public IllegalStudentsGroupFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalStudentsGroupFormatException(Throwable cause) {
        super(cause);
    }
}
