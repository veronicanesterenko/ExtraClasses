package org.example.extraclasses.exceptions;

public class GetConnectionException extends RuntimeException{
    public GetConnectionException(String msg, Throwable e) {
        super(msg,e);
    }
}
