package com.techlabs.game.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class GameTestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CellTest.class,BoardTest.class,AnalyserTest.class,PlayerTest.class,GameTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}

}
