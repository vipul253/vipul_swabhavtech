<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoppping Cart</title>
<jsp:include page="scripts.jsp" />
<style type="text/css">
.input-group-text {
	background-color: #00c4ff;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#productList').on('change', function() {
			var formInput = $('#itemForm').serialize();
			$.getJSON('getTotalCost', formInput, function(data) {
				$('#totalCost').val(data);
			});
		});

		$('#quantity').on('change keyup', function() {
			var formInput = $('#itemForm').serialize();
			$.getJSON('getTotalCost', formInput, function(data) {
				$('#totalCost').val(data);
			});
		});

	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container col-md-12 mb-3 mt-3">
		<form action="addLineItem" id="itemForm">
			<div class="form-row">
				<div class="col-sm-2 input-group">
					<s:select list="products" listKey="ID" listValue="name"
						name="selected" headerKey="-1" headerValue="Select a product"
						id="productList" class="form-control" />
				</div>
				<div class="col-sm-3 input-group">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-default">Quantity</span>
					</div>
					<input type="number" id="quantity" name="quantity" min="0"
						value="<s:property value="quantity"/>" class="form-control" />
				</div>
				<div class="col-sm-4 input-group">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-default">Price</span>
					</div>
					<input type="text" id="totalCost" name="totalCost" readonly
						class="form-control" value="<s:property value="totalCost"/>" />
				</div>
				<input type="hidden" name="productID"
					value="<s:property value="ID" />" />
				<div class="col-sm-3 input-group">
					<input type="submit" value="Add to cart" class="btn btn-default" />
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col-sm-2">
				<s:if test="fieldErrors.get('notSelected').size() > 0">
					<small class="form-text text-danger"><s:property
							value="fieldErrors.get('notSelected').get(0)" /></small>
				</s:if>
			</div>
			<div class="col-sm-3">
				<s:if test="fieldErrors.get('quantity').size() > 0">
					<small class="form-text text-danger"><s:property
							value="fieldErrors.get('quantity').get(0)" /></small>
				</s:if>
			</div>
			<div class="col-sm-4"></div>
			<div class="col-sm-3"></div>
		</div>
	</div>

	<div class="">
		<s:if test="%{lineItems.isEmpty()}">
			<p class="text-center">nothing in cart!</p>
		</s:if>
		<s:else>
			<table class="table table table-hover table-striped">
				<thead class="thead">
					<tr>
						<th>Name</th>
						<th>Cost</th>
						<th>Quantity</th>
						<th>TotalCost</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="lineItems">
						<tr>
							<td><s:property value="product.name" /></td>
							<td><s:property value="product.cost" /></td>
							<td><s:property value="quantity" /></td>
							<td><s:property value="CalculateTotalCost()" /></td>
							<td><button
									onclick="location.href='removeLineItem?id=<s:property value="product.ID"/>';"
									class="btn btn-danger">
									<i class="fa fa-close"></i>
								</button></td>
						</tr>
					</s:iterator>

				</tbody>
			</table>
			<div class="container">
				<button onclick="location.href='checkout';" class="btn btn-default">
					checkout <i class="fa fa-shopping-cart"></i>
				</button>
			</div>
		</s:else>
	</div>
</body>
</html>