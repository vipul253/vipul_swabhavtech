package com.techlabs.sample.bank.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techlabs.sample.bank.model.Account;

public class UserDB {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private MakeConnection makeConn = new MakeConnection();

	public boolean checkUser(String name, String password) {
		Connection conn = makeConn.connect();
		String checkUserQuery = "SELECT * FROM BANK_MASTER WHERE NAME=? AND PASS=?;";
		try {
			stmt = conn.prepareStatement(checkUserQuery);
			stmt.setString(1, name);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException ex) {
			CatchException(ex);
		} finally {
			doFinally();
		}
		return false;
	}

	public void addUser(Account acc) {
		Connection conn = makeConn.connect();
		String addUserQuery = "INSERT INTO BANK_MASTER VALUES" + "(?,?,?)";
		String txnQuery = "INSERT INTO BANK_TRANSACTION VALUES"
				+ "(?,?,'D',NOW())";
		try {
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement(addUserQuery);
			stmt.setString(1, acc.getName());
			stmt.setString(2, acc.getPassword());
			stmt.setDouble(3, acc.getBalance());
			stmt.execute();

			stmt = conn.prepareStatement(txnQuery);
			stmt.setString(1, acc.getName());
			stmt.setDouble(2, acc.getBalance());
			stmt.execute();

			conn.commit();

		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException cx) {
				CatchException(ex);
			}
			CatchException(ex);
		} finally {
			doFinally();
		}
	}

	public void CatchException(SQLException ex) {
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
	}

	public void doFinally() {
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
