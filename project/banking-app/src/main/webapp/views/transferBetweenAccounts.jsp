<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="jumbotron text-center">
		<h2>Transaction</h2>
	</div>
	<div class="col-sm-6 col-lg-4">
		<form action="transfer" method="POST">
			<div>
			<label class="form-label" for="type"> Transfer to: </label>
				<div class="form-check-inline">
					<input class="form-check-input" type="radio" name="accountType"
						id="current" value="CURRENT" checked> <label
						class="form-check-label" for="current"> Current </label>
				</div>
				<div class="form-check-inline">
					<input class="form-check-input" type="radio" name="accountType"
						id="savings" value="SAVINGS" required> <label
						class="form-check-label" for="savings"> Savings </label>
				</div>
			</div>
			<div class="input-group mt-4 mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm">Amount</span>
				</div>
				<input type="number" class="form-control" name="amount" required />
			</div>
			<s:if test="fieldErrors.get('balanceError').size() > 0">
				<div class="alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>alert! </strong>
					<s:property value="fieldErrors.get('balanceError').get(0)" />
				</div>
			</s:if>
			<div>
				<input type="submit" value="submit" class="btn btn-primary" />
			</div>
		</form>
	</div>
</body>
</html>