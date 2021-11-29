package com.clearlove.bean;

/**
 * 钥匙表
 * @author promise
 * @date 2021/11/29 - 21:43
 */
public class Key {

  private Integer id;

  private String keyName;

  // 当前钥匙能开哪个锁
  private Lock lock;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  @Override
  public String toString() {
    return "Key{" +
        "id=" + id +
        ", keyName='" + keyName + '\'' +
        ", lock=" + lock +
        '}';
  }
}
