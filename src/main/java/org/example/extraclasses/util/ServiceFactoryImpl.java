package org.example.extraclasses.util;

import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.dao.impl.SubjectDaoImpl;
import org.example.extraclasses.dao.impl.UserDaoImpl;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.exception.GetConnectionException;
import org.example.extraclasses.service.subject.SubjectService;
import org.example.extraclasses.service.subject.SubjectServiceImpl;
import org.example.extraclasses.service.transaction.Transaction;
import org.example.extraclasses.service.transaction.TransactionImpl;
import org.example.extraclasses.service.user.UserService;
import org.example.extraclasses.service.user.UserServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceFactoryImpl implements ServiceFactory {
    private Connection connection;

    @Override
    public Connection getConnection() throws FactoryException {
        if (connection == null) {
            try {
                connection = Connector.getConnection();
            } catch (GetConnectionException e) {
                throw new FactoryException(e);
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
    public SubjectService getSubjectService() throws FactoryException {
        SubjectServiceImpl subjectService = new SubjectServiceImpl(getSubjectDao(),getUserDao());
        subjectService.setTransaction(getTransaction());
        return subjectService;
    }

    @Override
    public UserService getUserService() throws FactoryException {
        UserServiceImpl userService = new UserServiceImpl(getUserDao());
        userService.setTransaction(getTransaction());
        return userService;
    }

    @Override
    public SubjectDao getSubjectDao() throws FactoryException {
        SubjectDaoImpl subjectDao = new SubjectDaoImpl();
        subjectDao.setConnection(getConnection());
        return subjectDao;
    }

    @Override
    public UserDao getUserDao() throws FactoryException {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setConnection(getConnection());
        return userDao;
    }

    @Override
    public void close() throws Exception {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new FactoryException("Error during close connection: ", e);
        }

    }
}
