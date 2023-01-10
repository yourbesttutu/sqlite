package com.pxp.SQLite.demo.rabbitmq;

import com.pxp.SQLite.demo.rabbitmq.payload.DetectionPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {

  private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

  @Override
  public void configureRabbitListeners(
      RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

  }

  @RabbitListener(queues = "test1Queue", concurrency = "3", containerFactory = "containerFactory")
  public void receivedTest1Message(DetectionPayload detectionPayload) {
    logger.info(detectionPayload.toString() + " doTask:" + detectionPayload.doTask());
  }

}
