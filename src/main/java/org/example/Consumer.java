package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Consumer {


    Logger logger = LoggerFactory.getLogger(Consumer.class);

    DeliverCallback deliverCallback = (consummerTag, delivery)->{
        System.out.println(consummerTag);
        System.out.println(delivery);
        String message = new String(delivery.getBody(), "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
        logger.info(" [x] Received '" + message + "'");
    };


    public void getMessage(Connection connection) throws IOException {
        Channel channel = connection.createChannel();
        channel.basicConsume("mail", true, deliverCallback, consumerTag -> {  });
//        connection.close();


    }


}
