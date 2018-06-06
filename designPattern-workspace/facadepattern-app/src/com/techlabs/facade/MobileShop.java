package com.techlabs.facade;

public class MobileShop {
	
	private SmartPhone samsung,iphone,windows;
	
	public MobileShop(){
		this.samsung = new Samsung();
		this.iphone = new Iphone();
		this.windows = new Windows();
	}
	
	public void samsungSale(){
		samsung.modelName();
		samsung.price();
	}
	
	public void iphoneSale(){
		iphone.modelName();
		iphone.price();
	}
	
	public void windowsSale(){
		windows.modelName();
		windows.price();
	}	
}
