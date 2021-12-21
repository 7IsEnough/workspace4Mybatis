package com.clearlove.test;

import com.clearlove.bean.Teacher;
import com.clearlove.dao.TeacherDao;
import java.io.IOException;
import java.io.InputStream;
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


    try{

      TeacherDao mapper = openSession.getMapper(TeacherDao.class);
      Teacher teacher = mapper.getTeacherById(1);
      System.out.println(teacher);

    }finally{
      openSession.close();
    }
  }








}
