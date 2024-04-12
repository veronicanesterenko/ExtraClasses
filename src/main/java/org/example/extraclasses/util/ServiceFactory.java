package org.example.extraclasses.util;

import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.service.subject.SubjectService;
import org.example.extraclasses.service.transaction.Transaction;
import org.example.extraclasses.service.user.UserService;

import java.sql.Connection;

public interface ServiceFactory extends AutoCloseable {
    Connection getConnection() throws FactoryException;

    Transaction getTransaction() throws FactoryException;

    SubjectService getSubjectService() throws FactoryException;

    UserService getUserService() throws FactoryException;

    SubjectDao getSubjectDao() throws FactoryException;

    UserDao getUserDao() throws FactoryException;

    
}
