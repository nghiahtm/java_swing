package org.example.usecase;

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
    public boolean isSuccessPublisher(PublisherModel publisher) {
        return false;
    }

    @Override
    public boolean isSuccessEditPublisher(PublisherModel publisher) {
        return false;
    }

    @Override
    public boolean isSuccessRemovePublisher(int id) {
        return false;
    }

    @Override
    public List<PublisherModel> getPublishers() {
         return new ArrayList<>(db.getPublishers());
    }
}
