package com.clearlove.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clearlove.bean.Teacher;
import com.clearlove.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("/getTea")
	public String getTeacher(@RequestParam(value="id",defaultValue="1")Integer id,Model model){
		Teacher t = teacherService.getTeacher(id);
		model.addAttribute("teacher", t );
		return "success";
	}
	
	@RequestMapping("/getall")
	public String getAll(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		//紧跟他的查询就是一个分页查询
		PageHelper.startPage(pn, 5);
		List<Teacher> list = teacherService.getAll();
		
		//我们可以将查询的结果使用；将查询的结果放在pageinfo中这个pageInfo就有非常多能够用的
		//第二份传入连续要显示的页码
		PageInfo<Teacher> info = new PageInfo<>(list, 6);
		System.out.println("当前页码："+info.getPageNum());
		System.out.println("总页码："+info.getPages());
		System.out.println("总记录数："+info.getTotal());
		System.out.println("当前页有几条记录："+info.getSize());
		System.out.println("当前页的pageSize："+info.getPageSize());
		System.out.println("前一页："+info.getPrePage());
		System.out.println("结果："+info.getList());//查询结果
		int[] nums = info.getNavigatepageNums();
		
		model.addAttribute("info", info);
		return "success";
	}

}
