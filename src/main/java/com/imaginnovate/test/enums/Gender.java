package com.imaginnovate.test.enums;

public enum Gender {
	
	M, F;
	
	public static Gender getValidGender(String genderValue) {
	    for (Gender gender : Gender.values()) {
	        if(gender.toString().equals(genderValue))
	           return gender;
	    }
	    return null;
	}

}
