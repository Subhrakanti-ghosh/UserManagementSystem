package com.subhra.crud.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionHolder {
	
	public static boolean isAuthenticated(HttpServletRequest request)
	{
		HttpSession s = request.getSession();
		if(s.getAttribute("email") != null)
		{
			return true;
		}
		return false;
	}
	
	public static void checkAuthenticationAndRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		if(isAuthenticated(request))
		{
			response.sendRedirect("/LoginPage.html");
		}
	}

}
