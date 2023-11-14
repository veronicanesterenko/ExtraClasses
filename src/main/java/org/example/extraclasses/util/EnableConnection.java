package org.example.extraclasses.util;

import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.exception.GetConnectionException;

import java.sql.Connection;
import java.util.logging.Logger;

public class EnableConnection implements  Loggable{
    private final Logger log = getLogger();
    private Connection connection;

    public Connection getConnection() {
        log.info("In getConnection         :"+ connection);
        return connection;
    }

    public void setConnection(Connection connection) {
        log.info("from setConnection     :" + connection);
        this.connection = connection;
    }
}
