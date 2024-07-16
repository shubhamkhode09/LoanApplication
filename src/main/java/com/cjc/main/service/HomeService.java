package com.cjc.main.service;


import java.util.List;

import com.cjc.main.model.Student;

public interface HomeService 
{

	public void saveStudent(Student student);

	public List<Student> getAll();

	public List<Student> getPerticular(String username, String password);

	public Student getStudentById(int uid);

}
