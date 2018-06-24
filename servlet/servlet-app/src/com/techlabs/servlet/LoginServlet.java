package com.techlabs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = "vipul";
        String pwd = "123";
        
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        if(!(name.equals(userName) && pass.equals(pwd))) {
            response.sendRedirect("login.html");
        }
        
        PrintWriter out = response.getWriter();
        out.println("<html><p>name: "+name+"</p>");
        out.println("<p>password: "+pass+"</p></html>");

	}

}
