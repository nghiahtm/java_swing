package org.example.db;

import org.example.common.constants.ResultDataCommon;
import org.example.models.AuthorModel;
import org.example.models.GenreModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDB {
    private static GenreDB instance;
    public static GenreDB getInstance() {
        if (instance == null) {
            instance = new GenreDB();
        }
        return instance;
    }

    public List<GenreModel> getGenres() {
        List<GenreModel> genres = new ArrayList<>();
        String sqlUser = "SELECT * from genres";
        try {
            ResultSet rs = ResultDataCommon.getResult(sqlUser);
            while (rs.next()){
                GenreModel genre = GenreModel.parseGenre(rs);
                genres.add(genre);
            }
            return  genres;
        }catch (SQLException exp){
            System.out.println("Error "+exp);
        }
        return null;
    }

    public boolean isExistInBookData(int id){
        String sqlUser = "SELECT name from books where id_genre='"+id+"'";
        ResultSet rs = null;
        try {
            rs = ResultDataCommon.getResult(sqlUser);
            while (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void isSuccessRemove(int id){
        String sqlUser = "Delete from genres where id_genre='"+id+"'";
        try {
           ResultDataCommon.executeUpdateData(sqlUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isUpdateGenre(GenreModel genre) {
        String sqlUser = "Update genres set " +
                "name='"+ genre.name +"'"+
                "where id_genre='"+genre.id+"'";
        try {
            ResultDataCommon.executeUpdateData(sqlUser);
            return true;
        }catch (SQLException exp){
            System.out.println(exp);
            return false;
        }
    }

    public boolean isAddGenre(GenreModel genreModel) {
        String sqlUser =
                "Insert Into genres " +
                        "(name) values ('"
                        +genreModel.name+"')";
        try {
            ResultDataCommon.executeUpdateData(sqlUser);
            return  true;
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return false;
    }
}
