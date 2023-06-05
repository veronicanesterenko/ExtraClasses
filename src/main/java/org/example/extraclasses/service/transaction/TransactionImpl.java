package org.example.extraclasses.service.transaction;

import org.example.extraclasses.exception.TransactionException;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionImpl implements Transaction {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void begin() throws TransactionException {
        try {
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new TransactionException("Begin transaction error: ",e);
        }
    }

    @Override
    public void commit() throws TransactionException {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new TransactionException("Commit transaction error: ",e);
        }

    }

    @Override
    public void rollback() throws TransactionException {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new TransactionException("Rollback transaction error: ",e);
        }
    }
}
