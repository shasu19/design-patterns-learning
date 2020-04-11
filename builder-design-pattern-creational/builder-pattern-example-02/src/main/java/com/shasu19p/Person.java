package com.shasu19p;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter

// Private constructor
// No setters
// Only getters
// Inside static Builder class
public class Person {

	// name and address mandatory fields
	private String name;
	private String address;

	// if age is below 18, assign school name else company name
	private int age;

	private String schoolName;
	private String companyName;

	// to achieve this condition,
		// when age is below 18, then assign school
		// else assign company
		// need to create at-least 2 constructors to meet this requirement
		// there is possibility that still some one can assign school to age more than 18
		// if we provide getter and setters
		// to solve such a problem, we will create one builder pattern
	
	
	private Person() {}
	
	static class Builder {
		
		protected Person person;
		
		// send mandatory fields for person object
		public Builder(String name, String address) {
			person = new Person();
			person.name = name;
			person.address = address;
		}

		public Builder goesToSchool(int age, String schoolName) {
			person.age = age;
			person.schoolName = schoolName;
			person.companyName = null;
			return this;
		}
		
		public Builder goesToCompany(int age, String companyName) {
			person.age = age;
			person.schoolName = null;
			person.companyName = companyName;
			return this;
		}

		public Person build() {
			return this.person;
		}
	}
}
