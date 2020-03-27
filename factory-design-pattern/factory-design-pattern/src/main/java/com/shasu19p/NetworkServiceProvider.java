package com.shasu19p;

public abstract class NetworkServiceProvider {

	public abstract double getCallRate();

	// return total amount to charge for n minutes talk
	public double amountToCharge(int minutesTalk) {

		return getCallRate() * minutesTalk;
	}
}