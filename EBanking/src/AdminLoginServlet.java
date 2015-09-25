/**
 * Author : Bharath Chandra Elluru


 * Date : 04/16/2015
 * This servlet is used to validate credentials of an administrator
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Servlet used to authorize the user based on username and password entered", urlPatterns = { "/AdminLoginServlet" })
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String errorMessage = "Invalid Credentials. Please try again";
		Connection con = GetConnection.getCon();
		boolean status = false;
		try {
			PreparedStatement ps = con.prepareStatement("Select branch from ADMIN where admin_id = ? and password =?");
			ps.setString(1, request.getParameter("aid"));
			ps.setString(2, request.getParameter("pwd"));
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if(!status){
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
			}
			else{
				request.getSession().setAttribute("branch", rs.getString("branch"));
				request.getSession().setAttribute("adminid", request.getParameter("aid"));
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
