package com.techlabs.contact.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techlabs.contact.service.model.*;

public class ContactDB {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private MakeConnection makeConn = new MakeConnection();
	private List<Contact> contacts;

	public List<Contact> getContacts() {
		Connection conn = makeConn.connect();
		try {
			stmt = conn.prepareStatement("select * from contacts");
			rs = stmt.executeQuery();
			contacts = new ArrayList<Contact>();
			while (rs.next()) {
				contacts.add(new Contact(rs.getString("id"),rs.getString("name"), 
						rs.getString("email"), rs.getString("mobno")));
			}
			conn.close();

		} catch (SQLException ex) {
			CatchException(ex);
		} finally {
			doFinally();
		}
		return contacts;
	}

	public void addContact(Contact c) {
		Connection conn = makeConn.connect();
		String query = "INSERT INTO contacts VALUES" + "(?,?,?,?)";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, c.getId());
			stmt.setString(2, c.getName());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getNumber());
			stmt.execute();
			conn.close();
		} catch (SQLException ex) {
			CatchException(ex);
		} finally {
			doFinally();
		}
	}

	public void editContact(String id, Contact c) {
		Connection conn = makeConn.connect();
		String query = "UPDATE contacts SET name = ?, email = ?, mobno = ? WHERE id = ?";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getNumber());
			stmt.setString(4, id);
			stmt.execute();
			conn.close();
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
