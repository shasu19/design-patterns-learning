package com.shasu19p;


import org.junit.Assert;
import org.junit.Test;


public class BankApplicationClientTest {

	@Test
	public void test() {
		BankApplicationClient applicationClient = new BankApplicationClient();
		applicationClient.main(null);
		Assert.assertTrue(true);
	}
}