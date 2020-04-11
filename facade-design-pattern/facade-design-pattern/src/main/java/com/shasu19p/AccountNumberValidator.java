package com.shasu19p;

public class AccountNumberValidator implements Validator {

	private BankAccount bankAccount;

	public AccountNumberValidator(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public boolean isValid() {
		return dbCallAndLongValidation();
	}

	private boolean dbCallAndLongValidation() {

		String acctNrInDb = "12345678";
		int pinInDb = 1234;
		// true if db and passed details matched
		return (this.bankAccount.getBankAcctNr().equals(acctNrInDb) && this.bankAccount.getPin() == pinInDb);
	}
}