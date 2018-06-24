<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.techlabs.contact.Contact"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts list</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: lightblue;
    color: white;
}
</style>
</head>
<body>
	<div>
		<table>
		<thead>
			<th>Name</th>
			<th>Email</th>
			<th>Number</th>
		</thead>
			<%
				List<Contact> contacts = (List) request.getAttribute("contactList");
				for (Contact c : contacts) {
			%>
			<tr>
				<td><%=c.getName()%></td>
				<td><%=c.getEmail()%></td>
				<td><%=c.getNumber()%></td>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>