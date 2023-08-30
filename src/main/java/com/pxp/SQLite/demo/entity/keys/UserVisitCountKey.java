package com.pxp.SQLite.demo.entity.keys;

import java.io.Serializable;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class UserVisitCountKey implements Serializable {

  @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  private String id;
  @PrimaryKeyColumn(name = "url", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
  private String url;
  @PrimaryKeyColumn(name = "creationtime", ordinal = 2, type = PrimaryKeyType.CLUSTERED)

  private long creationTime;

  public UserVisitCountKey() {
  }

  public UserVisitCountKey(String id, String url) {
    this.id = id;
    this.url = url;
    this.creationTime = System.currentTimeMillis();
  }

  public UserVisitCountKey(String id, String url, long creationTime) {
    this.id = id;
    this.url = url;
    this.creationTime = creationTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public long getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(long creationTime) {
    this.creationTime = creationTime;
  }

}
