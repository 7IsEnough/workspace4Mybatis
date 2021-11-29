package com.clearlove.bean;

/**
 * 锁表
 * @author promise
 * @date 2021/11/29 - 21:43
 */
public class Lock {

  private Integer id;

  private String lockName;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLockName() {
    return lockName;
  }

  public void setLockName(String lockName) {
    this.lockName = lockName;
  }

  @Override
  public String toString() {
    return "Lock{" +
        "id=" + id +
        ", lockName='" + lockName + '\'' +
        '}';
  }
}
