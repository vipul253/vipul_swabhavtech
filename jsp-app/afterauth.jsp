<!DOCTYPE html>
<html>  
<body>  
<%   
    String name=(String)session.getAttribute("sessionUser");
    out.print("Hello "+name);   
%>  
</body>  
</html>