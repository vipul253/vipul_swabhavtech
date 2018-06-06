package com.techlabs.facade.test;

import java.io.*;

import com.techlabs.facade.MobileShop;

public class ShopTest {
	private static int  choice;  
	public static void main(String args[]) throws NumberFormatException, IOException{  
		do{       
			System.out.println("\n========== Mobile Shop ============");  
			System.out.print("           1. Iphone              \n");  
			System.out.print("           2. Samsung              \n");  
			System.out.print("           3. Windows            \n");  
			System.out.print("           4. Exit.                     \n");  
			System.out.print("\nEnter your choice: ");  

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			choice=Integer.parseInt(br.readLine());  
			MobileShop shop=new MobileShop();  

			switch (choice) {  
			case 1:  
			{   
				shop.iphoneSale();  
			}  
			break;  
			case 2:  
			{  
				shop.samsungSale();        
			}  
			break;    
			case 3:  
			{  
				shop.windowsSale();       
			}  
			break;     
			default:  
			{    
				System.out.println("exited");  
			}         
			return;  
			}  

		}while(choice!=4);  
	}  
}  