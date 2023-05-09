package com.serversystem.common.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    public static final String TOPIC_ONE = "topic.one";
    public static final String TOPIC_TWO = "topic.two";
    public static final String TOPIC_EXCHANGE = "topicExchange";

    @Bean
    public Queue queueOne(){
        return new Queue(TOPIC_ONE);
    }

    @Bean
    public Queue queueTwo(){
        return new Queue(TOPIC_TWO);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding bindingExchangeOne(@Qualifier("queueOne") Queue queueOne, TopicExchange topicExchange){
        return BindingBuilder.bind(queueOne).to(topicExchange).with("topic.one");
    }

    @Bean
    public Binding bindingExchangeTwo(@Qualifier("queueTwo")Queue queueTwo, TopicExchange topicExchange){
        return BindingBuilder.bind(queueTwo).to(topicExchange).with("topic.#");
    }

}
