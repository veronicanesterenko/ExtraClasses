package org.example.extraclasses.exceptions;

public class ParseRequestException extends RuntimeException {
    public ParseRequestException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
