package com.techlabs.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DemoTransaction {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmtUpdate = null;
		Scanner in = new Scanner(System.in);
		ResultSet rs = null;
		String ch = "1";

		String updateCustomer = "UPDATE CUSTOMER SET BALANCE = BALANCE - ? "
				+ "WHERE NAME = ?";

		String updateMerchant = "UPDATE MERCHANT SET BALANCE = BALANCE + ? "
				+ "WHERE NAME = ?";

		String showBalanceCust = "SELECT BALANCE FROM CUSTOMER WHERE NAME=?";
		String showBalanceMerc = "SELECT BALANCE FROM MERCHANT WHERE NAME=?";

		while (ch != "0") {
			
			try {
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost:4040/techlabs?allowMultiQueries=true&"
								+ "user=root&password=root");

				conn.setAutoCommit(false);
				System.out.print("enter amount: ");
				double amount = in.nextDouble();
				stmtUpdate = conn.prepareStatement(updateCustomer);
				stmtUpdate.setDouble(1, amount);
				stmtUpdate.setString(2, "vipul");
				stmtUpdate.execute();

				stmtUpdate = conn.prepareStatement(updateMerchant);
				stmtUpdate.setDouble(1, amount);
				stmtUpdate.setString(2, "Merc");
				stmtUpdate.execute();

				stmtUpdate = conn.prepareStatement(showBalanceCust);
				stmtUpdate.setString(1, "vipul");
				rs = stmtUpdate.executeQuery();
				while (rs.next()) {
					System.out.println("Customer balance:"
							+ rs.getString("BALANCE"));
				}

				stmtUpdate = conn.prepareStatement(showBalanceMerc);
				stmtUpdate.setString(1, "Merc");
				rs = stmtUpdate.executeQuery();
				while (rs.next()) {
					System.out.println("Merchant balance: "
							+ rs.getString("BALANCE"));
				}
				conn.commit();

			} catch (SQLException ex) {
				try {
					conn.rollback();
				} catch (SQLException cx) {
					System.out.println("conn close error: " + cx.getMessage());
				}
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
				if (stmtUpdate != null) {
					try {
						stmtUpdate.close();
					} catch (SQLException sqlEx) {
					} // ignore

					stmtUpdate = null;
				}
			}
			ch = in.nextLine();
		}
		in.close();
	}
}