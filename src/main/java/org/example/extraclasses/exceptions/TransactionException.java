package org.example.extraclasses.exceptions;

public class TransactionException extends Exception {
    public TransactionException(Throwable throwable) {
        super(throwable);
    }

    public TransactionException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
