package com.clearlove.dao;

import com.clearlove.bean.Teacher;
import java.util.List;

/**
 * @author promise
 * @date 2021/12/21 - 22:47
 */
public interface TeacherDao {

  public Teacher getTeacherById(Integer id);

  public List<Teacher> getTeacherByCondition(Teacher teacher);

}
