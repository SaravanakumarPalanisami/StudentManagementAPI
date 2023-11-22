package com.student.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.data.model.Student;
import com.student.data.service.IStudentService;
import com.student.data.utils.ApiResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend URL

public class StudentController {

	@Autowired
	public IStudentService studentService;

	@PostMapping("/insert")
	public ResponseEntity<ApiResponse> insertData(@RequestBody Student student) {

		ApiResponse response = studentService.insertData(student);
		return new ResponseEntity(response, HttpStatusCode.valueOf(200));
	}

	@PutMapping("/update/")
	public ResponseEntity<ApiResponse> updateScore(@RequestParam String name,@RequestParam int score) {

		ApiResponse response = studentService.updateSATscore(name,score);
		return new ResponseEntity(response, HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/getstudentlist")
	public  ResponseEntity<ApiResponse> getList(){
		ApiResponse response=studentService.getData();
		return new ResponseEntity(response, HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/getrank/")
	public ResponseEntity<ApiResponse> getRank(@RequestParam String name) {
		ApiResponse response=studentService.getRank(name);
		return new ResponseEntity(response, HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("/delete/")
	public ResponseEntity<ApiResponse> deleteStudent(@RequestParam String name) {
		ApiResponse response=studentService.deleteRecord(name);
		return new ResponseEntity(response, HttpStatusCode.valueOf(200));
	}

}
