<!DOCTYPE html>  
<html>
<head>
	<title>welcome</title>
</head>
<body>
	<h1>welcome</h1>
	<%
		String name = request.getParameter("name");
		if(name==null){
			name="jsp";
		}
	%>

	<h2>hello <%=name%></h2>

	<% for(int i=0;i<3;i++) {%>
	<h3>hello <%=name+" "+(i+1)%></h3>
	<%}
		String owner = application.getInitParameter("Ownername");
	%>
	<h2>name is <%=owner%></h2>
</body>
</html>