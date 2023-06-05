package org.example.extraclasses.util;

import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.service.transaction.Transaction;

import java.sql.Connection;

public interface ServiceFactory extends AutoCloseable {
    Connection getConnection() throws FactoryException;

    Transaction getTransaction() throws FactoryException;
    
}
