package com.pxp.SQLite.demo.entity.keys;

import java.io.Serializable;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class EmbeddedKeyTablePartitionKey implements Serializable {

  public EmbeddedKeyTablePartitionKey() {
  }

  public EmbeddedKeyTablePartitionKey(String partitionKey, long dailyTimestamp) {
    this.partitionKey = partitionKey;
    this.dailyTimestamp = dailyTimestamp;
  }
  @PrimaryKeyColumn(name = "pk", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  private String partitionKey;
  @PrimaryKeyColumn(name = "dt", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
  private long dailyTimestamp;

  public String getPartitionKey() {
    return partitionKey;
  }

  public void setPartitionKey(String partitionKey) {
    this.partitionKey = partitionKey;
  }

  public long getDailyTimestamp() {
    return dailyTimestamp;
  }

  public void setDailyTimestamp(long dailyTimestamp) {
    this.dailyTimestamp = dailyTimestamp;
  }
}
