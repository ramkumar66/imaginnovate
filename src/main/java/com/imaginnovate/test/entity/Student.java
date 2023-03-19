package com.imaginnovate.test.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "section")
	private String section;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "marks1")
	private Double marks1;
	
	@Column(name = "marks2")
	private Double marks2;
	
	@Column(name = "marks3")
	private Double marks3;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "average")
	private Double average;
	
	@Column(name = "result")
	private String result;

}
