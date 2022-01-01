package wiki.laona.demo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author laona
 * @description 消息监听类
 * @create 2021-10-26 15:42
 **/
@Component
public class MessageListener {

    /**
     * 接收消息
     */
    @JmsListener(destination = "WechatBot_Message")
    public void receiveTextMessage(Message message) throws JMSException {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("收到消息为 = " + textMessage.getText());
        }
    }

    // @JmsListener(destination = "springboot_map_queue")
    // public void receiveMapMessage(Message message) throws JMSException {
    //     if (message instanceof MapMessage) {
    //         MapMessage mapMessage = (MapMessage) message;
    //         String name = mapMessage.getString("name");
    //         int age = mapMessage.getInt("age");
    //         System.out.println("name = " + name);
    //         System.out.println("age = " + age);
    //     }
    // }
}
