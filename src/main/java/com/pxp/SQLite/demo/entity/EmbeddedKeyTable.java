package com.pxp.SQLite.demo.entity;

import com.pxp.SQLite.demo.entity.keys.EmbeddedKeyTablePrimaryKey;
import java.nio.ByteBuffer;
import java.util.Set;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EmbeddedKeyTable {

  public EmbeddedKeyTable() {
  }

  @EmbeddedId
  private EmbeddedKeyTablePrimaryKey embeddedKeyTablePrimaryKey;
  private String data;
//  private Set<String> set;
  private byte[] byteBuffer;

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

  public byte[] getByteBuffer() {
    return byteBuffer;
  }

  public void setByteBuffer(byte[] byteBuffer) {
    this.byteBuffer = byteBuffer;
  }
}
