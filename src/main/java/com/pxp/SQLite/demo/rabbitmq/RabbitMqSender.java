package com.pxp.SQLite.demo.rabbitmq;

import com.pxp.SQLite.demo.rabbitmq.payload.InsightFinderPayload;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public RabbitMqSender(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Value("${spring.rabbitmq.exchange}")
  private String exchange;

  public void send(InsightFinderPayload insightFinderPayload, String queueName) {
    rabbitTemplate.convertAndSend(exchange, queueName, insightFinderPayload);
  }
}