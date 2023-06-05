package org.example.extraclasses.exception;

public class InnitConnectorException extends RuntimeException {
    public InnitConnectorException(String msg, Throwable e) {
        super(msg,e);
    }
    public InnitConnectorException (String msg) {
        super(msg);
    }
}
