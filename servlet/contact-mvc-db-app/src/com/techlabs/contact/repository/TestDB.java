package com.techlabs.contact.repository;

import java.sql.Connection;

public class TestDB {
	public static void main(String[] args){
		MakeConnection mk = new MakeConnection();
		Connection conn = mk.connect();
		try{
			System.out.println(conn.getCatalog());
		}catch(Exception ex){}
	}
}
