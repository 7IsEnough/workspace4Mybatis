package com.clearlove.dao;

import com.clearlove.bean.Employee;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

/**
 * @author promise
 * @date 2021/10/30 - 15:21
 */
public interface EmployeeDao {

  List<Employee> getAllEmps();

  // key是这个记录的主键，value是这条记录封装好的对象
  // 把查询的记录的id的值作为key封装这个map
  @MapKey("id")
  public Map<Integer, Employee> getAllEmpsReturnMap();

  public Employee getEmpById(Integer id);

  // 列名为key，值为value
  public Map<String, Object> getEmpByIdReturnMap(Integer id);

  Employee getEmpByIdAndEmpName(@Param("id") Integer id, @Param("empName") String empName);

  public Employee getEmployeeByIdAndEmpName(Map<String, Object> map);

  public int updateEmployee(Employee employee);

  public boolean deleteEmployee(Integer id);

  public int insertEmployee(Employee employee);

  public int insertEmployee2(Employee employee);

}
