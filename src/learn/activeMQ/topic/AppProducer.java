package learn.activeMQ.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2018-8-22.
 * @author
 */
public class AppProducer {

    static Logger logger = LoggerFactory.getLogger(AppProducer.class);

    public static final String URL = "tcp://localhost:61616";
    public static final String QUENAME = "test_";

    public static void main(String[] args) throws Exception {
        sendMsg();
    }

    public static void sendMsg() throws JMSException{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_BROKER_URL,URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //第一个参数：是否在事务中去处理， 第二个参数.应答模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic(QUENAME);
        MessageProducer producer = session.createProducer(destination);

        for(int i=0; i<5; i++){
            TextMessage textMessage = session.createTextMessage(QUENAME + i);
            producer.send(textMessage);
            logger.info("send msg:" + textMessage.getText());
        }

        connection.close();
    }
}
