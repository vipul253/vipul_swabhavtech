package com.techlabs.rtocodes.test;

import java.util.Map;
import java.util.Scanner;

import com.techlabs.rtocodes.*;

public class rtoCodesTest {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		rtoCodeList list = new rtoCodeList();

		int ch;

		do {
			System.out.println("\nEnter your choice:");
			System.out.println("1: Display All RTO Codes\n2: Search by RTO Code\n3: Exit");
			ch = in.nextInt();

			switch (ch) {
				case 1:
					DisplayRTO(list.getRTOlist());
					break;
	
				case 2:
					System.out.println("Enter search term : ");
					String search = in.next();
					DisplayRTO(list.searchRTOCode(search));
					break;
	
				default:
					System.out.println("Invalid Choice");
			}

		}while (ch != 3);
		in.close();
	}
	
	public static void DisplayRTO(Map<String,String> list){
		if(!list.isEmpty()){
			for (Map.Entry<String, String> entry : list.entrySet()) {
				System.out.println(entry.getKey()+"-"+entry.getValue());
			}
		}
		else System.out.println("no matching results");
	}
}