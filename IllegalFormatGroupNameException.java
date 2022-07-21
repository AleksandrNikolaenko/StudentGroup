package com.gmail.nikostar0709.lesson5.groupStudent.exceptions;

public class IllegalFormatGroupNameException extends Exception{
    public IllegalFormatGroupNameException() {
    }

    public IllegalFormatGroupNameException(String message) {
        super(message);
    }

    public IllegalFormatGroupNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFormatGroupNameException(Throwable cause) {
        super(cause);
    }
}
