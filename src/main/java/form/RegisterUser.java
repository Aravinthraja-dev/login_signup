package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		long mobile =Long.parseLong(request.getParameter("mobile"));
		String password = request.getParameter("password");
		jdbc.User uobj = new jdbc.User(name, username, email, mobile, password);
		jdbc.DBcode dbobj = new jdbc.DBcode();
		dbobj.newuser(uobj);
		response.sendRedirect("newlogin.html");	
	}

}
