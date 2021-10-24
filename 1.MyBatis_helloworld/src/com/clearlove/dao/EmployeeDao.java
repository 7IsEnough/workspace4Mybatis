package com.clearlove.dao;

import com.clearlove.bean.Employee;

/**
 * @author promise
 * @date 2021/10/23 - 21:53
 */
public interface EmployeeDao {

  // 数据库驱动
//  mybatis-3.4.1.jar
//  mysql-connector-java-8.0.18.jar
//  log4j-1.2.17.jar
  // 按照员工ID查询员工
  public Employee getEmpById(Integer id);


}
