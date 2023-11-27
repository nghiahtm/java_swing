package org.example.models;

import org.example.common.ConnectionString;

import java.sql.ResultSet;

public class GenreModel {
    final public Integer id;
    final public String name;

    public GenreModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static GenreModel parseGenre(ResultSet rs){
        int id = ConnectionString.parseIntMySQL(rs,"id_genre");
        String name = ConnectionString.parseStringMySQL(rs,"name");
        return new GenreModel(
                id,name
        );
    }
}
