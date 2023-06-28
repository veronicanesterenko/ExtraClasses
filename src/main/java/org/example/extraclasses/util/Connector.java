package org.example.extraclasses.util;

import org.example.extraclasses.exceptions.GetConnectionException;
import org.example.extraclasses.exceptions.InitConnectorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {
    static Logger log = Logger.getLogger(Connector.class.getName());
    private static String jdbcUrl;
    private static String user;
    private static String password;


    public static void init(String jdbcDriver, String jdbcUrl, String user, String password) {
        checkParams(jdbcDriver, jdbcUrl, user, password);
        try {
            Class.forName(jdbcDriver);
            Connector.jdbcUrl = jdbcUrl;
            Connector.user = user;
            Connector.password = password;
            log.info("Driver was been loaded successfully");
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getCause().toString());
            throw new InitConnectorException("Error during load driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl, user, password);
        } catch (SQLException throwables) {
            throw new GetConnectionException("Error during getting connection: ", throwables);
        }
    }

    private static void checkParams(String... params) {
        Arrays.stream(params).forEach(param -> {
            if (Objects.isNull(param)) {
                throw new InitConnectorException("Null param in " + Arrays.toString(params));
            }
        });
    }
}
