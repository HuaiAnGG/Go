package wiki.laona.rocket.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import wiki.laona.rocket.constant.Constant;

/**
 * @author laona
 * @description oneway
 * @date 2022-03-30 15:39
 **/
public class ProducerOneWay {

    public static void main(String[] args) throws Exception {
        // 指定生产组名
        DefaultMQProducer producer = new DefaultMQProducer(Constant.PRODUCER_NAME);
        // 配置namesrv地址
        producer.setNamesrvAddr(Constant.NAME_SER_ADDR);
        // 启动生产者
        producer.start();
        // 创建消息对象，topic为：myTopic001，消息内容为：hello world oneway
        Message msg = new Message(Constant.TOPIC, "hello world oneway".getBytes());
        // 效率最高，因为oneway不关心是否发送成功，就投递一下就不管了。所以返回是void
        producer.sendOneway(msg);
        System.out.println("投递消息成功！，注意这里是投递成功，而不是发送消息成功哦！因为sendOneway也不知道到底成没成功，没返回值的。");
        producer.shutdown();
        System.out.println("生产者 shutdown！");
    }
}
