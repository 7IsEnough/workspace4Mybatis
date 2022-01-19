package com.clearlove.test;

import com.clearlove.bean.Teacher;
import com.clearlove.dao.TeacherDao;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
   * 体会一级缓存
   *
   * @throws IOException
   */
  @Test
  public void test02() throws IOException {
    // 1.根据全局配置文件先得到SqlSessionFactory对象
    //    initSqlSessionFactory();

    // 2.得到SqlSession对象
    SqlSession openSession = sqlSessionFactory.openSession();

    try {

      TeacherDao mapper = openSession.getMapper(TeacherDao.class);
      Teacher teacher = mapper.getTeacherById(1);
      System.out.println(teacher);
      System.out.println("===================");
      Teacher teacher2 = mapper.getTeacherById(1);
      System.out.println(teacher2);
      System.out.println(teacher2 == teacher);
      openSession.commit();

    } finally {
      openSession.close();
    }
  }

  /**
   * 一级缓存失效的几种情况
   * 一级缓存是sqlSession级别的缓存
   * 1. 不同的sqlSession，使用不同的一级缓存
   *    只有在同一个sqlSession期间查询到的数据会保存在这个sqlSession的缓存中
   *    下次使用这个sqlSession查询会从缓存中拿
   * 2. 同一个方法，不同的参数，由于可能之前没查询过，所以还会发新的sql
   * 3. 在这个sqlSession期间执行上任何一次增删改操作，增删改操作会把缓存清空
   * 4. 手动清空了缓存
   *
   * 每次查询，先看一级缓存中有没有，如果没有就去发送新的sql，每个sqlSession拥有自己的一级缓存
   *
   * @throws IOException
   */
  @Test
  public void test03() throws IOException {
    // 1.根据全局配置文件先得到SqlSessionFactory对象
    //    initSqlSessionFactory();

    // 2.得到SqlSession对象(第一个会话)
    SqlSession openSession = sqlSessionFactory.openSession();
    TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
    Teacher teacher1 = teacherDao.getTeacherById(1);
    System.out.println(teacher1);
    System.out.println("======================");

    // 执行任何一个增删改操作
//    Teacher teacher = new Teacher();
//    teacher.setId(3);
//    teacher.setName("33333");
//    teacherDao.updateTeacher(teacher);

    // 手动清空一级缓存
    openSession.clearCache();


    System.out.println("======================");
    Teacher teacher2 = teacherDao.getTeacherById(1);
    System.out.println(teacher2);


    // 第二个会话
//    SqlSession openSession2 = sqlSessionFactory.openSession();
//    TeacherDao teacherDao2 = openSession2.getMapper(TeacherDao.class);
//    Teacher teacher2 = teacherDao2.getTeacherById(1);
//    System.out.println(teacher2);

    openSession.commit();
    openSession.close();
//    openSession2.close();
  }
}
