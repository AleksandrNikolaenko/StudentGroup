package com.gmail.nikostar0709.lesson5.groupStudent.exceptions;

public class IllegalFormatGenderException extends Exception{
    public IllegalFormatGenderException() {
    }

    public IllegalFormatGenderException(String message) {
        super(message);
    }

    public IllegalFormatGenderException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFormatGenderException(Throwable cause) {
        super(cause);
    }
}
