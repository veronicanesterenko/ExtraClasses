package org.example.extraclasses.exception;

public class GetConnectionException  extends RuntimeException {
    public GetConnectionException(String msg, Throwable e) {
        super(msg, e);
    }
}
