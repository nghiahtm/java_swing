package org.example.models;

import org.example.common.ConnectionString;
import org.example.common.constants.DateFormatConstant;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class AuthorModel {
    final private Integer id;
    final private String name;
    final private String dob;
    final private String title;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getTitle() {
        return title;
    }

    public AuthorModel(Integer id, String name, String dob, String title) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.title = title;
    }

    public static AuthorModel parseAuthor(ResultSet rs){
        int id = ConnectionString.parseIntMySQL(rs,"id_author");
        String name = ConnectionString.parseStringMySQL(rs,"name");
        SimpleDateFormat dateDB = new SimpleDateFormat(DateFormatConstant.dateVi);
        String dob = dateDB.format(ConnectionString.parseDateDB(rs,"date"));
        String title = ConnectionString.parseStringMySQL(rs,"title");
        return new AuthorModel(
                id,
                name,
                dob,
                title
        );
    }
}
