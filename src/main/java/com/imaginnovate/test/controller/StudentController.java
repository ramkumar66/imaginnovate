package com.imaginnovate.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.test.beans.StudentBean;
import com.imaginnovate.test.exception.BadRequestException;
import com.imaginnovate.test.response.StudentResponse;
import com.imaginnovate.test.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping
	public ResponseEntity<StudentResponse> saveStudent(@RequestBody StudentBean student) {
		StudentResponse response = new StudentResponse();
		response.setStudent(student);
		try {
			service.saveStudent(student);
		} catch (BadRequestException e) {
			response.setIsSuccess(false);
			response.setErrorMessage(e.getMessage());
			return new ResponseEntity<StudentResponse>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
	}

}
