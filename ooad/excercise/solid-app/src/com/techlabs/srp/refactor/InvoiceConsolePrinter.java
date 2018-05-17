package com.techlabs.srp.refactor;

public class InvoiceConsolePrinter implements InvoicePrinter {
	
	public void print(Invoice invoice){
		System.out.println("----Invoice Details----\nNumber:"+invoice.getNumber()+"\nName:"+invoice.getName()+"\nCost:"+invoice.getCost()
				+"\nDiscount:"+invoice.getDiscount()+"\nFinal Cost:"+invoice.calcTotalCost());
	}
}
