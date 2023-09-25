package org.example.extraclasses.exceptions;

public class SubjectDaoException extends RuntimeException {
    public SubjectDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
