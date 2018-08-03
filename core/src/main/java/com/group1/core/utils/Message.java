package com.group1.core.utils;

import java.io.Serializable;
import java.util.Map;

public class Message implements Serializable {

    private String senderId;
    private String receviId;
    private Map<String,Object> map;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceviId() {
        return receviId;
    }

    public void setReceviId(String receviId) {
        this.receviId = receviId;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
