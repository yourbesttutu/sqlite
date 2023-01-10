package com.pxp.SQLite.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  @Value("${spring.rabbitmq.exchange}")
  private String exchange;
  @Value("${spring.rabbitmq.username}")
  private String username;
  @Value("${spring.rabbitmq.password}")
  private String password;
  @Value("${spring.rabbitmq.host}")
  private String host;

  @Bean
  Queue testQueue() {
    return new Queue("testQueue", false);
  }

  @Bean
  Queue test1Queue() {
    return new Queue("test1Queue", false);
  }

  @Bean
  Queue test2Queue() {
    return new Queue("test2Queue", false);
  }

  @Bean
  Exchange myExchange() {
    return ExchangeBuilder.directExchange(exchange).durable(true).build();
  }

  @Bean
  Binding bindingTest() {
    return BindingBuilder.bind(testQueue()).to(myExchange()).with("testQueue").noargs();
  }

  @Bean
  Binding bindingTest1() {
    return BindingBuilder.bind(test1Queue()).to(myExchange()).with("test1Queue").noargs();
  }

  @Bean
  Binding bindingTest2() {
    return BindingBuilder.bind(test2Queue()).to(myExchange()).with("test2Queue").noargs();
  }

  @Bean
  public RabbitListenerContainerFactory<SimpleMessageListenerContainer> containerFactory(
      ConnectionFactory rabbitConnectionFactory) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(rabbitConnectionFactory);
    factory.setPrefetchCount(1);
    return factory;
  }

  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
    cachingConnectionFactory.setUsername(username);
    cachingConnectionFactory.setPassword(password);
    return cachingConnectionFactory;
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(jsonMessageConverter());
    return rabbitTemplate;
  }
}