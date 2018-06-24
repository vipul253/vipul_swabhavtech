package com.techlabs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Summary
 */
@WebServlet("/summary")
public class Summary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Summary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ServletContext application=getServletContext();
		
		Integer count = (Integer)application.getAttribute("count");
        if( count == null){
            application.setAttribute("count",0);
        }
        
		if(session.isNew()){
            session.setAttribute("count",0);
        }
		
		out.println("<html><h2>Session count = "+session.getAttribute("count")+"</h2>");
		out.println("<h2>Application count = "+application.getAttribute("count")+"</h2></html>");
	}
}
