<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beer Advice Result</title>
</head>
<body>
<h1 align="center">Beer Recommendations JSP</h1>
<%
	List<String> styles = (List)request.getAttribute("styles");
	Iterator<String> it = styles.iterator();
	while(it.hasNext()) {
		out.println("<br>try: "+it.next());
	}
%>
	
</body>
</html>