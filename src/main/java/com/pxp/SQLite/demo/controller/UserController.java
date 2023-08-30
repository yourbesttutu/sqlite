package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.service.UserVisitCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserVisitCountService service;

  @RequestMapping(value = "count", method = RequestMethod.GET)
  public int count() {
    return service.countByIdAndURL("xxxx", "testKey1");
  }
}
