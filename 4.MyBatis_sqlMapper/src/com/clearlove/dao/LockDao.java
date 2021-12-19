package com.clearlove.dao;

import com.clearlove.bean.Lock;

/**
 * @author promise
 * @date 2021/12/5 - 21:18
 */
public interface LockDao {

  // 查锁的时候将所有钥匙也查出来
  public Lock getLockById(Integer id);

  public Lock getLockByIdByStep(Integer id);

  public Lock getLockByIdSimple(Integer id);

}
