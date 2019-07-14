package com.gilxyj.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @program: activemq02
 * @description:
 * @author: GilbertXiao
 * @create: 2019-07-14 22:20
 **/
@Component
public class MessageProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMsg(String msg){
        jmsTemplate.convertAndSend("spring.jms.hello", msg);
    }
}
