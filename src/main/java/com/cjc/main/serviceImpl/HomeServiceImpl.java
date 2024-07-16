package com.cjc.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService
{
	@Autowired
	HomeRepository hr;

	@Override
	public void saveStudent(Student student) 
	{
		// TODO Auto-generated method stub
		hr.save(student);
	}

	@Override
	public List<Student> getAll() 
	{
		// TODO Auto-generated method stub
		return (List<Student>) hr.findAll();
		
	}

	@Override
	public List<Student> getPerticular(String username, String password) 
	{
		// TODO Auto-generated method stub
		return hr.findAllByUsernameAndPassword(username, password);
	}

	@Override
	public Student getStudentById(int uid) 
	{
		// TODO Auto-generated method stub
		return hr.findById(uid).orElse(null);
	}


	


	
	
}
