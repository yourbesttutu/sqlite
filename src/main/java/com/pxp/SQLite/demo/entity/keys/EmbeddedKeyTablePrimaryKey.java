package com.pxp.SQLite.demo.entity.keys;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedKeyTablePrimaryKey implements Serializable {

  public EmbeddedKeyTablePrimaryKey() {
  }

  public EmbeddedKeyTablePrimaryKey(String partitionKey, long dailyTimestamp, long timestamp) {
    this.embeddedKeyTablePartitionKey = new EmbeddedKeyTablePartitionKey(partitionKey,
        dailyTimestamp);
    this.timestamp = timestamp;
  }

  private EmbeddedKeyTablePartitionKey embeddedKeyTablePartitionKey;
  private long timestamp;

  public EmbeddedKeyTablePartitionKey getEmbeddedKeyTablePartitionKey() {
    return embeddedKeyTablePartitionKey;
  }

  public void setEmbeddedKeyTablePartitionKey(
      EmbeddedKeyTablePartitionKey embeddedKeyTablePartitionKey) {
    this.embeddedKeyTablePartitionKey = embeddedKeyTablePartitionKey;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
