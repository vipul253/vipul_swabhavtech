<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Transactions</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container mb-3">
		<a href="transactions" class="inline btn btn-primary">All transactions</a>
		<a href="showSavingsTransactions" class="inline btn btn-primary">Savings Account Transactions</a>
		<a href="showCurrentTransactions" class="inline btn btn-primary">Current Account Transactions</a>
		<a href="makeTransaction" class="inline btn btn-primary">Make Transaction</a>
		<a href="transferTo" class="inline btn btn-primary">Transfer Between Accounts</a>
	</div>
	<div>
		<s:if test="%{transactions.size()<=0}">
			<p class="text-center">no transactions!</p>
		</s:if>
		<s:else>
			<table class="table table-light table-striped table-hover">
				<thead class="thead">
					<tr>
						<th>ID</th>
						<th>Account</th>
						<th>Amount</th>
						<th>Type</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="transactions">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="getAcc().getAccountType()" /></td>
							<td><s:property value="amount" /></td>
							<td><s:property value="transactionType" /></td>
							<td><s:property value="date" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:else>
	</div>
</body>
</html>