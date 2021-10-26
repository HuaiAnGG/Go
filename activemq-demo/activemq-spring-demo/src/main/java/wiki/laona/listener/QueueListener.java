package wiki.laona.listener;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author laona
 * @description queue 监听器
 * @create 2021-10-26 11:25
 **/
@Component
public class QueueListener implements MessageListener {

    /**
     * 监听消息
     */
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try{
                System.out.println("queue 收到消息 ---->>>> " + textMessage.getText());
            }catch (Exception ignored){
                
            }
        }
    }
}
