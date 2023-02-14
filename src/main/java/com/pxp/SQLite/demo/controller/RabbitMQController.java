package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.rabbitmq.RabbitMqSender;
import com.pxp.SQLite.demo.rabbitmq.payload.DetectionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class RabbitMQController {

  @Autowired
  private RabbitMqSender rabbitMqSender;

  @GetMapping(value = "/producer")
  public String producer(@RequestParam("queue") String queue) {

    rabbitMqSender.send(new DetectionPayload("testProject", "testCustomer"), queue);

    return "Message sent to the RabbitMQ Successfully";
  }
}
