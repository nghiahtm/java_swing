package org.example.models;

import org.example.common.ConnectionString;

import java.sql.ResultSet;

public class PublisherModel {
    final public int id;
    final public String name;

    public PublisherModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static PublisherModel parsePublisher(ResultSet rs){
        int id = ConnectionString.parseIntMySQL(rs,"id");
        String name = ConnectionString.parseStringMySQL(rs,"name");
      return new PublisherModel(
            id,name
      );
    }
}
