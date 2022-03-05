package com.clearlove.service;

import com.clearlove.bean.Teacher;
import com.clearlove.dao.TeacherDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author promise
 * @date 2022/3/5 - 18:40
 */
@Service
public class TeacherService {

//  @Autowired
//  private TeacherDao teacherDao;

  @Autowired
  private SqlSessionFactory factory;

  public Teacher getTeacher(Integer id){
    SqlSession sqlSession = factory.openSession();
    TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
    return teacherDao.getTeacherById(id);
  }
}
