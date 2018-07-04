package com.techlabs.email.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.email.EmailTool;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/email")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmailServlet() {
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
				.getRequestDispatcher("/WEB-INF/emailForm.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "vipulsawant25@gmail.com";
		String password = "Osh5m2@@";
		
		String recipient = request.getParameter("sendTo");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		String resultMessage = "";

		try {
			EmailTool.sendEmail(host, port, mailFrom, password, recipient, subject, content);
			resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} finally {
			request.setAttribute("Message", resultMessage);
			getServletContext().getRequestDispatcher("/result.jsp").forward(
					request, response);
		}
	}
}
