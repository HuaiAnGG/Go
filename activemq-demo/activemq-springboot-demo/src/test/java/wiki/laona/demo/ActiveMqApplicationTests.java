package wiki.laona.demo;

import ch.qos.logback.core.db.dialect.MsSQLDialect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.MessageHeaders;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = ActiveMqApplication.class)
public class ActiveMqApplicationTests {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void testP2pProducer() {
        jmsMessagingTemplate.convertAndSend("springboot_queue", "springboot message for p2p");
    }
    
    
    @Test
    void contextLoads() {
        jmsMessagingTemplate.convertAndSend("springboot_queue", "springboot message for p2p");
    }

    /**
     * 发送 map 消息
     */
    // @Test
    // public void testMapMessage() {
    //     jmsTemplate.send("springboot_map_queue", new MessageCreator() {
    //         @Override
    //         public Message createMessage(Session session) throws JMSException {
    //             MapMessage mapMessage = session.createMapMessage();
    //             mapMessage.setString("name", "laona");
    //             mapMessage.setInt("age", 24);
    //             return mapMessage;
    //         }
    //     });
    // }

    /**
     * 发送 map 消息
     */
    // @Test
    // public void testMapMessage2() {
        // jmsTemplate.send("springboot_map_queue", new MessageCreator() {
        //     @Override
        //     public Message createMessage(Session session) throws JMSException {
        //         MapMessage mapMessage = session.createMapMessage();
        //         mapMessage.setString("name", "laona");
        //         mapMessage.setInt("age", 24);
        //         return mapMessage;
        //     }
        // });
        // jmsMessagingTemplate.convertAndSend("");
    // }
}
