package com.shasu19p;

public class BankApplicationClient {

	public static void main(String[] args) {

		// facade to bank withdrawl and deposit
		BankAccountFacade accessingBank = new BankAccountFacade("12345678", 1234);

		accessingBank.withdrawAmount(50);
		accessingBank.withdrawAmount(600);
		accessingBank.depositAmount(300);
		accessingBank.withdrawAmount(700);
		accessingBank.depositAmount(200);
	}
}
