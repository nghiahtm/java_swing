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

    public List<PublisherModel> getPublishers() {
        List<PublisherModel> publishers = new ArrayList<>();
        String sqlUser = "SELECT * from publishers";
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
}
