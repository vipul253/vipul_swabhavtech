<!DOCTYPE html>
<html>
<head>
    <title>session count</title>
</head>
<body>  
        <%
            if(session.isNew()){
                session.setAttribute("count",0);
            }
        %>
        <h2>old count = <%=session.getAttribute("count")%></h2>

        <%
            Integer i = (Integer)session.getAttribute("count");
            i=i+1;
            session.setAttribute("count",i);
        %>

        <h2>new count = <%=session.getAttribute("count")%></h2>
        <h3>Session ID = <%=session.getId()%><br>

        <h3><a href="summary.jsp">Summary</a></h3>

</body>
</html>
