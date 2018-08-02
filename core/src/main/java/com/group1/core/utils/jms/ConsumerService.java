package com.group1.core.utils.jms;

import javax.jms.Destination;

public interface ConsumerService {
    /**
     * 接受消息
     */
    void receive(Destination destination);
}
