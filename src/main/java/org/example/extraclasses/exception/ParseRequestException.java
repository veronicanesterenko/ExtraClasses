package org.example.extraclasses.exception;

public class ParseRequestException extends RuntimeException{
    public ParseRequestException(String msg, Throwable e) {
        super(msg,e);
    }

}
