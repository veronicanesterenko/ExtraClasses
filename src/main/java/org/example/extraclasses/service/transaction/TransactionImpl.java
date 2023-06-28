package org.example.extraclasses.service.transaction;

import org.example.extraclasses.exceptions.TransactionException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;


public class TransactionImpl implements Transaction {
    private Connection connection;
    private static final Logger log = Logger.getLogger(TransactionImpl.class.getName());


    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void begin() throws TransactionException {
        log.info("begin transaction");
        try {
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new TransactionException("Begin transaction error: ", e);
        }
    }

    @Override
    public void commit() throws TransactionException {
        log.info("commit");
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new TransactionException("Commit transaction error: ", e);
        }
    }

    @Override
    public void rollback() throws TransactionException {
        log.info("rollback");
        try {

            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new TransactionException("Rollback transaction error: ", e);
        }
    }
}
