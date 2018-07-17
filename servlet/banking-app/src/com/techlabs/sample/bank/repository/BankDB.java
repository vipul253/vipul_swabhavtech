package com.techlabs.sample.bank.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techlabs.sample.bank.exception.InsufficientBalanceException;
import com.techlabs.sample.bank.model.Transaction;

public class BankDB {

	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private MakeConnection makeConn = new MakeConnection();
	private List<Transaction> transactions;

	public List<Transaction> getTransactions(String name) {
		Connection conn = makeConn.connect();
		String txnQuery = "SELECT * FROM BANK_TRANSACTION WHERE NAME=?";
		transactions = new ArrayList<Transaction>();
		try {
			stmt = conn.prepareStatement(txnQuery);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			transactions = new ArrayList<Transaction>();
			while (rs.next()) {
				transactions.add(new Transaction(rs.getString("name"), rs
						.getDouble("amount"), rs.getString("type"), rs
						.getDate("date")));
			}
			conn.close();

		} catch (SQLException ex) {
			CatchException(ex);
		} finally {
			doFinally();
		}
		return transactions;
	}

	public void makeTransaction(Transaction txn) throws InsufficientBalanceException {
		Connection conn = makeConn.connect();
		String txnQuery = "INSERT INTO BANK_TRANSACTION VALUES"
				+ "(?,?,?,NOW())";
		String accQuery = txnType(txn.getType());
		try {
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement(txnQuery);
			stmt.setString(1, txn.getName());
			stmt.setDouble(2, txn.getAmount());
			stmt.setString(3, txn.getType());
			stmt.execute();

			stmt = conn.prepareStatement(accQuery);
			stmt.setDouble(1, txn.getAmount());
			stmt.setString(2, txn.getName());
			stmt.execute();

			conn.commit();
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException cx) {
				CatchException(ex);
			}
			if(ex.getSQLState().equals("45000")){
				throw new InsufficientBalanceException("Insufficient Balance");
			}
			CatchException(ex);
		} finally {
			doFinally();
		}
	}

	private String txnType(String type) {
		String depositQuery = "UPDATE BANK_MASTER SET BALANCE = BALANCE+? WHERE NAME=?";
		String withdrawQuery = "UPDATE BANK_MASTER SET BALANCE = BALANCE-? WHERE NAME=?";
		if (type.equalsIgnoreCase("D")) {
			return depositQuery;
		}
		return withdrawQuery;
	}

	public double getCurrentBalance(String name) {
		Connection conn = makeConn.connect();
		String txnQuery = "SELECT BALANCE FROM BANK_TRANSACTION WHERE NAME=?";
		double balance = -1;
		try {
			stmt = conn.prepareStatement(txnQuery);
			stmt.setString(1, name);
			rs = stmt.executeQuery();

			while (rs.next()) {
				balance = rs.getDouble("balance");
			}
			conn.close();

		} catch (SQLException ex) {
			CatchException(ex);
		} finally {
			doFinally();
		}
		return balance;
	}

	public String makeCSV(String name) {
		transactions = getTransactions(name);
		String CSV = "Name, Amount, Type, Date;\n";
		for (Transaction t : transactions) {
			CSV += t.getName() + ", " + t.getAmount() + ", " + t.getType()
					+ ", " + t.getDate() + ";\n";
		}
		return CSV;
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
			}

			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
			}
			stmt = null;
		}
	}
}