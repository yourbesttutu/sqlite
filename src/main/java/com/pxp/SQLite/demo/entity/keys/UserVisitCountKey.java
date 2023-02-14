package com.pxp.SQLite.demo.entity.keys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserVisitCountKey implements Serializable {

  @Column(name = "id")
  private String id;
  @Column(name = "url")
  private String url;
  @Column(name = "creationtime")
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
