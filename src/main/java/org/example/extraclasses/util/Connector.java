package org.example.extraclasses.util;

import org.example.extraclasses.exception.GetConnectionException;
import org.example.extraclasses.exception.InnitConnectorException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {
    static Logger log = Logger.getLogger(Connector.class.getName());
    private static String jdbsUrl;
    private static String user;
    private static String password;

    public static void init(String jdbsDriver,String jdbsUrl, String user, String password) {
        checkParams(jdbsDriver,jdbsUrl,user,password);
        try {
            Class.forName(jdbsDriver);
            Connector.jdbsUrl = jdbsUrl;
            Connector.user = user;
            Connector.password = password;
            log.info("Driver was been loaded successfully");
        } catch (Exception e) {
            log.log(Level.SEVERE, e.toString());
            throw new InnitConnectorException("Error during load driver",e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbsUrl,user,password);
        } catch (SQLException throwables) {
           throw new GetConnectionException("Error during getting connetion: ", throwables);
        }

    }

    static void checkParams(String ... params) {
        Arrays.asList(params).stream().forEach(param -> {
            if(Objects.isNull(param)) {
                throw new InnitConnectorException("Null param in "+Arrays.toString(params));
            }
        });
    }
}
