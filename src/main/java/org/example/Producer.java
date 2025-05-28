package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Producer {

    Logger logger = LoggerFactory.getLogger(Producer.class);

    public void send(Connection connection,String message) throws IOException {

        Channel channel = connection.createChannel();
        channel.queueDeclare("mail",false,false,false,null);
        channel.basicPublish("","mail",null,message.getBytes());
        logger.info("message: "+message+" published");
//        connection.close();



    }
}
