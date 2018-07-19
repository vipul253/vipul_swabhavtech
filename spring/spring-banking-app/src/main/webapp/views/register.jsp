<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<jsp:include page="scripts.jsp" />
<script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="jumbotron text-center">
		<h2>Register</h2>
	</div>
	<div class="container">
		<div class="col-sm-8 col-md-6">
			<form action="makeAccount" method="POST">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-sm">Username</span>
					</div>
					<input type="text" class="form-control" name="name" required />
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-sm">Password</span>
					</div>
					<input type="password" class="form-control" id="pwd1" name="pwd"
						required />
				</div>
				<div class="form-group">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Renter
								Password</span>
						</div>
						<input type="password" class="form-control" id="pwd2"
							name="password" required />
					</div>
					<small><strong id="matching"></strong></small>
				</div>
				<div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Amount</span>
						</div>
						<input type="number" class="form-control" id="amount"
							name="amount" required />
					</div>
				</div>
				<div class="g-recaptcha"
					data-sitekey="6LctBWUUAAAAAJCcGhTk8rpTeFGgxtl2S6DrEwsN">
				</div>
				<s:if test="fieldErrors.get('captchaError').size() > 0">
					<div class="alert alert-danger alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>alert! </strong>
						<s:property value="fieldErrors.get('captchaError').get(0)" />
					</div>
				</s:if>
				<s:if test="fieldErrors.get('amountError').size() > 0">
					<div class="alert alert-danger alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>alert! </strong>
						<s:property value="fieldErrors.get('amountError').get(0)" />
					</div>
				</s:if>
				<div class="">
					<input type="submit" id="submitbtn" value="Register"
						class="btn btn-primary" />
				</div>
			</form>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#pwd2').on('keyup',function() {
				if ($('#pwd1').val() == $('#pwd2').val()) {
					$('#matching').html("matching").css(
							'color', '#0df00d');
					$('#submitbtn').prop("disabled", false);
				} else {
					$('#matching').html("not matching").css(
							'color', '#ff3a00');
					$('#submitbtn').prop("disabled", true);
				}
			});
		});
	</script>
</body>
</html>