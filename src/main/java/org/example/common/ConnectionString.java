package org.example.common;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ConnectionString {
    public static String parseStringMySQL(ResultSet resultSet,String attribute) {
        String parse;
        try {
            parse = resultSet.getString(attribute);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return parse;
    }

    public static int parseIntMySQL(ResultSet resultSet,String attribute) {
        int parse;
        try {
            if(resultSet.getString(attribute) == null){
                return 0;
            }else {
                parse = Integer.parseInt(resultSet.getString(attribute));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return parse;
    }

    @SuppressWarnings("deprecation")
    public static Date parseDateDB(ResultSet resultSet, String attribute) {
        Date date;
        try {
            if(resultSet.getDate(attribute) == null){
                return new Date(1900);
            }else {
                date = resultSet.getDate(attribute);
                return new Date(date.getYear(), date.getMonth(), date.getDate());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
