package org.example.common.constants;

import org.example.config.ConnectorDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDataCommon {
    public static ResultSet getResult (String query) throws SQLException {
        Statement stmt = ConnectorDB.connection.createStatement();
        System.out.println(query);

        return stmt.executeQuery(query);
    }
    public static void executeUpdateData (String query) throws SQLException {
        System.out.println(query);
        Statement stmt = ConnectorDB.connection.createStatement();
        stmt.executeUpdate(query);
    }
}
