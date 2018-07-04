package com.techlabs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMsSqlConnection {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// the sql server driver string
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// the sql server url
			String url = "jdbc:sqlserver://localhost:59380;DatabaseName=swabhav;integratedSecurity=true;";

			// get the sql server database connection
			conn = DriverManager.getConnection(url);

			// now do whatever you want to do with the connection
			System.out.println(conn.getCatalog());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
	}
}
