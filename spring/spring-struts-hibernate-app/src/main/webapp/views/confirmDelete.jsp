<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
<jsp:include page="scripts.jsp" />
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="container">
		<form action='deleteStudent'>
			<h2>
				Delete entry for roll no.
				<s:property value="id" />
				?
			</h2>
			<input type="hidden" name="id" value="<s:property value="id" />" />
			<div>
				<input type="submit" value="yes" class="btn btn-primary" />
			</div>
		</form>
		<button onclick="location.href='students';" id="gotoHome"
			class="btn btn-info">
			no</i>
		</button>
	</div>
</body>
</html>