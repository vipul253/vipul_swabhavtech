package com.techlabs.decorator.test;

import com.techlabs.account.*;
import com.techlabs.logger.*;

public class DecoratorTest {

	public static void main(String[] args) {

		IAccount acc = new Account(123, "neiu", 1000);
		IAccount acc1 = new Logger(acc);

		acc.deposit(100);
		acc1.deposit(100);

	}
}
