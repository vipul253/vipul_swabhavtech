package com.techlabs.listener.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListenerServlet
 */
@WebServlet("/listener")
public class ListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListenerServlet() {
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
		PrintWriter out = response.getWriter();  
		
		ServletContext ctx=getServletContext();  
		
		out.println(ctx.getAttribute("greeting"));  
		
		String attributeName="name";
        String attributeValue="world";
        ctx.setAttribute(attributeName, attributeValue);
        attributeValue="vipul";
        ctx.setAttribute(attributeName, attributeValue);
        ctx.removeAttribute(attributeName);
	}
}
