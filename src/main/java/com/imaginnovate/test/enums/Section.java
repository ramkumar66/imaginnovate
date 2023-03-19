package com.imaginnovate.test.enums;

public enum Section {
	
	A, B, C;
	
	public static Section getValidGender(String sectionValue) {
	    for (Section section : Section.values()) {
	        if(section.toString().equals(sectionValue))
	           return section;
	    }
	    return null;
	}

}
