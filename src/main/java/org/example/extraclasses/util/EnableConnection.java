package org.example.extraclasses.util;

import java.sql.Connection;
import java.util.logging.Logger;

public class EnableConnection implements Loggable{
    Logger log = getLogger();
    private Connection connection;

    public Connection getConnection() {
        log.info("Get connection: " + connection);
        return connection;
    }

    public void setConnection(Connection connection) {
        log.info("Setup connection: " + connection);
        this.connection = connection;
    }
}
