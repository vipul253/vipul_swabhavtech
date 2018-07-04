package com.techlabs.sample.bank.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {
	private Connection conn = null;
	private ConnectionURL urlTool;

	public Connection connect() {

		try {
			urlTool = new ConnectionURL();
			String url = urlTool.getURL();
			conn = DriverManager.getConnection(url);
			//"jdbc:mysql://localhost:4040/contactsdb?user=root&password=root"

		} catch (SQLException ex) {
			System.out.println("exception: " + ex.getMessage());
		}
		return conn;
	}
}
