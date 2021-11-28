package com.clearlove.test;

import com.clearlove.bean.Cat;
import com.clearlove.bean.Employee;
import com.clearlove.dao.CatDao;
import com.clearlove.dao.EmployeeDao;
import com.clearlove.dao.EmployeeDaoAnnotation;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
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
//      Employee employee = mapper.getEmpByIdAndEmpName(1, "admin");
//      System.out.println(employee);
      Map<String,Object> map = new HashMap<>();
      map.put("id", 1);
      map.put("empName", "admin");
      map.put("tableName", "t_employee");
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
  public void test03() {
    // true代表自动提交
    SqlSession openSession = sqlSessionFactory.openSession(true);
    try {
      EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);

      // 查询多条记录封装List
//      List<Employee> allEmps = mapper.getAllEmps();
//      for (Employee employee : allEmps) {
//        System.out.println(employee);
//      }

      // 查询单条记录封装map
//      Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
//      System.out.println(map);


      // 查询多条记录封装map
      Map<Integer, Employee> map = mapper.getAllEmpsReturnMap();
      System.out.println(map);

      openSession.commit();
    } finally {
      // 手动提交
//      openSession.commit();
      openSession.close();
    }
  }


  /**
   * 默认mybatis自动封装结果集；
   * 1)、按照列名和属性名一一对应的规则(不区分大小写)
   * 2)、如果不一一对应
   *      1.开启驼峰命名法(满足驼峰命名规则 aaa_bbb  aaaBbb)
   *      2.起别名
   */
  @Test
  public void test04() {
    // true代表自动提交
    SqlSession openSession = sqlSessionFactory.openSession(true);
    try {
      CatDao mapper = openSession.getMapper(CatDao.class);
      Cat catById = mapper.getCatById(1);
      System.out.println(catById);

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
