package org.example.extraclasses.exception;

public class SubjectDaoException extends  RuntimeException{
    public SubjectDaoException (String msg,Throwable cause) {
        super(msg,cause);
    }
}
