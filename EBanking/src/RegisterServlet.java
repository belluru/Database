/**
 * Author : Bharath Chandra Elluru

 * Date : 04/16/2015
 * This servlet is used to register a new user to the online banking facility.
 * A new user enters his/her details on registration page, which are inserted
 * into database with the aid of this servlet.
 */


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Getting database connection
		String message ="";
		Connection con=GetConnection.getCon();
		int status;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("Insert into CUSTOMER values(?,?,?,?,?,?,?,?,?,?,?)");
			int	customer_id=GetConnection.getPrimaryKey();
			//Setting the values of all the columns for CUSTOMER table.
			ps.setInt(1,customer_id);
			ps.setString(2,request.getParameter("userName"));
			ps.setString(3,request.getParameter("password"));
			ps.setString(4,request.getParameter("fName"));
			ps.setString(5,request.getParameter("lName"));
			ps.setString(6,request.getParameter("age"));
			ps.setString(7,request.getParameter("gender"));
			ps.setString(8,request.getParameter("adderess"));
			ps.setString(9,request.getParameter("phone"));
			ps.setString(10,request.getParameter("accbranch"));
			ps.setString(11,"no");
			status=ps.executeUpdate();
			if(status != 0){
				message = "User Registered Successfully. Pending for approval";
				request.setAttribute("message", message);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			else{
				message = "Registration Unsuccessful! Please try again";
				request.setAttribute("message", message);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
