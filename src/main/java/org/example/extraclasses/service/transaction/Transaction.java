package org.example.extraclasses.service.transaction;

import org.example.extraclasses.exceptions.TransactionException;

public interface Transaction {
    void begin() throws TransactionException;

    void commit() throws TransactionException;

    void rollback() throws TransactionException;
}
