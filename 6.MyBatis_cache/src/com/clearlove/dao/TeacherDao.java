package com.clearlove.dao;

import com.clearlove.bean.Teacher;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author promise
 * @date 2021/12/21 - 22:47
 */
public interface TeacherDao{

  public Teacher getTeacherById(Integer id);

  public List<Teacher> getTeacherByCondition(Teacher teacher);

  public List<Teacher> getTeacherByIdIn(@Param("ids") List<Integer> ids);

  public List<Teacher> getTeacherByConditionChoose(Teacher teacher);

  public int updateTeacher(Teacher teacher);



}
