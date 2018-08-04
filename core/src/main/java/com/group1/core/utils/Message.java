package com.group1.core.utils;

import java.io.Serializable;
import java.util.Map;

public class Message implements Serializable {

    private String senderId;
    private String receiverId;
    private Map<String,Object> map;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Message(String senderId, String receiverId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public Message() {
    }
}
