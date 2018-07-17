<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<table class="table table table-hover table-striped">
			<thead class="thead">
				<tr>
					<th>Name</th>
					<th>Cost</th>
					<th>Quantity</th>
					<th>TotalCost</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#session.lineItems">
					<tr>
						<td><s:property value="product.name" /></td>
						<td><s:property value="product.cost" /></td>
						<td><s:property value="quantity" /></td>
						<td><s:property value="CalculateTotalCost()" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<div class="">
			<div>
				<p id="checkoutCost" name="checkoutCost" class="mb-3 form-control">
					Final Cost:
					<s:property value="checkoutCost" />
				</p>
			</div>
			<a href="doCheckout" class="btn btn-primary"> <i
				class="fa fa-shopping-cart"> confirm order</i>
			</a>
		</div>

	</div>
</body>
</html>