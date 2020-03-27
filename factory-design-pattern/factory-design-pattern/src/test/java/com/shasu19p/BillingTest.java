package com.shasu19p;

import org.junit.Assert;
import org.junit.Test;

public class BillingTest {

	// when 20 minutes talk charged with AIRTEL network
	@Test
	public void testAiterlProviderCharges() {
		Assert.assertTrue(40.0 == billingFor(ProviderNames.AIRTEL.toString(), 20));
	}

	// when 20 minutes talk charged with IDEA network
	@Test
	public void testIdeaProviderCharges() {
		Assert.assertTrue(30.0 == billingFor(ProviderNames.IDEA.toString(), 20));
	}

	// when 20 minutes talk charged with RELIANCE network
	@Test
	public void testRelianceProviderCharges() {
		Assert.assertTrue(24.0 == billingFor(ProviderNames.RELIANCE.toString(), 20));
	}

	// when 20 minutes talk charged with unknown network
	@Test
	public void testStandardProviderCharges() {
		Assert.assertTrue(50.0 == billingFor("randomProvider", 20));
	}

	// when 20 minutes talk charged with VODAFONE unsupported network
	@Test
	public void testVodafoneProviderCharges() {
		Assert.assertTrue(50.0 == billingFor(ProviderNames.VODAFONE.toString(), 20));
	}

	private double billingFor(String provider, int minutes) {
		return new Billing().chargeFor(minutes, provider);
	}

}