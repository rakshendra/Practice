package src.design_patterns.pub_sub.service;

import src.design_patterns.pub_sub.Message;
import src.design_patterns.pub_sub.subscriber.Subscriber;
import src.design_patterns.pub_sub.subscriber.SubscriberImpl;

import java.util.*;

public class PubSubService {
    private Map<String, Set<Subscriber>> topicSubscribers = new HashMap<>();
    private Queue<Message> messageQueue = new LinkedList<>();

    public void addMessageToQueue(Message message) {
        messageQueue.add(message);
    }

    public void addSubscriber(String topic, SubscriberImpl subscriber) {
        if(topicSubscribers.containsKey(topic)){
            topicSubscribers.get(topic).add(subscriber);
        }else{
            Set<Subscriber> subscribers = new HashSet<>();
            subscribers.add(subscriber);
            topicSubscribers.put(topic, subscribers);
        }
    }

    public void removeSubscriber(String topic, SubscriberImpl subscriber) {
        if(topicSubscribers.containsKey(topic)){
            topicSubscribers.get(topic).remove(subscriber);
        }
    }

    public void getMessagesForSubscriberOfTopic(String topic, SubscriberImpl subscriber) {
        while(!messageQueue.isEmpty()){
            Message message = messageQueue.remove();
            //to-do
        }
    }
}
