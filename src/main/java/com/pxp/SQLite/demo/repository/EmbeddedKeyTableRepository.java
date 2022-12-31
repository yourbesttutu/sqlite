package com.pxp.SQLite.demo.repository;

import com.pxp.SQLite.demo.entity.EmbeddedKeyTable;
import com.pxp.SQLite.demo.entity.keys.EmbeddedKeyTablePrimaryKey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmbeddedKeyTableRepository extends
    JpaRepository<EmbeddedKeyTable, EmbeddedKeyTablePrimaryKey> {

  @Query("select e from EmbeddedKeyTable e WHERE daily_timestamp=?1 and partition_key=?2 and timestamp>=?3 and timestamp<=?4")
  public List<EmbeddedKeyTable> findByDaily(long dailyTimestamp, String partitionKey,
      long startTime,long endTime);
}
