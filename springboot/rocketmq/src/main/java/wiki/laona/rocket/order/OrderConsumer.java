package wiki.laona.rocket.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import wiki.laona.rocket.constant.Constant;

import java.util.List;

/**
 * @author laona
 * @description 顺序消费者
 * @date 2022-03-30 16:29
 **/
public class OrderConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(Constant.PRODUCER_NAME);
        consumer.setNamesrvAddr(Constant.NAME_SER_ADDR);
        consumer.subscribe(Constant.TOPIC, "*");

        consumer.setConsumeThreadMax(1);
        consumer.setConsumeThreadMin(1);

        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt msg : list) {
                    System.out.println(new String(msg.getBody()) + " Thread = " + Thread.currentThread().getName());
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();
        System.out.println("consumer shutdown" );
    }
}
