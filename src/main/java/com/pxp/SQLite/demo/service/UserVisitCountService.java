package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.UserVisitCount;
import com.pxp.SQLite.demo.repository.UserVisitCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVisitCountService {

  @Autowired
  private UserVisitCountRepository repository;

  public <E> boolean save(E entity) {
    UserVisitCount userVisitCount = (UserVisitCount) entity;
    repository.save(userVisitCount);
    return true;
  }

  public <E> boolean delete(E entity) {
    repository.delete((UserVisitCount) entity);
    return true;
  }

  public int countByIdAndURL(String id, String url) {
    return repository.count(id, url);
  }

}
