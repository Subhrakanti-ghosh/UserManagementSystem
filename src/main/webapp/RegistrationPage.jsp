
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--<title> Registration or Sign Up form in HTML CSS | CodingLab </title>-->
    <link rel="stylesheet" href="web.css">
   </head>
   <%
			HttpSession loginsession = request.getSession();	
	    	String email = "";
	    	if(loginsession != null && loginsession.getAttribute("email") != null)
	    	{
	    		email = loginsession.getAttribute("email").toString(); 
	    	}
	    	
	    	if(email != null && email.isEmpty() && email.isBlank())
	    	{
	    		//response.sendRedirect(request.getRequestURI().replace(request.getServletPath(),"")+"/LoginPage.jsp");
	    	}
			else {
				response.sendRedirect(request.getRequestURI().replace(request.getServletPath(),"")+"/user/list");
	    	}
		%>
<body>
  <div class="wrapper">
    <h2>Registration</h2>
    <form action="Registration" method="post">
      <div class="input-box">
        <input type="text" name="yname" placeholder="Enter your name" required>
      </div>
      <div class="input-box">
        <input type="text" name="email" placeholder="Enter your email" required>
      </div>
      <div class="input-box">
        <input type="password" name="password" placeholder="Create password" required>
      </div>
      <div class="input-box">
        <input type="password" name="rpassword" placeholder="Confirm password" required>
      </div>
      <div class="policy">
        <input type="checkbox">
        <h3>I accept all terms & condition</h3>
      </div>
      <div class="input-box button">
        <input type="Submit" value="Register Now">
      </div>
      <div class="text">
        <h3>Already have an account? <a href="LoginPage.jsp">Login now</a></h3>
      </div>
    </form>
  </div>
</body>
</html>
