package wiki.laona.rocket.consumer;

import com.sun.org.apache.bcel.internal.Const;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.MessageExt;
import wiki.laona.rocket.constant.Constant;

import java.util.List;

/**
 * @author laona
 * @description 消费者
 * @date 2022-03-30 15:41
 **/
public class Consumer {

    public static void main(String[] args) throws MQClientException {
        // 指定消费组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(Constant.PRODUCER_NAME);
        // 设置 namesrv
        consumer.setNamesrvAddr(Constant.NAME_SER_ADDR);
        // 订阅topic：Constant.TOPIC 下的全部消息（因为是*，*指定的是tag标签，代表全部消息，不进行任何过滤）
        consumer.subscribe(Constant.TOPIC, "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg : list) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String body = new String(msg.getBody());
                    System.out.println("body = " + body);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动 consumer
        consumer.start();
        System.out.println("consumer started ");
    }
}
