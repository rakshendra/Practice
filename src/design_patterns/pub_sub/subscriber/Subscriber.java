package src.design_patterns.pub_sub.subscriber;

import src.design_patterns.pub_sub.Message;
import src.design_patterns.pub_sub.service.PubSubService;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {

    private List<Message> messages = new ArrayList<>();

    public List<Message> getSubscriberMessages(){
        return messages;
    }

    public abstract void addSubscriber(String topic, PubSubService service);

    public abstract void unSubscribe(String topic, PubSubService service);

    public abstract void getTopicMessageForSubscriber(String topic, PubSubService service);

    public void printMessages(){
        for(Message message : messages){
            System.out.println(message);
        }
    }
}
