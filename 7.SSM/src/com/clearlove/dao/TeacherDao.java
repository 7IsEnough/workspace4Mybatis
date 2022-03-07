package com.clearlove.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clearlove.bean.Teacher;

public interface TeacherDao {
	
	public Teacher getTeacherById(Integer id);
	public List<Teacher> getTeachers();

}
