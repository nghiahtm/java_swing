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

    public boolean isUpdateAuthor(AuthorModel author) {
        String sqlUser = "Update authors set " +
                "name='"+ author.getName()+"',"+
                "date='"+ author.getDob()+"',"+
                "title='"+ author.getTitle()+"'"+
                "where id_author='"+author.getId()+"'";
        try {
            ResultDataCommon.executeUpdateData(sqlUser);
            return true;
        }catch (SQLException exp){
            System.out.println(exp);
            return false;
        }
    }

    public void isDeletedAuthor(int id) {
        String sqlDelete = "Delete from authors where id_author='"+id+"'";
        try {
            ResultDataCommon.executeUpdateData(sqlDelete);
        }catch (SQLException exp){
            System.out.println(exp);
        }
    }

    public boolean isExistAuthorInBook(int id) {
        String sqlDelete = "Select name from books where id_author='"+id+"'";
        try {
            ResultSet rs = ResultDataCommon.getResult(sqlDelete);
            while (rs.next()){
                System.out.println(rs.next());
                return true;
            }
            return false;
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return true;
    }
}
