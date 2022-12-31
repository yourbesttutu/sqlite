package com.pxp.SQLite.demo.entity.keys;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedKeyTablePartitionKey implements Serializable {

  public EmbeddedKeyTablePartitionKey() {
  }

  public EmbeddedKeyTablePartitionKey(String partitionKey, long dailyTimestamp) {
    this.partitionKey = partitionKey;
    this.dailyTimestamp = dailyTimestamp;
  }

  private String partitionKey;
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
