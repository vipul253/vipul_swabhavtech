package com.techlabs.contact.service.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.contact.service.model.Contact;
import com.techlabs.contact.service.model.ContactService;

/**
 * Servlet implementation class ContactController
 */
@WebServlet("/contacts")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 

		ContactService contactTool = ContactService.getInstance();
		List<Contact> contacts = contactTool.getContacts();

		request.setAttribute("contactList", contacts);
		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/contacts.jsp");
		view.forward(request, response);
	}
}