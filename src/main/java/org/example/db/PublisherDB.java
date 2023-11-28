package org.example.db;

import org.example.common.constants.ResultDataCommon;
import org.example.models.PublisherModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherDB {
    private static PublisherDB instance;
    public static PublisherDB getInstance() {
        if (instance == null) {
            instance = new PublisherDB();
        }
        return instance;
    }

    public List<PublisherModel> getPublishers(String keyword) {
        List<PublisherModel> publishers = new ArrayList<>();
        String sqlUser = "";
        if(keyword.isEmpty()){
            sqlUser = "SELECT * from publishers";
        }else{
            sqlUser = "SELECT * FROM publishers WHERE name LIKE '%"+keyword+"%'";
        }

        try {
            ResultSet rs = ResultDataCommon.getResult(sqlUser);
            while (rs.next()){
                PublisherModel publisher = PublisherModel.parsePublisher(rs);
                publishers.add(publisher);
            }
            return  publishers;
        }catch (SQLException exp){
            System.out.println("Error "+exp);
        }
        return null;
    }

    public boolean isUpdatePublisher(PublisherModel publisher) {
        String sqlUser = "Update publishers set " +
                "name='"+ publisher.name +"'"+
                "where id='"+publisher.id+"'";
        try {
            ResultDataCommon.executeUpdateData(sqlUser);
            return true;
        }catch (SQLException exp){
            System.out.println(exp);
            return false;
        }
    }

    public boolean isAddPublisher(PublisherModel publisher) {
        String sqlUser =
                "Insert Into publishers " +
                        "(name) values ('"
                        +publisher.name+"')";
        try {
            ResultDataCommon.executeUpdateData(sqlUser);
            return  true;
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return false;
    }

    public boolean isDeletedPublisher(int id) {
        String sqlDelete = "Delete from publishers where id='"+id+"'";
        try {
            ResultDataCommon.executeUpdateData(sqlDelete);
            return true;
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return true;
    }

    public boolean isExistPublisherInBook(int id) {
        String sqlDelete = "Select name from books where id_publisher='"+id+"'";
        try {
            ResultSet rs = ResultDataCommon.getResult(sqlDelete);
            return rs.next();
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return true;
    }
}
