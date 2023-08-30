package com.pxp.SQLite.demo.repository;

import com.pxp.SQLite.demo.entity.EmbeddedKeyTable;
import com.pxp.SQLite.demo.entity.keys.EmbeddedKeyTablePrimaryKey;
import java.util.List;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmbeddedKeyTableRepository extends
    CassandraRepository<EmbeddedKeyTable, EmbeddedKeyTablePrimaryKey> {

  @Query("select * from e WHERE dt=?0 and pk=?1 and t>=?2 and t<=?3")
  public List<EmbeddedKeyTable> findByDaily(long dailyTimestamp, String partitionKey,
      long startTime, long endTime);

  @Query("select COUNT(*) from e WHERE dt=?0 and pk=?1")
  public int count(long dailyTimestamp, String partitionKey);
}
