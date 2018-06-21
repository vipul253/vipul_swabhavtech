<!DOCTYPE html>
<html>
<head>
    <title>Summary</title>
</head>
<body>  
        <%
            Integer count = (Integer)application.getAttribute("count");
            if( count == null){
                application.setAttribute("count",0);
            }
            
            if(session.isNew()) {
                session.setAttribute("count",0);
            }
        %>

        <div>
            <h2>Session count = <%=session.getAttribute("count")%></h2>
        </div>

        <div>
            <h2>Application count = <%=application.getAttribute("count")%></h2>
        </div>
</body>
</html>
