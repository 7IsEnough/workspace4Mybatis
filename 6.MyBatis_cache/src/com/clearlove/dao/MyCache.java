package com.clearlove.dao;

import java.util.concurrent.locks.ReadWriteLock;
import org.apache.ibatis.cache.Cache;

/**
 * @author promise
 * @date 2022/3/2 - 21:48
 */
public class MyCache implements Cache {

  //redis = new Redis();

  @Override
  public String getId() {
    return null;
  }

  @Override
  public void putObject(Object o, Object o1) {
    // redis.put();
    // ehcache-core-2.6.8.jar
    // mybatis-ehcache-1.0.3.jar
    // slf4j-api-1.7.21.jar
    // slf4j-log4j12-1.7.21.jar
  }

  @Override
  public Object getObject(Object o) {
    // redis.get();
    return null;
  }

  @Override
  public Object removeObject(Object o) {
    return null;
  }

  @Override
  public void clear() {

  }

  @Override
  public int getSize() {
    return 0;
  }

  @Override
  public ReadWriteLock getReadWriteLock() {
    return null;
  }
}
