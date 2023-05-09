package com.serversystem.common.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.two")
public class TopicTwoReceiver {

    @RabbitHandler
    public void process(String context){
        System.out.println("receiver: " + context);
    }

}
