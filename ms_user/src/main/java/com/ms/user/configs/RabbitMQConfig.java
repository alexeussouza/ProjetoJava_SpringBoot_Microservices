package com.ms.user.configs;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){ // converte o corpo do email do formato json para o formato EmailRecorddto
        ObjectMapper objectMapper = new ObjectMapper();
        return  new Jackson2JsonMessageConverter(objectMapper);
    }
}

