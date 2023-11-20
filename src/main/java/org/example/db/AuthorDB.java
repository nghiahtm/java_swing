package org.example.db;
import org.example.common.constants.ResultDataCommon;
import org.example.models.AuthorModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDB {
    private static AuthorDB instance;
    public static AuthorDB getInstance() {
        if (instance == null) {
            instance = new AuthorDB();
        }
        return instance;
    }
    public List<AuthorModel> getAuthors() {
        List<AuthorModel> authors = new ArrayList<>();
        String sqlUser = "SELECT * from authors";
        try {
            ResultSet rs = ResultDataCommon.getResult(sqlUser);
            while (rs.next()){
                AuthorModel author = AuthorModel.parseAuthor(rs);
                authors.add(author);
            }
            return  authors;
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return null;
    }
    public boolean isAddAuthorSuccess(AuthorModel authorModel) {
        String sqlUser =
                "Insert Into authors " +
                        "(name,date,title) values ('"
                        +authorModel.getName()+"','"+authorModel.getDob()+"','"
                        +authorModel.getTitle() +"')";
        try {
            ResultDataCommon.executeUpdateData(sqlUser);
            return  true;
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return false;
    }

    public AuthorModel getAuthor(int id) {
        String sqlUser = "SELECT * from authors where id_author='"+id+"'";
        List<AuthorModel> authors = new ArrayList<>();
        try {
            ResultSet rs = ResultDataCommon.getResult(sqlUser);
            while (rs.next()){
                AuthorModel author = AuthorModel.parseAuthor(rs);
                authors.add(author);
            }
            return  authors.get(0);
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return null;
    }
}
