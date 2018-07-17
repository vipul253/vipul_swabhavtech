package com.techlabs.sample.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.sample.bank.model.Transaction;
import com.techlabs.sample.bank.model.TransactionService;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/displayTransactions")
public class DisplayTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionService transactionTool;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayTransactionController() {
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
		
		List<Transaction> transactions = transactionTool.getTransactions(name);

		request.setAttribute("transactionList", transactions);
		RequestDispatcher view = request
				.getRequestDispatcher("transactions.jsp");
		view.forward(request, response);
	}
}
