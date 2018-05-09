package com.techlabs.account.inheritance.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.techlabs.account.inheritance.CurrentAccount;
import com.techlabs.account.inheritance.SavingsAccount;

public class AccountBalanceTest {
	SavingsAccount saving_acc = new SavingsAccount(321, "neiu", 1234);
	CurrentAccount current_acc = new CurrentAccount(123, "vipul", 5344);
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
