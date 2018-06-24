package com.techlabs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationCount
 */
@WebServlet("/applicationCount")
public class ApplicationCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplicationCount() {
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
		ServletContext application = getServletContext();

		Integer count = (Integer) application.getAttribute("count");
		if (count == null) {
			application.setAttribute("count", 0);
		}

		out.println("<html><h2>old count = " + application.getAttribute("count")
				+ "</h2>");

		Integer i = (Integer) application.getAttribute("count");
		i = i + 1;
		application.setAttribute("count", i);

		out.println("<h2>new count = " + application.getAttribute("count")
				+ "</h2>");
		out.println("<h2><a href='summary'>Summary Page</a></h2></html>");

	}

}
