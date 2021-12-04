package com.clearlove.bean;

import java.util.List;

/**
 * 锁表
 * @author promise
 * @date 2021/11/29 - 21:43
 */
public class Lock {

  private Integer id;

  private String lockName;

  // 查询锁的时候把所有的钥匙也查出来
  private List<Key> keys;
  // 1-1关联  1-n关联  n-n关联
  // 一个钥匙开一把锁  1-1
  // 从lock看钥匙  1-n
  // 从key来看lock n-1
  // n-n:
  // student表 teacher表
  // 1-n: n-1; n-n 外键应该放在哪个表？
  // 一对多：外键一定放在多的一端
  // n-n: 中间表存储对应关系

  public List<Key> getKeys() {
    return keys;
  }

  public void setKeys(List<Key> keys) {
    this.keys = keys;
  }

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
        ", keys=" + keys +
        '}';
  }


}
