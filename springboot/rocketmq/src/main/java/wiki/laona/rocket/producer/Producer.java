package wiki.laona.rocket.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import wiki.laona.rocket.constant.Constant;

import java.nio.charset.StandardCharsets;

/**
 * @author laona
 * @description 生产者
 * @date 2022-03-30 15:26
 **/
public class Producer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // 指定生产组名
        DefaultMQProducer producer = new DefaultMQProducer(Constant.PRODUCER_NAME);
        // 配置namesrv地址
        producer.setNamesrvAddr(Constant.NAME_SER_ADDR);
        // 启动生产者
        producer.start();

        // 生成消息
        Message msg = new Message(Constant.TOPIC, "from 224 client".getBytes(StandardCharsets.UTF_8));
        SendResult sendResult = producer.send(msg);
        System.out.println("sendResult = " + sendResult);

        producer.shutdown();
        System.out.println("producer was shutdown！");
    }
}
