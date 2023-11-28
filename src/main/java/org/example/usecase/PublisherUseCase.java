package org.example.usecase;

import org.example.common.constants.StringConstants;
import org.example.db.PublisherDB;
import org.example.interfaces.IPublisher;
import org.example.models.PublisherModel;

import java.util.ArrayList;
import java.util.List;

public class PublisherUseCase implements IPublisher {
    private PublisherDB db;

    public PublisherUseCase(){
        db = PublisherDB.getInstance();
    }
    @Override
    public boolean isSuccessAddPublisher(PublisherModel publisher) {
        return
                db.isAddPublisher(publisher);
    }

    @Override
    public boolean isSuccessEditPublisher(PublisherModel publisher) {
        return db.isUpdatePublisher(publisher);
    }

    @Override
    public String showNotificationRemove(int id) {
        boolean isExisted = db.isExistPublisherInBook(id);
        if(isExisted) {
            return StringConstants.idPublisherExistInBook;
        }
        boolean isSuccessRemove = db.isDeletedPublisher(id);
        if(!isSuccessRemove){
            return StringConstants.connectError;
        }
        return StringConstants.success;
    }


    @Override
    public List<PublisherModel> getPublishers(String keyword) {
         return new ArrayList<>(db.getPublishers(keyword));
    }
}
