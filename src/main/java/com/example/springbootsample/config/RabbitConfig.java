package com.example.springbootsample.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitConfig {

    @Value("${spring.queue.name}")
    private String queueNameResponse;

    @Value("${spring.rabbitmq.port}")
    private int responsePort;

    @Value("${spring.rabbitmq.host}")
    private String responseHost;

    @Value("${spring.rabbitmq.virtual}")
    private String virtual;

    @Value("${spring.rabbitmq.username}")
    private String responseUsername;

    @Value("${spring.rabbitmq.password}")
    private String responsePassword;

    @Value("${spring.rabbitmq.routingKey.name}")
    private String routingKeyResponse;

    @Value("${spring.rabbitmq.exchange.name}")
    private String exchangeResponse;

    @Bean
    @Qualifier("ResponseTransactionQueueService")
    @Primary
    public AmqpTemplate rabbitTemplateResponse(@Autowired MessageConverter messageConverter) {
        final RabbitTemplate rabbitTemplateResponse = new RabbitTemplate(connectionFactoryResponse());
        rabbitTemplateResponse.setExchange(exchangeResponse);
        rabbitTemplateResponse.setRoutingKey(routingKeyResponse);
        rabbitTemplateResponse.setMessageConverter(messageConverter);
        return rabbitTemplateResponse;
    }

//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }

    @Bean("connectionFactoryResponse")
    public ConnectionFactory connectionFactoryResponse() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(responseHost);
        connectionFactory.setVirtualHost(virtual);
        connectionFactory.setPort(responsePort);
        connectionFactory.setUsername(responseUsername);
        connectionFactory.setPassword(responsePassword);
        connectionFactory.createConnection();
        return connectionFactory;
    }

    @Bean
    Queue queueResponse() {
        Queue responseQ = new Queue(queueNameResponse, false);
        responseQ.setAdminsThatShouldDeclare(amqpAdminResponse());
        return responseQ;
    }

    @Bean
    DirectExchange exchangeResponse() {
        DirectExchange responseExchange = new DirectExchange(exchangeResponse);
        responseExchange.setAdminsThatShouldDeclare(amqpAdminResponse());
        return responseExchange;
    }

    @Bean
    Binding bindingResponse() {
        Binding responseBinding = BindingBuilder.bind(queueResponse())
                .to(exchangeResponse())
                .with(routingKeyResponse);
        responseBinding.setAdminsThatShouldDeclare(amqpAdminResponse());
        return responseBinding;
    }

    @Bean(name = "adminResponse")
    @Primary
    AmqpAdmin amqpAdminResponse() {
        return new RabbitAdmin(connectionFactoryResponse());
    }


    @Bean(name = "responseListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory responseListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                                                 @Qualifier("connectionFactoryResponse") ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

}
