package com.example.amrthaku.feedbackform;

/**
 * Created by amrthaku on 1/18/2018.
 */

public class Feedback {

    String id,content,topic,enjoyment,comment;

    public Feedback() {
    }

    public Feedback(String id, String content, String topic, String enjoyment, String comment) {
        this.id = id;
        this.content = content;
        this.topic = topic;
        this.enjoyment = enjoyment;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEnjoyment() {
        return enjoyment;
    }

    public void setEnjoyment(String enjoyment) {
        this.enjoyment = enjoyment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                ", enjoyment='" + enjoyment + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
