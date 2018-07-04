package com.techlabs.sample.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.sample.bank.model.TransactionService;

/**
 * Servlet implementation class makeCSV
 */
@WebServlet("/makeCSV")
public class makeCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionService transactionTool;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public makeCSV() {
		super();
		transactionTool = new TransactionService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = (String) request.getSession().getAttribute("name");
		response.setContentType("application/csv");
		PrintWriter out = response.getWriter();
		out.println(transactionTool.getCSV(name));

		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
