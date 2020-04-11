package com.shasu19p;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter

// to achieve this condition,
// when age is below 18, then assign school
// else assign company
// need to create at-least 2 constructors to meet this requirement
// there is possibility that still some one can assign school to age more than 18
// if we provide getter and setters
// to solve such a problem, we will create one builder pattern

////////////////////////

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

	private Person() {
	}

	// Main starting builder
	// Adult Builder for adult object creation
	// UnderAgeBuilder for non adult object creation
	static class Builder {

		protected Person person;

		// send mandatory fields for person object
		public Builder(String name, String address) {
			person = new Person();
			person.name = name;
			person.address = address;
		}

		public UnderAgeBuilder setUnderAge(int age) {
			person.age = age;
			return new UnderAgeBuilder(this.person);
		}

		public AdultAgeBuilder setAboveAge(int age) {
			person.age = age;
			return new AdultAgeBuilder(person);
		}

		public Person build() {
			return this.person;
		}
	}

	static class AdultAgeBuilder {

		private Person person;

		public AdultAgeBuilder(Person person) {
			this.person = person;
		}

		public AdultAgeBuilder goesToCompany(String companyName) {
			this.person.companyName = companyName;
			return this;
		}

		public Person build() {
			return this.person;
		}
	}

	static class UnderAgeBuilder {

		private Person person;

		public UnderAgeBuilder(Person person) {
			this.person = person;
		}

		public UnderAgeBuilder goesToSchool(String schoolName) {
			this.person.schoolName = schoolName;
			return this;
		}

		public Person build() {
			return this.person;
		}
	}
}
