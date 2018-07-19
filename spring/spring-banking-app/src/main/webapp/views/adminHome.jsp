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
	<div class="table-responsive">
		<table class="table table-light table-striped table-hover">
			<thead class="thead">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Balance</th>
					<th>Last Login</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="users">
					<tr>
						<td><s:property value="id" /></td>
						<td><a href="showTransactions?name=<s:property value='name'/>">
						<s:property value="name" /></a></td>
						<td><s:property value="acc.getBalance()" /></td>
						<td><s:property value="lastLogin"/></td>
						<td><a class="btn btn-primary"
							href="changeAccountState?id=<s:property value='id'/>"><s:property
									value="status" /></a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>