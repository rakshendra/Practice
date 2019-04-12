package src.design_patterns.pub_sub.publisher;

import src.design_patterns.pub_sub.Message;
import src.design_patterns.pub_sub.service.PubSubService;

public interface Publisher {
    void publish(Message message, PubSubService service);
}
