package com.imaginnovate.test.response;

import com.imaginnovate.test.beans.StudentBean;

import lombok.Data;

@Data
public class StudentResponse {
	
	private Boolean isSuccess = true;
	private String errorMessage;
	private StudentBean student;

}
