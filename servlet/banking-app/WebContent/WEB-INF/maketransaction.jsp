<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Do Transaction</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<%
		String error = "";
		String disp = "none";
		if (request.getAttribute("errorMsg") != null) {
			disp = "block";
			error = (String) request.getAttribute("errorMsg");
		}
	%>
	<jsp:include page="header.jsp" />
	<div class="jumbotron text-center">
		<h2>Transaction</h2>
	</div>
	<div class="col-sm-6 col-lg-4">
		<form action="makeTransaction" method="POST">
			<div class="form-check">
				<input class="form-check-input" type="radio" name="type"
					id="withdraw" value="W" checked> <label
					class="form-check-label" for="withdraw"> Withdraw </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="type"
					id="deposit" value="D" required> <label
					class="form-check-label" for="deposit"> Deposit </label>
			</div>
			<div class="input-group mt-4 mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm">Amount</span>
				</div>
				<input type="number" class="form-control" name="amount" required>
			</div>
			<div class="alert alert-danger alert-dismissible"
				style="display:<%=disp%>">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>alert! </strong><%=error%>
			</div>
			<div>
				<input type="submit" value="submit" class="btn btn-primary" />
			</div>
		</form>
	</div>
</body>
</html>