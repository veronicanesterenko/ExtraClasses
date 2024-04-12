package org.example.extraclasses.exception;



public class TransactionException extends Exception {
    public TransactionException(Throwable throwable) {
        super(throwable);
    }
    public TransactionException(String msg,Throwable throwable) {
        super(msg,throwable);
    }
}
