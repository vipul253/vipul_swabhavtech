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
	<div class="col-sm-6 col-lg-4">
		<form action="makeSavingsAccount" method="POST">
			
			<div class="input-group mt-4 mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm">Initial Deposit Amount</span>
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
