package com.gilxyj.component;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @program: activemq02
 * @description:
 * @author: GilbertXiao
 * @create: 2019-07-14 22:23
 **/
@Component
public class MyMessageListener implements MessageListener {

    public void onMessage(Message message) {
        String text = null;
        try {
            text = ((TextMessage) message).getText();
        } catch (JMSException e) {
            e.printStackTrace();
        }

        System.out.println("收到消息："+text);
    }
}
