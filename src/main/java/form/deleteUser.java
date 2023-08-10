package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class deleteUser
 */
public class deleteUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jakarta.servlet.http.HttpSession mysess = request.getSession(false);
		String username=(String) mysess.getAttribute("username");
		String password = request.getParameter("password");
		jdbc.DBcode dbobj = new jdbc.DBcode();
		dbobj.deactivate(username, password);
		response.sendRedirect("LogoutUser");
	}

}
