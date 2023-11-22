package com.student.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.data.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
