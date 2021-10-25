package wiki.laona.p2p.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author laona
 * @description pointer to pointer producer，点对点模式的生产者
 * @create 2021-10-25 22:27
 **/
public class P2pProducer {

    public static void main(String[] args) throws JMSException {
        // 1. 创建连接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://172.29.64.1:61617");

        // 2. 创建连接
        Connection connection = factory.createConnection();

        // 3. 打开连接
        connection.start();

        // 4. 创建 session
        /**
         * javax.jms.Connection#createSession(boolean, int)
         * @param val1 是否开启事务操作
         * @param val2 消息确认机制
         */
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5. 创建目标地址(Queue:点对点消息，Topic：发布订阅模式)
        Queue queue = session.createQueue("queue01");

        // 6. 创建消息生产者
        MessageProducer producer = session.createProducer(queue);

        // 7. 创建消息
        TextMessage testMessage = session.createTextMessage("test message");

        // 8. 发送消息
        producer.send(testMessage);
        System.out.println("消息发送完成！");

        // 9. 释放资源
        session.close();
        connection.close();
    }
}
