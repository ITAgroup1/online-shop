package com.group1.core.utils.jms;

import javax.jms.Destination;

public interface ProducerService {

    /**
     * 向指定队列发送消息
     */
    void sendMessage(Destination destination, final String msg);
    /**
     * 向默认队列发送消息
     */
    void sendMessage(final String msg);
}
