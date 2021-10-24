package com.clearlove.test;

import com.clearlove.bean.Employee;
import com.clearlove.dao.EmployeeDao;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author promise
 * @date 2021/10/24 - 17:00
 */
public class MyBatisTest {

  @Test
  public void test() throws IOException {
    // 1.根据全局配置文件创建出一个SqlSessionFactory
    // SqlSessionFactory:是SqlSession工厂，负责创建SqlSession对象
    // SqlSession: sql会话(代表和数据库的一次会话)
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    Employee employee;
    SqlSession openSession = null;

    try {
      // 2.获取和数据库的一次会话: getConnection()；
      openSession = sqlSessionFactory.openSession();

      // 3. 使用SqlSession操作数据库，获取到dao接口的实现
      EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
      // 4.调用之前的方法
      employee = employeeDao.getEmpById(1);
    } finally {
      openSession.close();
    }
    System.out.println(employee);

  }

}
