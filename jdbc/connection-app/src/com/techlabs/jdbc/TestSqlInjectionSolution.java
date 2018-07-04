package com.techlabs.jdbc;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TestSqlInjectionSolution {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Scanner in = new Scanner(System.in);
		String ch = "1";

		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:4040/techlabs?allowMultiQueries=true&"
							+ "user=root&password=root");

			while (ch != "0") {
				System.out.println("enter deptno");
				String dno = in.nextLine();
				stmt = conn
						.prepareStatement("SELECT * FROM DEPT where deptno =?");
				stmt.setString(1, dno);
				rs = stmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("deptno"));
					System.out.println(rs.getString("dname"));
					System.out.println(rs.getString("loc"));
				}
				System.out.println("q to exit");
				ch = in.nextLine();
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