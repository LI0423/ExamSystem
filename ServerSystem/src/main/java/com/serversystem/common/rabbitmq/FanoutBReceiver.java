package com.serversystem.common.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutBReceiver {

    @RabbitHandler
    public void process(String context){
        System.out.println("fanoutB receiver: " + context);
    }

}
