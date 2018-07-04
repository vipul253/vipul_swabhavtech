package com.techlabs.contact.service.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.contact.service.model.ContactService;

/**
 * Servlet implementation class AddContactController
 */
@WebServlet("/addContact")
public class AddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContactController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/addcontact.jsp");
			view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ContactService contactTool = ContactService.getInstance();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String number = request.getParameter("number");

		contactTool.addContact(name, email, number);
		response.sendRedirect("contacts");
	}
}
