package org.example.presentations.PublisherScreen;

import org.example.models.PublisherModel;
import org.example.usecase.PublisherUseCase;

import java.util.List;

public class PublisherController {
    final PublisherUseCase useCase;

    public PublisherController() {
        useCase = new PublisherUseCase();
    }

    List<PublisherModel> getPublishers(){
        return useCase.getPublishers();
    }
}
