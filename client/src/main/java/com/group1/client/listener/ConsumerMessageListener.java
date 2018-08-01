package com.group1.client.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener  implements MessageListener {

    @Override
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        TextMessage tm=(TextMessage)message;
        try {
            System.out.println("the message received is  "+tm.getText());
            //call method of the service
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
