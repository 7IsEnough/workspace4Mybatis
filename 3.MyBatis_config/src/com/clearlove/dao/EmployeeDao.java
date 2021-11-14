package com.clearlove.dao;

import com.clearlove.bean.Employee;

/**
 * @author promise
 * @date 2021/10/30 - 15:21
 */
public interface EmployeeDao {

  public Employee getEmpById(Integer id);

  public int updateEmployee(Employee employee);

  public boolean deleteEmployee(Integer id);

  public int insertEmployee(Employee employee);

}
