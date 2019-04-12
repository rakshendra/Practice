package src.design_patterns.pub_sub.subscriber;

import src.design_patterns.pub_sub.service.PubSubService;

public class SubscriberImpl extends Subscriber {
    @Override
    public void addSubscriber(String topic, PubSubService service) {
        service.addSubscriber(topic, this);
    }

    @Override
    public void unSubscribe(String topic, PubSubService service) {
        service.removeSubscriber(topic, this);
    }

    @Override
    public void getTopicMessageForSubscriber(String topic, PubSubService service) {
        service.getMessagesForSubscriberOfTopic(topic, this);
    }
}
