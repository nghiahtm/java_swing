package org.example.presentations.PublisherScreen;

import org.example.models.GenreModel;
import org.example.models.PublisherModel;
import org.example.usecase.PublisherUseCase;

import java.util.ArrayList;
import java.util.List;

public class PublisherController {
    final PublisherUseCase useCase;

    public PublisherController() {
        useCase = new PublisherUseCase();
    }

    List<PublisherModel> getPublishers(String keyword){
        List<PublisherModel> publishers = new
                ArrayList<>();
        for(PublisherModel publisher: useCase.getPublishers(keyword)){
            publishers.add(publisher);
            if(publisher.id == 0){
                publishers.remove(0);
            }
        }
        return publishers;
    }

    String removePublisher(int id){
        return useCase.showNotificationRemove(id);
    }
    boolean isEditPublisher (PublisherModel publisher){
        return  useCase.isSuccessEditPublisher(publisher);
    }

    boolean isAddPublisher (PublisherModel publisher){
        return  useCase.isSuccessAddPublisher(publisher);
    }
}
