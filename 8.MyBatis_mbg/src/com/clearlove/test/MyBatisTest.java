package com.clearlove.test;

import static org.junit.Assert.*;

import com.clearlove.bean.Teacher;
import com.clearlove.dao.TeacherMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.clearlove.bean.Teacher;
import com.clearlove.bean.TeacherExample;
import com.clearlove.bean.TeacherExample.Criteria;
import com.clearlove.dao.TeacherMapper;



public class MyBatisTest {

	// 工厂一个
	SqlSessionFactory sqlSessionFactory;
	
	
	@Test
	public void test02(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//1、测试
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teachers = new ArrayList<Teacher>();
		for (int i = 0; i < 1000; i++) {
			Teacher teacher = new Teacher();
			teacher.setTeachername(UUID.randomUUID().toString().substring(0, 5));
			teacher.setClassName(UUID.randomUUID().toString().substring(0, 5));
			teachers.add(teacher);
		}
		System.out.println("批量保存.....");
		mapper.insertBatch(teachers);
		sqlSession.commit();
		sqlSession.close();
		
		
	}
	
	/**
	 * 测试代码生成器
	 * @throws IOException
	 */
	@Test
	public void test01(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//1、测试
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		//2、测试查询所有teacher
		List<Teacher> list = mapper.selectByExample(null);
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
		
		//3、带复杂条件的查询
		//select * from t_teacher id=? and teacherName like ?
		//封装查询条件的
		TeacherExample example = new TeacherExample();
		example.setOrderByClause("id DESC");
		//1、使用example创建一个Criteria（查询准则）
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(1);
		criteria.andTeachernameLike("%a%");
		
		System.out.println("======================");
		List<Teacher> list2 = mapper.selectByExample(example);
		for (Teacher teacher : list2) {
				System.out.println(teacher);
		}
		
		/**
		 * 多个复杂条件
		 * select * from t_teacher where  (id=? and teacherName like ?) or (address like ? and birth bet)
		 */
		TeacherExample example2 = new TeacherExample();
		
		
		//一个Criteria能封装一整个条件
		Criteria criteria2 = example2.createCriteria();
		criteria2.andIdGreaterThan(1);
		criteria2.andTeachernameLike("%a%");
		
		//创建第二个查询条件
		Criteria criteria3 = example2.createCriteria();
		criteria3.andAddressLike("%%");
		criteria3.andBirthDateBetween(new Date(), new Date());
		
		example2.or(criteria3);
		System.out.println("=======-=-=-=-=-=-=-");
		mapper.selectByExample(example2);
		
	}
	
	@Before
	public void initSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

}
