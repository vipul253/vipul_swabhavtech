package com.techlabs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessionCount
 */
@WebServlet("/sessionCount")
public class SessionCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		if (session.isNew()) {
			session.setAttribute("count", 0);
		}

		out.println("<html><h2>old count = " + session.getAttribute("count") + "</h2>");

		Integer i = (Integer) session.getAttribute("count");
		i = i + 1;
		session.setAttribute("count", i);

		out.println("<h2>new count = " + session.getAttribute("count") + "</h2>");
		out.println("<h2>Session ID = " + session.getId() + "</h2>");
		out.println("<h2><a href='summary'>Summary Page</a></h2></html>");

	}

}
