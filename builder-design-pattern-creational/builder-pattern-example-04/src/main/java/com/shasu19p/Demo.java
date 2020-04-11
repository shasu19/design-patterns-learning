
package com.shasu19p;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
class Person {

	private String name;

	// address
	private String city;
	private String pinCode;

	// work details
	private String company;
	private int annualSalary;

	private Person() {
	}

	static class PersonBuilder<SELF extends PersonBuilder<SELF>> {

		protected Person person = new Person();

		public SELF withName(String name) {
			person.name = name;
			return self();
		}

		public SELF self() {
			return (SELF) this;
		}

		public Person build() {
			return this.person;
		}
	}

	static class EmploymentBuilder extends PersonBuilder<EmploymentBuilder> {

		public EmploymentBuilder worksIn(String companyName) {
			person.company = companyName;

			return self();
		}
		
		public EmploymentBuilder annualEarning(int annualPackage) {
			person.annualSalary = annualPackage;
			return self();
		}

		@Override
		public EmploymentBuilder self() {
			return this;
		}
	}
}

public class Demo {

	public static void main(String[] args) {

		Person person1 = new Person.EmploymentBuilder()
							.withName("Sunil")
							.annualEarning(1500000)
							.worksIn("Learn and Grow")
							.build();
							

		System.out.println(person1);
	}
}