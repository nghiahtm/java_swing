package org.example.models;

import org.example.common.ConnectionString;

import java.sql.ResultSet;

public class PublisherModel {
    final public Integer id;
    final public String name;

    public PublisherModel(Integer id, String name) {
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

    @Override
    public String toString() {
        return "PublisherModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
