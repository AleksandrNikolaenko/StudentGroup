package com.gmail.nikostar0709.lesson5.groupStudent.exceptions;

public class IllegalFormatLastNameException extends Exception{
    public IllegalFormatLastNameException() {
    }

    public IllegalFormatLastNameException(String message) {
        super(message);
    }

    public IllegalFormatLastNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFormatLastNameException(Throwable cause) {
        super(cause);
    }
}
