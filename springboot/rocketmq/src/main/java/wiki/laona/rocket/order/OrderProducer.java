package wiki.laona.rocket.order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import wiki.laona.rocket.constant.Constant;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author laona
 * @description 顺序消息
 * @date 2022-03-30 16:24
 **/
public class OrderProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer(Constant.PRODUCER_NAME);
        producer.setNamesrvAddr(Constant.NAME_SER_ADDR);
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message message = new Message(Constant.TOPIC, ("Hello " + i).getBytes(StandardCharsets.UTF_8));
            producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    return list.get(0);
                }
            },0, 3000);
            // Thread.sleep(3000);
        }
        producer.shutdown();
        System.out.println(" producer shutdown ");
    }
}
