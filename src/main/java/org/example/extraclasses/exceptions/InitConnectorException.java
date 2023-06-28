package org.example.extraclasses.exceptions;

public class InitConnectorException extends RuntimeException {
    public InitConnectorException(String msg, Throwable e) {
        super(msg, e);
    }

    public InitConnectorException(String msg) {
        super(msg);
    }
}
