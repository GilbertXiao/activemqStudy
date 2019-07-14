package com.gilxyj.main;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @program: activemq01
 * @description:
 * @author: GilbertXiao
 * @create: 2019-07-14 17:44
 **/
public class MsgConsumer {

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
            //这个方法用来收消息，该方法会阻塞
            message = consumer.receive();
            System.out.println(message);

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
