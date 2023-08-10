package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginUser extends HttpServlet {
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		jdbc.DBcode dbobj = new jdbc.DBcode();
		int n = dbobj.login(username, password);
		if(n==1)
		{
			jakarta.servlet.http.HttpSession mysess = request.getSession();
			mysess.setAttribute("username", username);			
			jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("Home");
			rd.forward(request, response);
		}
		else
		{
			java.io.PrintWriter pw = response.getWriter();
			pw.print("<p>Invalid login</p>");
			jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("newlogin.html");
			rd.include(request, response);
		}
	
	}

}
