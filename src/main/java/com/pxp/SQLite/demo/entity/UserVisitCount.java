package com.pxp.SQLite.demo.entity;

import com.pxp.SQLite.demo.entity.keys.UserVisitCountKey;
import java.util.Objects;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@Table("user_visit_count")
public class UserVisitCount {

  @PrimaryKey
  private UserVisitCountKey userVisitCountKey;
  private String data;

  public UserVisitCount() {
  }

  public UserVisitCount(UserVisitCountKey userVisitCountKey) {
    this.userVisitCountKey = userVisitCountKey;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public UserVisitCountKey getUserVisitCountKey() {
    return userVisitCountKey;
  }

  public void setUserVisitCountKey(UserVisitCountKey userVisitCountKey) {
    this.userVisitCountKey = userVisitCountKey;
  }

  @Override
  public String toString() {
    return "UserVisitCount{" + "userVisitCountKey=" + userVisitCountKey + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserVisitCount that = (UserVisitCount) o;
    return Objects.equals(userVisitCountKey, that.userVisitCountKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userVisitCountKey);
  }
}
