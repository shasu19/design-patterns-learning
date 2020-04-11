package com.shasu19p;

public class BankAccount {

	String bankAcctNr;
	int pin;
	int balance;

	public BankAccount(String bankAcctNr, int pin, int initialAmt) {
		this.bankAcctNr = bankAcctNr;
		this.pin = pin;
		this.balance = initialAmt;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public String getBankAcctNr() {
		return bankAcctNr;
	}
	
	public int getPin() {
		return pin;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
}