package com.techlabs.sample.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlabs.sample.bank.model.AccountService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountService loginTool;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		loginTool = new AccountService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/login.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("pwd");

		if (loginTool.checkUser(name, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			response.sendRedirect("displayTransactions");
		} else {
			request.setAttribute("error", "invalid name or password, if new user please register");
			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/login.jsp");
			view.forward(request, response);
		}
	}
}
