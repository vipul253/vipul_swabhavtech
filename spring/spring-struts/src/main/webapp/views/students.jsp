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
				</tr>
			</thead>
			<tbody>
					<s:iterator value="students">
						<tr>
							<td><s:property value="rollNo" /></td>
							<td><s:property value="firstName" /> <s:property value="lastName" /></td>
							<td><s:property value="address" /></td>
						</tr>
					</s:iterator>
			</tbody>
		</table>
		</div>
</body>
</html>