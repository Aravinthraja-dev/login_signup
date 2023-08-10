package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.User;

import java.io.IOException;

public class Home extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jakarta.servlet.http.HttpSession mysess = request.getSession(false);
		if(mysess==null)
		{
			response.sendRedirect("newlogin.html");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jakarta.servlet.http.HttpSession mysess = request.getSession(false);
		if(mysess==null)
		{
			response.sendRedirect("newlogin.html");
		}
		java.io.PrintWriter pw = response.getWriter();
		String username = (String) mysess.getAttribute("username");
		pw.print("<h1>Home page</h1>");
		pw.print("<h1>Welcome "+username+"</h1>");
		pw.print("<a href='delete.html'>Delete Account</a>");
		pw.print("<a href='ChangePassword.html'>Change Password</a>");
		pw.print("<a href='LogoutUser'>Logout</a>");
		pw.print("<hr>");
		pw.print("<h1>My Profile</h1>");
		jdbc.DBcode dbobj = new jdbc.DBcode();
		User u = dbobj.getcurrentuserdata(username);
		pw.print("<p>"+u.getName()+"</p>");
	}

}
