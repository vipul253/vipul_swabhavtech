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
	<div class="table-responsive">
		<table class="table table-dark table-hover table-striped table-sm">
			<thead class="thead-dark">
				<tr>
					<th>RollNo</th>
					<th>Name</th>
					<th>Email</th>
					<th>MobileNo</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="%{students.isEmpty()}">
   					no students, add students!!
				</s:if>
				<s:else>
					<s:iterator value="students">
						<tr>
							<td><s:property value="rollNo" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="email" /></td>
							<td><s:property value="mobileNo" /></td>
						</tr>
					</s:iterator>
				</s:else>
			</tbody>
		</table>
	</div>
	<div class="container">
		<a class="btn btn-primary" href="<s:url action="addStudent"/>">Add
			Student</a>
	</div>
</body>
</html>