package com.shasu19p;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceProviderFactory {

	private static Logger logger = Logger.getLogger(ServiceProviderFactory.class.getName());

	public static NetworkServiceProvider getProvider(String providerName) throws NetworkProviderException {

		ProviderNames provider = getServiceProvider(providerName);

		switch (provider) {

		case AIRTEL:
			return new AirtelServiceProvider();
		// no need of break
		// break becomes unreachable and return will return the flow itself
		case IDEA:
			return new IdeaServiceProvider();

		case RELIANCE:
			return new RelianceServiceProvider();

		default:
			throw new NetworkProviderException("Network '" + providerName + "' is not supported any more");
		}
	}

	private static ProviderNames getServiceProvider(String providerName) throws NetworkProviderException {
		try {
			return ProviderNames.valueOf(providerName);
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Proper does not resolved by name [" + providerName + "]");
			throw new NetworkProviderException("Proper does not resolved by name [" + providerName + "]");
		}
	}
}