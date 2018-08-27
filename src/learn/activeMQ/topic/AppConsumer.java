package learn.activeMQ.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2018-8-22.
 * @author
 */
public class AppConsumer {

    public static final String URL = "tcp://localhost:61616";
    public static final String QUENAME = "test_";

    public static void main(String[] args) throws Exception {
        getMsg();
    }

    public static void getMsg() throws JMSException{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_BROKER_URL,URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //第一个参数：是否在事务中去处理， 第二个参数.应答模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic(QUENAME);
        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("receive msg:" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //connection.close();
    }
}
