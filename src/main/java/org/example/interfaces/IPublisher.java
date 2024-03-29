package org.example.interfaces;
import org.example.models.PublisherModel;

import java.util.List;

public interface IPublisher {
    public boolean isSuccessAddPublisher(PublisherModel publisher);
    public boolean isSuccessEditPublisher(PublisherModel publisher);
    public String showNotificationRemove(int id);
    public List<PublisherModel> getPublishers(String keyword);
}
