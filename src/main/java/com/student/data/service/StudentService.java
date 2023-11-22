
package com.student.data.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.data.model.Student;
import com.student.data.repository.StudentRepository;
import com.student.data.utils.ApiResponse;

@Service
public class StudentService implements IStudentService {

	@Autowired
	public StudentRepository studentRepository;

	@Override
	public ApiResponse insertData(Student student) {

		Optional<Student> opt = studentRepository.findById(student.getName());

		if (opt.isEmpty()) {
			if(student.getSATscore()>30)
				student.setStatus("Pass");
			else
				student.setStatus("Fail");

			Student savedStudent = studentRepository.save(student);
			return ApiResponse.success("Inserted Successfully", savedStudent);

		} else {
			return ApiResponse.error("Student with username already exists", null);
		}
	}

	@Override
	public ApiResponse updateSATscore(String name, int score) {
		Optional<Student> opt = studentRepository.findById(name);

		if (opt.isEmpty())
			return ApiResponse.error("Student with the given user name does not exits", null);

		else {
			Student existingStudent = opt.get();
			existingStudent.setSATscore(score);
			Student updatedStudent = studentRepository.save(existingStudent);
			return ApiResponse.success("Updated Successfully", updatedStudent);

		}
	}

	@Override
	public ApiResponse getData() {
		// TODO Auto-generated method stub
		List<Student> studentList = studentRepository.findAll();
		return ApiResponse.success("Collected Successfully", studentList);

	}

	@Override
	public ApiResponse getRank(String name) {
		Optional<Student> opt = studentRepository.findById(name);

		if (opt.isEmpty())
			return ApiResponse.error("Student with the given user name does not exits", null);
		else {
			List<Student> studentList = studentRepository.findAll();

			Collections.sort(studentList, Comparator.comparingInt(Student::getSATscore).reversed());
			
			int rank = studentList.indexOf(opt.get()) + 1;
			return ApiResponse.success("Calculated the rank Successfully",rank);
			
		}
	}

	@Override
	public ApiResponse deleteRecord(String name) {
		// TODO Auto-generated method stub
		Optional<Student> opt = studentRepository.findById(name);

		if (opt.isEmpty())
			return ApiResponse.error("Student with the given user name does not exits", null);
		
		else {
			studentRepository.delete(opt.get());
			return ApiResponse.success("Deleted Successfully",null);

			
		}
		
	}

}
