package com.gilxyj.main;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

/**
 * @program: activemq01
 * @description:
 * @author: GilbertXiao
 * @create: 2019-07-14 17:44
 **/
public class MsgWatcher {

    public static void main(String[] args) {
        ConnectionFactory factory =null;
        Connection connection =null;
        Session session =null;
        Destination destination =null;
        Message message =null;
        MessageConsumer consumer =null;


        try {
            factory=new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.133.128:61616");
            connection=factory.createConnection();
            connection.start();
            session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            destination=session.createQueue("hello");
            consumer = session.createConsumer(destination);
            //通过观察者模式来接收消息，即有消息时，onMessage就会自动被调用
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage msg = (TextMessage) message;
                    try {
                        String text = msg.getText();
                        System.out.println(text);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            System.out.println(">>>>>>>>>>>>>>>>");
            new Scanner(System.in).next();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (consumer!=null){
                try {
                    consumer.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

            if(session!=null){
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

            if (connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }



        }
    }
}
