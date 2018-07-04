<%@page import="com.techlabs.contact.service.model.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Contact</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%
	String uid = request.getParameter("id");
%>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div>
		<div class="jumbotron text-center">
			<h1>Edit Contact</h1>
		</div>
		<div class="col-sm-6 col-lg-4">
			<form action="editContact" method="POST">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-sm">Name</span>
					</div>
					<input type="text" class="form-control" name="name"
						value="<%=request.getAttribute("name")%>" required>
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-sm">Email</span>
					</div>
					<input type="email" class="form-control" name="email"
						value="<%=request.getAttribute("email")%>" required>
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-sm">Number</span>
					</div>
					<input type="text" class="form-control" name="number"
						value="<%=request.getAttribute("number")%>" required>
				</div>
				<input type="hidden" value="<%=uid%>" name="id">
				<div>
					<input type="submit" value="Edit" class="btn btn-info" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>