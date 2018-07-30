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
	<div>
		<s:if test="%{recipients.size()<=0}">
			<p class="text-center">no recipients!</p>
		</s:if>
		<s:else>
			<table class="table table-light table-striped table-hover">
				<thead class="thead">
					<tr>
						<th>ID</th>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="recipients">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="recipientName" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:else>
	</div>
</body>
</html>