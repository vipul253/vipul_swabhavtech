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
 * Servlet implementation class editContactController
 */
@WebServlet("/editContact")
public class EditContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditContactController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String uid = request.getParameter("id");
			ContactService contactTool = ContactService.getInstance();

			List<Contact> contacts = contactTool.getContacts();

			for (Contact contact : contacts) {
				if (uid.equals(contact.getId())) {
					request.setAttribute("name", contact.getName());
					request.setAttribute("email", contact.getEmail());
					request.setAttribute("number", contact.getNumber());

				}
			}

			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/editcontact.jsp");

			view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ContactService contactTool = ContactService.getInstance();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String number = request.getParameter("number");

		Contact newContact = new Contact(name, email, number);
		contactTool.editContact(id, newContact);
		response.sendRedirect("contacts");
	}

}
