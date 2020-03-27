package com.shasu19p;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Billing {

	Logger logger = Logger.getLogger(Billing.class.getName());

	public double chargeFor(int minutes, String providerName) {

		try {
			// charge as per provider.
			// if provider does not match, then will get NetworkProviderException exception
			return ServiceProviderFactory.getProvider(providerName).amountToCharge(minutes);
		} catch (NetworkProviderException e) {

			logger.log(Level.SEVERE, "Failed to process this billing");

			// apply standard charges
			logger.log(Level.FINE, "Applying standard billing for this transaction");
			return applyStandardCharges(minutes);
		}
	}

	private double applyStandardCharges(int minutes) {
		return minutes * 2.5;
	}
}