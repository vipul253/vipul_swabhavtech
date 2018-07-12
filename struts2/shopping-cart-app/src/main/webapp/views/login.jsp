<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="jumbotron text-center">
		<h2>Login</h2>
	</div>
	<div class="col-sm-6 col-lg-4">
		<form action="doLogin">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm">Username</span>
				</div>
				<input type="text" class="form-control" name="username" required>
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm">Password</span>
				</div>
				<input type="password" class="form-control" name="pwd" required>
			</div>
			<s:if test="fieldErrors.get('loginError').size() > 0">
				<div class="alert alert-danger alert-dismissible"
					style="display:<s:property value="disp"/>">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>alert! </strong>
					<s:property value="fieldErrors.get('loginError').get(0)" />
				</div>
			</s:if>
			<div>
				<input type="submit" value="Login" class="btn btn-primary" />
			</div>
		</form>
	</div>
</body>
</html>