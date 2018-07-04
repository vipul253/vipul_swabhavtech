package com.techlabs.contact.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

public class UsersDB {
	
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private MakeConnection makeConn = new MakeConnection();
	private Map<String, String> users;
	
	public Map<String,String> getUsers() {
		Connection conn = makeConn.connect();
		try {
			stmt = conn.prepareStatement("select * from users");
			rs = stmt.executeQuery();
			users = new HashMap<String, String>();
			while (rs.next()) {
				users.put(rs.getString("username"), rs.getString("pass"));
			}

		} catch (SQLException ex) {
			CatchException(ex);
		} finally {
			doFinally();
		}
		return users;
	}
	
	public void addUser(String name,String pass){
		Connection conn = makeConn.connect();
		String query = "INSERT INTO users VALUES" + "(?,?)";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, pass);
			stmt.execute();

		} catch (SQLException ex) {
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
