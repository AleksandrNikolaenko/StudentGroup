package com.gmail.nikostar0709.lesson5.groupStudent.exceptions;

public class IllegalFormatNameException extends Exception{
    public IllegalFormatNameException() {
    }

    public IllegalFormatNameException(String message) {
        super(message);
    }

    public IllegalFormatNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFormatNameException(Throwable cause) {
        super(cause);
    }
}
