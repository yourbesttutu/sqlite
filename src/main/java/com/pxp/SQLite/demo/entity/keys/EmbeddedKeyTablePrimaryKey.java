package com.pxp.SQLite.demo.entity.keys;

import java.io.Serializable;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class EmbeddedKeyTablePrimaryKey implements Serializable {

  public EmbeddedKeyTablePrimaryKey() {
  }

  public EmbeddedKeyTablePrimaryKey(String partitionKey, long dailyTimestamp, long timestamp) {
    this.partitionKey = partitionKey;
    this.dailyTimestamp = dailyTimestamp;
    this.timestamp = timestamp;
  }

  @PrimaryKeyColumn(name = "pk", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  private String partitionKey;
  @PrimaryKeyColumn(name = "dt", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
  private long dailyTimestamp;
  @PrimaryKeyColumn(name = "t", ordinal = 2, type = PrimaryKeyType.CLUSTERED)

  private long timestamp;

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

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
