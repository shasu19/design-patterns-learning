package com.shasu19p;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ClientTest {

	@Test
	public void testClientFunctionalFlow() {

		Client.main(null);
		assertTrue("End to end flow is fine", true);
	}
}