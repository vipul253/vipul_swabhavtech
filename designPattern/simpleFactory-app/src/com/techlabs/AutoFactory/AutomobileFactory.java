package com.techlabs.AutoFactory;

public class AutomobileFactory {
	
	static AutomobileFactory factory;
	
	private AutomobileFactory(){
		System.out.println("Factory created");
	}
	
	public static AutomobileFactory getInstance(){
		if(factory==null){
			factory = new AutomobileFactory();
		}
		return factory;
	}
	
	public Automobile make(AutoType auto){
		if(auto==AutoType.AUDI)
			return new Audi();
		else if(auto==AutoType.BMW)
			return new BMW();
		else if(auto==AutoType.TOYOTA)
			return new Toyota();
		else
			return null;
		
	}
}
