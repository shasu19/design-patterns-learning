
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

	static class PersonBuilder {

		protected Person person = new Person();

		public PersonBuilder withName(String name) {
			person.name = name;
			return this;
		}

		public PersonAddressBuilder lives() {
			return new PersonAddressBuilder(person);
		}

		public PersonCompanyBuilder works() {
			return new PersonCompanyBuilder(person);
		}

		public Person build() {
			return this.person;
		}
	}

	static class PersonCompanyBuilder extends PersonBuilder {

		public PersonCompanyBuilder(Person person) {
			this.person = person;
		}

		public PersonCompanyBuilder inCompany(String companyName) {
			person.company = companyName;
			return this;
		}

		public PersonCompanyBuilder earns(int annualPackage) {
			person.annualSalary = annualPackage;
			return this;
		}
	}

	static class PersonAddressBuilder extends PersonBuilder {

		public PersonAddressBuilder(Person person) {
			this.person = person;
		}

		public PersonAddressBuilder inCity(String city) {
			person.city = city;
			return this;
		}

		public PersonAddressBuilder pincode(String pinCode) {
			person.pinCode = pinCode;
			return this;
		}
	}
}

public class Demo {

	public static void main(String[] args) {

		Person person1 = new Person.PersonBuilder()
						.withName("Sunil")
						.lives()
							.inCity("Hyderabad")
							.pincode("500032")
						.works()
							.inCompany("NewCompany2020")
							.earns(1500000)
						.build();

		System.out.println(person1);
	}
}