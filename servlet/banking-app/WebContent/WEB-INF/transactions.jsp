<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.techlabs.sample.bank.model.Transaction;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div>
		<table class="table table-light table-striped table-hover">
			<tr>
				<th>Name</th>
				<th>Amount</th>
				<th>Type</th>
				<th>Date</th>
			</tr>
			<%
				List<Transaction> transactions = (List) request.getAttribute("transactionList");
				if (transactions.isEmpty()) {
			%>
			<tr>
				<td>No transactions yet!</td>
			</tr>
			<%
				} else {
					for (Transaction t : transactions) {
			%>
			<tr>
				<td><%=t.getName()%></td>
				<td><%=t.getAmount()%></td>
				<td><%=t.getType()%></td>
				<td><%=t.getDate()%></td>
			</tr>
			<%
					}
				}
			%>
		</table>
	</div>
</body>
</html>