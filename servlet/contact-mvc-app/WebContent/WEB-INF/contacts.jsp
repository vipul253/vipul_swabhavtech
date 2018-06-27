<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.techlabs.contactService.model.Contact"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts list</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div>
		<table class="table table-dark table-striped table-hover">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Number</th>
				<th>Edit</th>
			</tr>
			<%
				List<Contact> contacts = (List) request.getAttribute("contactList");
				for (Contact c : contacts) {
			%>
			<tr>
				<td><%=c.getName()%></td>
				<td><%=c.getEmail()%></td>
				<td><%=c.getNumber()%></td>
				<td><button
						onclick="location.href='editContact?id=<%=c.getId()%>'" name="id"
						class="btn btn-info">
						<i class="fa fa-edit"></i>
					</button></td>
				<%
					}
				%>
			
		</table>
	</div>
</body>
</html>