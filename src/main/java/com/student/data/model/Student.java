package com.student.data.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="student")
@Data

public class Student {
		
	@Id
	private String  name;
	
	private String address;
	
	private String city;
	
	private String country;
	
	private String pincode;
	
	private int SATscore;
	
	private String status;
	

}
