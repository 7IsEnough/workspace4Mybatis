package com.clearlove.dao;

import com.clearlove.bean.Employee;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * @author promise
 * @date 2021/10/30 - 15:21
 */
public interface EmployeeDao {

  public Employee getEmpById(Integer id);

  public Employee getEmpByIdAndEmpName(@Param("id") Integer id, @Param("empName") String empName);

  public Employee getEmployeeByIdAndEmpName(Map<String, Object> map);

  public int updateEmployee(Employee employee);

  public boolean deleteEmployee(Integer id);

  public int insertEmployee(Employee employee);

  public int insertEmployee2(Employee employee);

}
