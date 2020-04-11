package com.shasu19p;

public class Demo {

	public static void main(String[] args) {

		Person sunil = new Person.Builder("Sunil", "Bhopal")
				.goesToCompany(32, "TCS").build();

		System.out.println(sunil);

		Person sarvagya = new Person.Builder("Sunil", "Bhopal").goesToCompany(32, "TCS")
				.goesToSchool(13, "The Growing Tree").build();

		System.out.println(sarvagya);
	}
}