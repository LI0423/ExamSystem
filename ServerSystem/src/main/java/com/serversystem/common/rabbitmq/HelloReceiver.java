package com.serversystem.common.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HelloReceiver {

    @RabbitListener(queues = "hello")
    public void process(String content, Message message, Channel channel){
        System.out.println("Receiver: " + content);
        try {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            System.out.println("Receiver: 消息已拒绝");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
