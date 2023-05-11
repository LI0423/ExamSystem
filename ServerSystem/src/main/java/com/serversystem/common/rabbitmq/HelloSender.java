package com.serversystem.common.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String context = "rabbitmq";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("hello", context);
    }

    public void sendOne() {
        String context = "topicOne";
        System.out.println("Sender: " + context);
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, "topic.one", context);
    }

    public void sendTwo() {
        String context = "topicTwo";
        System.out.println("Sender: " + context);
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, "topic.two", context);
    }

    public void fanoutSend() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "123", context);
    }
}
