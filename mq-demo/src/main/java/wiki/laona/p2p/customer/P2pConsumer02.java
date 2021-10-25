package wiki.laona.p2p.customer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author laona
 * @description pointer to pointer customer，点对点模式消费者
 * @create 2021-10-25 22:46
 **/
public class P2pConsumer02 {

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

        // 6. 创建消息消费者
        MessageConsumer consumer = session.createConsumer(queue);

        // 7. 接受消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                // 判断消息类型
                if (message instanceof TextMessage) {
                    TextMessage textMsg = (TextMessage) message;
                    try {
                        System.out.println("收到文本消息 ->>> " + textMsg.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 8. 释放资源( 此模式不能关闭连接，否则会无法接受消息 )
        // session.close();
        // connection.close();
    }
}
