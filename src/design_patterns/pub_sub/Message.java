package src.design_patterns.pub_sub;

public class Message {
    private String topic;
    private String payLoad;

    public Message() {
    }

    public Message(String topic, String payLoad) {
        this.topic = topic;
        this.payLoad = payLoad;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }
}
