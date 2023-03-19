package com.imaginnovate.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.test.beans.StudentBean;
import com.imaginnovate.test.entity.Student;
import com.imaginnovate.test.exception.BadRequestException;
import com.imaginnovate.test.repository.StudentRepository;
import com.imaginnovate.test.util.DataValidationUtils;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public void saveStudent(StudentBean studentBean) throws BadRequestException{
		
		Student student = new Student();
		
		if(studentBean.getId()!= null) {
			if(!repository.existsById(studentBean.getId())) {
				throw new BadRequestException("Student with id: " + studentBean.getId() + " does not exist");
			}
			student.setId(studentBean.getId());
		}
		
		if(!DataValidationUtils.validateStudentName(studentBean.getFirstName())) {
			throw new BadRequestException("First name should be atleast 3 characters length");
		}
		student.setFirstName(studentBean.getFirstName());
		
		if(!DataValidationUtils.validateStudentName(studentBean.getLastName())) {
			throw new BadRequestException("Last name should be atleast 3 characters length");
		}
		student.setLastName(studentBean.getLastName());
		
		if(!DataValidationUtils.validateDob(studentBean.getDob())) {
			throw new BadRequestException("Age should be betweeen 15 and 20");
		}
		student.setDob(studentBean.getDob());
		
		if(!DataValidationUtils.validateMarks(studentBean.getMarks1())) {
			throw new BadRequestException("Marks in subject 1 should be between 35 and 100");
		}
		student.setMarks1(studentBean.getMarks1());
		
		if(!DataValidationUtils.validateMarks(studentBean.getMarks2())) {
			throw new BadRequestException("Marks in subject 2 should be between 35 and 100");
		}
		student.setMarks2(studentBean.getMarks2());
		
		if(!DataValidationUtils.validateMarks(studentBean.getMarks3())) {
			throw new BadRequestException("Marks in subject 3 should be between 35 and 100");
		}
		student.setMarks3(studentBean.getMarks3());
		
		if(!DataValidationUtils.validateSection(studentBean.getSection())) {
			throw new BadRequestException("Section should be A/ B/ C");
		}
		student.setSection(studentBean.getSection());
		
		if(!DataValidationUtils.validateGender(studentBean.getGender())) {
			throw new BadRequestException("Gender should be M/ F");
		}
		student.setGender(studentBean.getGender());
		
		populateResults(student, studentBean);
		
		student = repository.save(student);
		studentBean.setId(student.getId());
	}

	private void populateResults(Student student, StudentBean studentBean) {
		Double total = Double.sum(studentBean.getMarks1(), Double.sum(studentBean.getMarks2(), studentBean.getMarks3()));
		student.setTotal(total);
		studentBean.setTotal(total);
		Double average = total/3;
		student.setAverage(average);
		studentBean.setAverage(average);
		if(studentBean.getMarks1() < 35 || studentBean.getMarks2() < 35 || studentBean.getMarks3() < 35) {
			student.setResult("Fail");
			studentBean.setResult("Fail");
		} else {
			student.setResult("Pass");
			studentBean.setResult("Pass");
		}
	}

}
