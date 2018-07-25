<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Accounts</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<s:if test="%{currentAccount==null}">
			<a href="currentAccountForm" class="btn">Make current Account</a>
		</s:if>
		<s:else>
			<table class="table table-light table-striped table-hover">
				<thead class="thead">
				<tr><th class="text-center"colspan="3">Current Account</th></tr>
					<tr>
						<th>ID</th>
						<th>Balance</th>
						<th>Type</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="currentAccount">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="balance" /></td>
							<td><s:property value="accountType" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:else>
	</div>
	<div class="container">
		<s:if test="%{savingsAccount==null}">
			<a href="savingsAccountForm" class="btn">Make Savings Account</a>
		</s:if>
		<s:else>
			<table class="table table-light table-striped table-hover">
				<thead class="thead">
					<tr><th class="text-center"colspan="3">Savings Account</th></tr>
					<tr>
						<th>ID</th>
						<th>Balance</th>
						<th>Type</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="savingsAccount">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="balance" /></td>
							<td><s:property value="accountType" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:else>
	</div>
</body>
</html>