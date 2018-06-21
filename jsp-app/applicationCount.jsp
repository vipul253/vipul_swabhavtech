<!DOCTYPE html>
<html>
<head>
    <title>Application count</title>
</head>
<body>  
        <%
           Integer count = (Integer)application.getAttribute("count");
                if( count == null){
                    application.setAttribute("count",0);
                }

        %>
        <h2>old count = <%=application.getAttribute("count")%></h2>

        <%
            Integer i = (Integer)application.getAttribute("count");
            i=i+1;
            application.setAttribute("count",i);
        %>

        <h2>new count = <%=application.getAttribute("count")%></h2>
        <h3><a href="summary.jsp">Summary</a></h3>
</body>
</html>
