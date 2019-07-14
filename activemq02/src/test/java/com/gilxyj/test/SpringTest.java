package com.gilxyj.test;

import com.gilxyj.component.MessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: activemq02
 * @description:
 * @author: GilbertXiao
 * @create: 2019-07-14 23:05
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    MessageProducer messageProducer;

    @Test
    public void  test01(){
        messageProducer.sendMsg("hello spring");
    }
}
