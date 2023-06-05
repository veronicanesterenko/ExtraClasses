package org.example.extraclasses.exception;

public class FactoryException extends Exception{
    public FactoryException(String msg,Throwable cause) {
        super(msg,cause);
    }

    public FactoryException(String msg) {
        super( msg);
    }

    public FactoryException(Throwable cause) {
        super(cause);
    }
}
