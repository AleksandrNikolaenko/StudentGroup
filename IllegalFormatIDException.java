package com.gmail.nikostar0709.lesson5.groupStudent.exceptions;

public class IllegalFormatIDException extends Exception{
    public IllegalFormatIDException() {
    }

    public IllegalFormatIDException(String message) {
        super(message);
    }

    public IllegalFormatIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFormatIDException(Throwable cause) {
        super(cause);
    }
}
