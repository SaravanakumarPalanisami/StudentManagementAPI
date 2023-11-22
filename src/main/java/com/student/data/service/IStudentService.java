package com.student.data.service;

import org.springframework.stereotype.Service;

import com.student.data.model.Student;
import com.student.data.utils.ApiResponse;

@Service
public interface IStudentService {
	
	public ApiResponse insertData(Student student);
	
	public ApiResponse updateSATscore(String name,int score);
	
	public ApiResponse getData();
	
	public ApiResponse getRank(String name);
	
	public ApiResponse deleteRecord(String name);

}
