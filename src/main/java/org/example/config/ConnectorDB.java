package org.example.config;
import org.example.common.constants.ConnectorConstants;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class ConnectorDB {

    private static ConnectorDB instance;
    public static Connection connection;


    private ConnectorDB() {
        try {
            connection = getConnection(
                    ConnectorConstants.localhost,ConnectorConstants.user,
                    ConnectorConstants.password);
        } catch (SQLException e) {
            System.out.println("success");
            throw new RuntimeException(e);
        }
    }

    public static ConnectorDB getInstance() {
        if (instance == null) {
            instance = new ConnectorDB();
        }
        return instance;
    }


}
