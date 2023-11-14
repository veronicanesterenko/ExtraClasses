package org.example.extraclasses.exception;

public class UserDaoException extends RuntimeException {
    public UserDaoException (String msg, Throwable t) {
        super(msg,t);
    }

    public UserDaoException(String msg) {
        super(msg);
    }
}
