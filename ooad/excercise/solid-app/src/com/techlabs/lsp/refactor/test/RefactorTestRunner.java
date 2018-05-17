package com.techlabs.lsp.refactor.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RefactorTestRunner {
	
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(RectangleTest.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
}  