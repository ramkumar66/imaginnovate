package com.imaginnovate.test.beans;

import java.util.Date;

import lombok.Data;

@Data
public class StudentBean {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String section;
	private String gender;
	private Double marks1;
	private Double marks2;
	private Double marks3;
	private Double total;
	private Double average;
	private String result;

}
