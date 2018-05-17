package com.techlabs.srp.refactor.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class InvoiceTestRunner {
	
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(InvoiceTest.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
}  
