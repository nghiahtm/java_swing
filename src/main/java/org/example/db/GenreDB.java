package org.example.db;

import org.example.common.constants.ResultDataCommon;
import org.example.models.GenreModel;
import org.example.models.PublisherModel;

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
}
