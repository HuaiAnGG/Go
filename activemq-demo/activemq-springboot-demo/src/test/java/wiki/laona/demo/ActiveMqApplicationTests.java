package wiki.laona.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;

@SpringBootTest(classes = ActiveMqApplication.class)
public class ActiveMqApplicationTests {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    
    
    @Test
    public void testP2pProducer() {
        jmsMessagingTemplate.convertAndSend("springboot_queue", "springboot message for p2p");
    }
    
    
    @Test
    void contextLoads() {
        jmsMessagingTemplate.convertAndSend("springboot_queue", "springboot message for p2p");
    }

}
