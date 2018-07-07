<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<jsp:include page="scripts.jsp" />
<style>
.tdErrorMessage {
	text-align: center;
}

.errorMessage {
	color: red;
}
</style>
</head>
<body>
	<div class="container mt-4">
		<s:form action="add">
			<s:textfield class="form-control" label="RollNo"
				name="student.rollNo" size="40" />
			<s:textfield class="form-control" label="Name" name="student.name"
				size="40" />
			<s:textfield class="form-control" label="Email" name="student.email"
				size="40" />
			<s:textfield class="form-control" label="mobileNo"
				name="student.mobileNo" size="40" />
			<s:submit value="Add" class="btn btn-info" />
		</s:form>
	</div>
</body>
</html>