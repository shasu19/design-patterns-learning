package com.shasu19p;

public class Demo {

	public static void main(String[] args) {

		Person person1 = new Person
							.Builder("Sunil", "Bhopal")
							.build();

		System.out.println(person1);

		Person person2 = new Person.Builder("Sarvagya", "Bhopal")
							.setUnderAge(4)
							.goesToSchool("The Growing Tree")
							.build();

		System.out.println(person2);
		
		Person person3 = new Person.Builder("Sunandni", "Bhopal")
				.setAboveAge(32)
				.goesToCompany("Google")
				.build();
		
		System.out.println(person3);
	}
}