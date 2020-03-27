package com.shasu19p;

public class Client {

	public static void main(String[] args) {

		// Asking customer to choose network - Airtel
		billingFor("AIRTEL", 20);

		// Asking customer to choose network - Idea
		billingFor("Idea".toUpperCase(), 20);

		// Asking customer to choose network - Reliance
		billingFor("RELIANCE", 20);

		// Asking customer to choose network - unknown
		billingFor("unknown", 20);

		// Asking customer to choose network - Vodafone
		billingFor("VODAFONE", 20);
	}

	private static void billingFor(String provider, int minutes) {
		double charges = new Billing().chargeFor(minutes, provider);
		System.out.println("Charges for minutes " + minutes + " with network " + provider + " : " + charges);
	}
}