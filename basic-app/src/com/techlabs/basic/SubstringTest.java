package com.techlabs.basic;

public class SubstringTest {

	public static void main(String[] args) {
		String addr = "www.swabhavtechlabs.com?developer=vipul";
		int a = addr.indexOf(".")+1;
		int b = addr.lastIndexOf(".");
		
		System.out.println("Using substring");
		System.out.println("Domain name: "+addr.substring(a,b));
		a = addr.indexOf("=")+1;
		System.out.println("Dev name: "+addr.substring(a));
		
		System.out.println("\nUsing Split");
		String temp[] = addr.split("\\.");
		System.out.println("Domain name: "+temp[1]);
		temp = addr.split("\\=");
		System.out.println("Dev name: "+temp[1]);
		
	}

}
