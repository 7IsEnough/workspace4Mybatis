package com.clearlove.controller;

import com.clearlove.bean.Teacher;
import com.clearlove.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author promise
 * @date 2022/3/5 - 19:36
 */
@Controller
public class TeacherController {

  @Autowired TeacherService teacherService;

  @RequestMapping("/getTea")
  public String getTeacher(
      @RequestParam(value = "id", defaultValue = "1") Integer id, Model model) {
    Teacher t = teacherService.getTeacher(id);
    model.addAttribute("teacher", t);
    return "success";
  }
}
