package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.EmbeddedKeyTable;
import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.entity.keys.EmbeddedKeyTablePrimaryKey;
import com.pxp.SQLite.demo.repository.EmbeddedKeyTableRepository;
import com.pxp.SQLite.demo.repository.StudentRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmbeddedKeyTableService {

  @Autowired
  private EmbeddedKeyTableRepository repository;

  public List<EmbeddedKeyTable> readAll() {
    return repository.findAll();
  }

  public List<EmbeddedKeyTable> readByCondition() {
    EmbeddedKeyTable embeddedKeyTable = new EmbeddedKeyTable();
    embeddedKeyTable.setEmbeddedKeyTablePrimaryKey(
        new EmbeddedKeyTablePrimaryKey("testKey1", 10L, 11L));
    repository.save(embeddedKeyTable);
    return repository.findByDaily(1L, "testkey", 1L, 4L);
  }

  public int count(long dailyTimestamp, String partitionKey) {
    return repository.count(dailyTimestamp, partitionKey);
  }
}
