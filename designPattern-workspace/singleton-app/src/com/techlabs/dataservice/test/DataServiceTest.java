package com.techlabs.dataservice.test;

import com.techlabs.dataservice.*;

public class DataServiceTest {

	public static void main(String[] args) {
		DataService service1 = DataService.getInstance();
		DataService service2 = DataService.getInstance();
		
		service1.doProcessing();
		service2.doProcessing();
		
	}

}
