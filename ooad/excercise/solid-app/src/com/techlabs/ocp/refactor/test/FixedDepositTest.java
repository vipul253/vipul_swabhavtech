package com.techlabs.ocp.refactor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.ocp.refactor.*;

public class FixedDepositTest {
	
	FixedDeposit deposit = new FixedDeposit(1120,"nieu",24909.0,7,new HoliRate());
	
	@Test
	public void testFields() {
		assertTrue(deposit.getAccount()==1120);
		assertTrue(deposit.getName().equals("nieu"));
		assertTrue(deposit.getPrincipal()==24909.0);
		assertTrue(deposit.getDuration()==7);
		assertTrue(deposit.getFestival().getRate()==8.0);
	}
	
	@Test
	public void testInterest(){
		double expectedInterest = 1419813.0;
		assertTrue(deposit.calcSimpleInterest()==expectedInterest);
	}
}
