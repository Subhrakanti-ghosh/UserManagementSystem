

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!isAthenticated(request))
    	{
    		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginPage.html");
            dispatcher.forward(request, response);*/
			System.out.println("Sending Login page");
            //response.sendRedirect(request.getRequestURI().replace(request.getServletPath(),"")+"/LoginPage.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginPage.jsp");
			dispatcher.forward(request, response);
    	}
		else {
			response.sendRedirect("user-list.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Logindao dao = new Logindao();
		if(dao.check(email, password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect(request.getRequestURI().replace(request.getServletPath(),"")+"/user/list");
		}
		else
		{
			response.sendRedirect("RegistrationPage.jsp");
		}
		
	}
	
	 private boolean isAthenticated(HttpServletRequest request) {
	    	HttpSession session = request.getSession();
	    	String email = "";
	    	if(session != null && session.getAttribute("email") != null)
	    	{
	    		email = session.getAttribute("email").toString(); 
	    	}
	    	
	    	if(!email.isEmpty() && !email.isBlank())
	    	{
	    		return true;
	    	}
	    	return false;
	    }

}
