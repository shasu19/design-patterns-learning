package com.shasu19p;

import org.junit.Assert;
import org.junit.Test;

public class BankAccountFacadeTest {

	@Test
	public void testWhenAmountNotExceedLimit() {

		BankAccountFacade client = new BankAccountFacade("12345678", 1234);
		boolean withdrawlSuccess = client.withdrawAmount(200);
		Assert.assertTrue(withdrawlSuccess);
		Assert.assertEquals(800, client.getBankBalance());
	}

	@Test
	public void testWhenAmountExceedsLimit() {

		BankAccountFacade client = new BankAccountFacade("12345678", 1234);
		boolean withdrawlSuccess = client.withdrawAmount(1200);
		Assert.assertFalse(withdrawlSuccess);
		Assert.assertEquals(1000, client.getBankBalance());
	}

	@Test
	public void testWhenAmountDepositIncreasesLimit() {

		BankAccountFacade client = new BankAccountFacade("12345678", 1234);
		boolean withdrawlSuccess = client.depositAmount(1200);
		Assert.assertTrue(withdrawlSuccess);
		Assert.assertEquals(2200, client.getBankBalance());
	}

	@Test
	public void testWhenAccountIsInValid() {

		BankAccountFacade client = new BankAccountFacade("12345679", 1234);
		boolean withdrawlSuccess = client.depositAmount(1200);
		Assert.assertFalse(withdrawlSuccess);
		Assert.assertEquals(1000, client.getBankBalance());
	}

	@Test
	public void testWhenAmountIsNearToMinimumLimit() {

		BankAccountFacade client = new BankAccountFacade("12345678", 1234);
		boolean withdrawlSuccess = client.withdrawAmount(900);
		Assert.assertTrue(withdrawlSuccess);
		Assert.assertEquals(100, client.getBankBalance());

		withdrawlSuccess = client.withdrawAmount(20);
		Assert.assertFalse(withdrawlSuccess);
		Assert.assertEquals(100, client.getBankBalance());

	}
}
