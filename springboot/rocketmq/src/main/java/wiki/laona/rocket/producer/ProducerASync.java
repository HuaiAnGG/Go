package wiki.laona.rocket.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import wiki.laona.rocket.constant.Constant;

/**
 * @author laona
 * @description 异步发送
 * @date 2022-03-30 15:38
 **/
public class ProducerASync {

    public static void main(String[] args) throws Exception {
        // 指定生产组名
        DefaultMQProducer producer = new DefaultMQProducer(Constant.PRODUCER_NAME);
        // 配置namesrv地址
        producer.setNamesrvAddr(Constant.NAME_SER_ADDR);
        // 启动生产者
        producer.start();

        // 创建消息对象，topic为：myTopic001，消息内容为：hello world async
        Message msg = new Message(Constant.TOPIC, "hello world async".getBytes());
        // 进行异步发送，通过SendCallback接口来得知发送的结果
        producer.send(msg, new SendCallback() {
            // 发送成功的回调接口
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送消息成功！result is : " + sendResult);
            }
            // 发送失败的回调接口
            @Override
            public void onException(Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("发送消息失败！result is : " + throwable.getMessage());
            }
        });
        Thread.sleep(1000);
        producer.shutdown();
        System.out.println("生产者 shutdown！");
    }
}
