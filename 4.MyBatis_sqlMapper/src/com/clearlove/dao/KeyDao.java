package com.clearlove.dao;

import com.clearlove.bean.Key;

/**
 * @author promise
 * @date 2021/11/29 - 22:28
 */
public interface KeyDao {

  /**
   * 将钥匙和锁一起查出
   * @param id
   * @return
   */
  public Key getKeyById(Integer id);

}
