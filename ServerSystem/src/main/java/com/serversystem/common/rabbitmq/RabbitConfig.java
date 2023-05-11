package com.serversystem.common.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
public class RabbitConfig {

//    @Bean
//    public Queue queue(){
//        return new Queue("hello");
//    }

    @Bean
    public DirectExchange helloExchange(){
        return new DirectExchange("helloExchange", true, false);
    }

    @Bean
    public Queue bindingDeadQueue(){
        Map<String, Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange", "deadExchange");
        map.put("x-dead-letter-routing-key", "dead.dlx");
//        map.put("x-message-ttl", 5000);
        map.put("x-max-length", 3);
        return new Queue("hello", true, false,false, map);
    }

    @Bean
    public Binding helloBinding(){
        return BindingBuilder.bind(bindingDeadQueue()).to(helloExchange()).with("routing-key");
    }

    @Bean
    public Queue deadQueue(){
        return new Queue("deadQueue", true, false,false, null);
    }

    @Bean
    public DirectExchange deadExchange(){
        return new DirectExchange("deadExchange");
    }

    @Bean
    public Binding bindingDeadExchange(@Qualifier("deadQueue") Queue deadQueue){
        return BindingBuilder.bind(deadQueue).to(deadExchange()).with("dead.dlx");
    }



}
