package org.example.extraclasses.util;

import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.exception.GetConnectionException;
import org.example.extraclasses.service.transaction.Transaction;
import org.example.extraclasses.service.transaction.TransactionImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceFactoryImpl implements ServiceFactory{
    private  Connection connection;

    @Override
    public Connection getConnection() throws FactoryException {

        if(connection == null) {
            try {
                connection = Connector.getConnection();
            } catch (GetConnectionException e) {
                throw  new FactoryException(e);
            }
        }
                return connection;
    }

    @Override
    public Transaction getTransaction() throws FactoryException {
        TransactionImpl transaction = new TransactionImpl();
        transaction.setConnection(getConnection());
        return transaction;
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            throw new FactoryException("Error during close connection: ",e);
        }

    }
}
