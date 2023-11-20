package org.example.db;
import org.example.common.ConnectionString;
import org.example.common.constants.ResultDataCommon;
import org.example.config.ConnectorDB;
import org.example.models.Authorization;
import org.example.models.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDB {

    private static LoginDB instance;
    public static LoginDB getInstance() {
        if (instance == null) {
            instance = new LoginDB();
        }
        return instance;
    }
    public UserModel getUser(Authorization auth){
        List<UserModel> user = new ArrayList<>();
        try {
            UserModel userLogin = new UserModel("");
            String sqlUser = "SELECT * from user_name where username = '"+auth.userName+"' and password ='"+ auth.password +"'";
            ResultSet rs = ResultDataCommon.getResult(sqlUser);
            if (rs.next()) {
                userLogin = new UserModel(ConnectionString.parseStringMySQL(rs,"username"));
                user.add(userLogin);
            }else{
                return userLogin;
            }
            ConnectorDB.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user.get(0));
        return user.get(0);
    }
}
