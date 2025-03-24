package com.ms.email.consumers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.email.dtos.EmailRecordDto;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

//Metodo ouvinte para as filas de email
    //Payload recebe o corpo da mensagem
    @RabbitListener(queues = "${broker.queue.email.name}")
    public  void listenEmailQueue(@Payload EmailRecordDto emailRecordDto){
        System.out.println(emailRecordDto.emailTo());
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){ // converte o corpo do email do formato json para o formato EmailRecorddto
        ObjectMapper  objectMapper = new ObjectMapper();
        return  new Jackson2JsonMessageConverter(objectMapper);
    }



}
