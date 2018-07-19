<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user home</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="jumbotron text-center">
		<h2>PassBook</h2>
	</div>
	<div>
		<table class="table table-light table-striped table-hover">
			<thead class="thead">
				<tr>
					<th>ID</th>
					<th>Amount</th>
					<th>Type</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="transactions">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="amount" /></td>
						<td><s:property value="type" /></td>
						<td><s:property value="date" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>