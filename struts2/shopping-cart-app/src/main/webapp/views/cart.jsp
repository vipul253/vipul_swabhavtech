<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoppping Cart</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<div>
		<form action="add">
			<div class="row mt-4">
				<div class="col">
					<select name="selected" class="form-control bg-warning">
						<s:iterator value="products">
							<option value="<s:property value="cost"/>"><s:property
									value="name" /> Rs.
								<s:property value="cost" /></option>
						</s:iterator>
					</select>
				</div>
				<div class="col input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-default">Quantity</span>
					</div>
					<input type="number" name="quantity" class="form-control">
				</div>
				<div class="col">
					<input type="submit" value="Add to cart" class="btn btn-primary" />
				</div>
			</div>
		</form>
	</div>
	<div></div>
</body>
</html>