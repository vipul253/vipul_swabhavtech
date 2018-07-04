package com.techlabs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatement {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/techlabs?"
							+ "user=root&password=root");

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM DEPT");
			 while (rs.next()) {
		            int deptno = Integer.parseInt(rs.getString("deptno"));
		            String dname = rs.getString("dname");
		            String loc = rs.getString("loc");
		            System.out.println("Dno: " + deptno);
		            System.out.println("Dname: " + dname);
		            System.out.println("Location: " + loc);
		        }

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}
	}
}
