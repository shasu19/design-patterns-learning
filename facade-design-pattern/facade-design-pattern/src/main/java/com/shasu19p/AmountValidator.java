package com.shasu19p;

public class AmountValidator implements Validator {

	int minBalance = 100;
	BankAccount bankAccount;

	public AmountValidator(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public boolean isValid() {
		return bankAccount.getBalance() > minBalance;
	}
}