package com.shasu19p;

public class BankAccountFacade {

	private BankAccount bankAccount;
	Validator accountValidator = null;
	Validator amountValidator = null;
	private WelcomeToBank welcomeToBank;

	public BankAccountFacade(String bankAccountNr, int acctPin) {

		bankAccount = new BankAccount(bankAccountNr, acctPin, 1000);
		accountValidator = new AccountNumberValidator(bankAccount);
		amountValidator = new AmountValidator(bankAccount);
		welcomeToBank = new WelcomeToBank();
	}

	public boolean withdrawAmount(int rupees) {

		if (accountAndAmoutDetailsCorrect(rupees)) {
			bankAccount.setBalance(bankAccount.getBalance() - rupees);
			System.out.println("Withdrawl completed. Current balance is: " + bankAccount.getBalance());

			return true;
		}

		return false;
	}

	public boolean depositAmount(int rupees) {

		if (accountAndAmoutDetailsCorrect(0)) {
			bankAccount.setBalance(bankAccount.getBalance() + rupees);
			System.out.println("Deposit completed. Current balance is: " + bankAccount.getBalance());

			return true;
		}

		return false;
	}

	private boolean accountAndAmoutDetailsCorrect(int amount) {
		if (!accountValidator.isValid()) {
			System.out.println("Account details are not correct");
			return false;
		} else if (!amountValidator.isValid() || bankAccount.getBalance() < amount) {
			System.out.println("Not sufficient fund to withdrawl. Current balance is: " + bankAccount.getBalance());
			return false;
		}

		return true;
	}

	public int getBankBalance() {
		System.out.println(welcomeToBank);
		return bankAccount.getBalance();
	}
}