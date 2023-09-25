package org.example.extraclasses.exceptions;

public class UserDaoException extends RuntimeException {
    public UserDaoException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserDaoException(String s) {
        super(s);
    }
}
