<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <title>Login Form</title> -->
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
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
    <div class="container">
      <div class="wrapper">
        <div class="title"><span>Login Form</span></div>
        <form action="Login" method="post">
          <div class="row">
            <i class="fas fa-user"></i>
            <input type="text" name="email" placeholder="Email or Phone" required>
          </div>
          <div class="row">
            <i class="fas fa-lock"></i>
            <input type="password" name="password" placeholder="Password" required>
          </div>
          <div class="pass"><a href="#">Forgot password?</a></div>
          <div class="row button">
            <input type="submit" value="Login">
          </div>
          <div class="signup-link">Not a member? <a href="RegistrationPage.jsp">Signup now</a></div>
        </form>
      </div>
    </div>

  </body>
</html>
