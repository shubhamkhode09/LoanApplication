package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Student;
import com.cjc.main.service.HomeService;

@RestController
public class HomeController 
{
	@Autowired
	HomeService hs;
	
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student)
	{
		hs.saveStudent(student);
		return "Data Added Successfully";
		
	}
	
	@GetMapping("/login/{username}/{password}")
	public List<Student> login(@PathVariable String username, @PathVariable String password)
	{
		if (username.equals("admin") && password.equals("admin"))
		{
			return hs.getAll();
		}
		else
		{
			return hs.getPerticular(username, password);
		}
	
	}
	
	@PutMapping("/update/{uid}")
	public  String update(@PathVariable int uid, @RequestBody Student stu)
	{
		Student s=hs.getStudentById(uid);
		if(s!=null)
		{
			s.setName(stu.getName());
			s.setUsername(stu.getUsername());
			s.setPassword(stu.getPassword());
			s.setMobno(stu.getMobno());
			hs.saveStudent(s);
			return "Student updated successfully";
		}
		else
		{
			return "Student Not Updated";
		}
		
	}
}
