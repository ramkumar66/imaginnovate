package com.imaginnovate.test.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.imaginnovate.test.enums.Gender;
import com.imaginnovate.test.enums.Section;

public class DataValidationUtils {
	
	public static boolean validateStudentName(String name) {
		if(StringUtils.isBlank(name)) {
			return false;
		}
		if(name.length() < 3) {
			return false;
		}
		return true;
	}
	
	public static boolean validateDob(Date date) {
		if(date != null) {
			LocalDate date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate date2 = LocalDate.now();
			Period period = Period.between(date1, date2);
			int difference = period.getYears();
			if(difference > 15 && difference <= 20) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean validateMarks(Double marks) {
		if(marks == null || (marks != null && (marks < 0 || marks > 100))) {
			return false;
		}
		return true;
	}
	
	public static boolean validateSection(String section) {
		if(StringUtils.isBlank(section) || Section.getValidGender(section) == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateGender(String gender) {
		if(StringUtils.isBlank(gender) || Gender.getValidGender(gender) == null) {
			return false;
		}
		return true;
	}

}
