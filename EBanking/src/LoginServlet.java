
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
@WebServlet(description = "Servlet used to authorize the user based on username and password entered in index.html", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
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
			// PreparedStatement
			// ps=con.prepareStatement("Select * from MAILCASTINGUSER where EMAILADD = ? and PASSWORD =?");
			PreparedStatement ps = con.prepareStatement("Select customer_id,branch from CUSTOMER where username = ? and password =? and is_approved='yes'");
			ps.setString(1, request.getParameter("uName"));
			ps.setString(2, request.getParameter("pwd"));
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if(!status){
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else{
				request.getSession().setAttribute("customerid", rs.getString("customer_id"));
				request.getSession().setAttribute("customerbranch", rs.getString("branch"));
				request.getSession().setAttribute("userName", request.getParameter("uName"));
				response.sendRedirect("customerindex.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
