package com.techlabs.dataservice;

public class DataService {
	static DataService service;
	
	private DataService(){
		System.out.println("service created");
	}
	
	public static DataService getInstance(){
		if(service==null){
			service=new DataService();
		}
		
		return service;
	}
	
	public void doProcessing() {
		System.out.println(this.hashCode()+" is processing");
	}
	
}
