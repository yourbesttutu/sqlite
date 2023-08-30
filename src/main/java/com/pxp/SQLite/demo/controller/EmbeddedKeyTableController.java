package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.EmbeddedKeyTable;
import com.pxp.SQLite.demo.service.EmbeddedKeyTableService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmbeddedKeyTableController {

  @Autowired
  private EmbeddedKeyTableService service;

  @RequestMapping(value = "readTable", method = RequestMethod.GET)
  public List<EmbeddedKeyTable> readEmbeddedKeyTable() {
    return service.readAll();
  }

  @RequestMapping(value = "readTableByCondition", method = RequestMethod.GET)
  public List<EmbeddedKeyTable> readTableByCondition() {
    return service.readByCondition();
  }

//  @RequestMapping(value = "count", method = RequestMethod.GET)
//  public int count() {
//    return service.count(10L, "testKey1");
//  }
}
