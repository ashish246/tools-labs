package com.lomdok.demo;

import lombok.Getter;
import lombok.Setter;

public class Employee {

	@Setter
	@Getter
	private String mFirstName;

	@Setter
	@Getter
	private String mLastName;

	Employee(String pFirstName, String pLastName) {
		mFirstName = pFirstName;
		mLastName = pLastName;
	}
} 
