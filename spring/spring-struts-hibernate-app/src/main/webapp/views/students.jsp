<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<div class="container table-responsive">
		<table class="table table-hover table-striped">
			<thead class="thead-dark">
				<tr>
					<th>RollNo</th>
					<th>Name</th>
					<th>Address</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="students">
					<tr>
						<td><s:property value="rollNo" /></td>
						<td><s:property value="firstName" /> <s:property
								value="lastName" /></td>
						<td><s:property value="address" /></td>
						<td><button
								onclick="location.href='edit?id=<s:property value="rollNo"/>';"
								name="id" class="btn btn-info">
								<i class="fa fa-edit"></i>
							</button></td>
							<td><button
								onclick="location.href='delete?id=<s:property value="rollNo"/>';"
								name="id" class="btn btn-danger">
								<i class="fa fa-trash"></i>
							</button></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="container">
		<a class="btn btn-primary" href='add'> Add Student</a>
	</div>
</body>
</html>