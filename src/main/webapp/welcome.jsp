<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <%
    
    if(session.getAttribute("email")== null)
    {
    	response.sendRedirect("login_res.html");
    }
    %>
    <h1>SUCCESSFULLY LOGGED IN, WELCOME TO OUR RAS</h1>
</body>
</html>