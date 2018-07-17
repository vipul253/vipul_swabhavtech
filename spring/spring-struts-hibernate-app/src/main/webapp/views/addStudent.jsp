<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<div class="jumbotron text-center">
		<h2>Add Student</h2>
	</div>
	<div class="col-sm-6 col-lg-4">
		<form action="addStudent">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm">First
						Name</span>
				</div>
				<input type="text" class="form-control" name="firstName" required />
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm">Last
						Name</span>
				</div>
				<input type="text" class="form-control" name="lastName" required />
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm">Address</span>
				</div>
				<input type="text" class="form-control" name="address" required />
			</div>
			<div>
				<input type="submit" value="Add" class="btn btn-info" />
			</div>
		</form>
	</div>
</body>
</html>