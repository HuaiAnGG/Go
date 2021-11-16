package wiki.laona.demo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author laona
 * @description 消息监听类
 * @create 2021-10-26 15:42
 **/
@Component
public class MessageListener {

    /**z
     * 接收消息
     */
    @JmsListener(destination = "WechatBot_Message")
    public void receiveMessage(Message message) throws JMSException {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("收到消息为 = " + textMessage.getText());
        }
    }
}
