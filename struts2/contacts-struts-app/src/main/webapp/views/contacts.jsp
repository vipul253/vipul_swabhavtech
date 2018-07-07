<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
	<div class="table-responsive">
		<table class="table table-dark table-hover table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Number</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="%{false}">
					<tr>
						<td colspan="3">Empty</td>
					</tr>
				</s:if>
				<s:else>
					<s:iterator value="contacts">
						<tr>
							<td><s:property value="name" /></td>
							<td><s:property value="email" /></td>
							<td><s:property value="number" /></td>
							<td><button
									onclick="location.href='edit?id=<s:property value="Id"/>';"
									name="id" class="btn btn-info">
									<i class="fa fa-edit"></i>
								</button></td>
						</tr>
					</s:iterator>
				</s:else>
			</tbody>
		</table>
	</div>
</body>
</html>