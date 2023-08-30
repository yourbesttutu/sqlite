package com.pxp.SQLite.demo.entity;

import com.pxp.SQLite.demo.entity.keys.EmbeddedKeyTablePrimaryKey;
import java.nio.ByteBuffer;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("e")
public class EmbeddedKeyTable {

  public EmbeddedKeyTable() {
  }

  @PrimaryKey
  private EmbeddedKeyTablePrimaryKey embeddedKeyTablePrimaryKey;
  private String data;
  //  private Set<String> set;
  private ByteBuffer byteBuffer;

  public EmbeddedKeyTablePrimaryKey getEmbeddedKeyTablePrimaryKey() {
    return embeddedKeyTablePrimaryKey;
  }

  public void setEmbeddedKeyTablePrimaryKey(
      EmbeddedKeyTablePrimaryKey embeddedKeyTablePrimaryKey) {
    this.embeddedKeyTablePrimaryKey = embeddedKeyTablePrimaryKey;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

//  public Set<String> getSet() {
//    return set;
//  }
//
//  public void setSet(Set<String> set) {
//    this.set = set;
//  }


  public ByteBuffer getByteBuffer() {
    return byteBuffer;
  }

  public void setByteBuffer(ByteBuffer byteBuffer) {
    this.byteBuffer = byteBuffer;
  }
}
