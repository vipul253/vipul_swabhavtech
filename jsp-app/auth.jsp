<!DOCTYPE html>
<html>
<head>
    <title>auth reponse</title>
</head>
<body>
        <%

        String userName = "vipul";
        String pwd = "123";
        
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        if(!(name.equals(userName) && pass.equals(pwd))) {
            response.sendRedirect("login.html");
        }
        
        out.println("<p>name: "+name+"</p>");
        out.println("<p>password: "+pass+"</p>");

        session.setAttribute("sessionUser",name);
        %>
        <a href="afterauth.jsp">next jsp page</a>
</body>
</html>
