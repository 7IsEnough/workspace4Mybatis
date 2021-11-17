package com.clearlove.test;

import com.clearlove.bean.Employee;
import com.clearlove.dao.EmployeeDao;
import com.clearlove.dao.EmployeeDaoAnnotation;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @author promise
 * @date 2021/10/31 - 17:40
 */
public class MyBatisCRUDTest {

  // 工厂一个
  SqlSessionFactory sqlSessionFactory;


  @Before
  public void initSqlSessionFactory() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
  }

  /**
   * 测试查询
   * @throws IOException
   */
  @Test
  public void test() throws IOException {
    //1.根据全局配置文件先得到SqlSessionFactory对象
//    initSqlSessionFactory();

    //2.得到SqlSession对象
    SqlSession openSession = sqlSessionFactory.openSession();

    //3.获取到dao接口的实现(映射器)
    EmployeeDao dao = openSession.getMapper(EmployeeDao.class);
    try{
      Employee employee = dao.getEmpById(1);
      System.out.println(employee);
    }finally{
      openSession.close();
    }
  }

  @Test
  public void testInsert() {
    // true代表自动提交
    SqlSession openSession = sqlSessionFactory.openSession(true);
    try {
      EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
      Employee employee = new Employee(null, "haha", "aaa", 0);
//      int i = mapper.insertEmployee(employee);
      int i = mapper.insertEmployee2(employee);
      System.out.println(i);
      System.out.println("刚才插入的id："+employee.getId());
      openSession.commit();
    } finally {
      // 手动提交
//      openSession.commit();
      openSession.close();
    }
  }


  @Test
  public void test02() {
    // true代表自动提交
    SqlSession openSession = sqlSessionFactory.openSession(true);
    try {
      EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
      Employee employee = mapper.getEmpByIdAndEmpName(1, "admin");
      System.out.println(employee);
      Map<String,Object> map = new HashMap<>();
      map.put("id", 1);
      map.put("empName", "admin");
      Employee name = mapper.getEmployeeByIdAndEmpName(map);
      System.out.println(name);
      openSession.commit();
    } finally {
      // 手动提交
//      openSession.commit();
      openSession.close();
    }
  }


  @Test
  public void testAnnotation() {
    SqlSession openSession = sqlSessionFactory.openSession();
    EmployeeDaoAnnotation mapper = openSession.getMapper(EmployeeDaoAnnotation.class);
    Employee empById = mapper.getEmpById(1);
    System.out.println(empById);
  }



}
