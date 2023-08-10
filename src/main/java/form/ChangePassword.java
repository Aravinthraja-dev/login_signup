package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePassword extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String oldpassword = request.getParameter("opassword");
		String newpassword = request.getParameter("npassword");
		jdbc.DBcode dbobj = new jdbc.DBcode();
		int n=dbobj.changepassword(oldpassword,newpassword,username);
		if(n==1)
		{
			response.sendRedirect("newlogin.html");
		}
		else
		{
			java.io.PrintWriter pw = response.getWriter();
			pw.print("<p>Invalid Credentials</p>");
			jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("newlogin.html");
			rd.include(request, response);
		}
	}

}
