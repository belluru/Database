

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
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
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
					ps = con.prepareStatement("Insert into ACCOUNT values(?,?,?,?,?)");
					int	account_number=GetConnection.getAccountNumber();
					//Setting the values of all the columns for CUSTOMER table.
					ps.setInt(1,account_number);
					ps.setString(2,request.getParameter("acctype"));
					ps.setString(3,request.getParameter("acctbalance"));
					ps.setString(4,request.getSession().getAttribute("branch").toString());
					ps.setString(5,request.getParameter("customerid"));
					status=ps.executeUpdate();
					if(status != 0){
						message = "Account Created Successfully";
						request.setAttribute("message", message);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					else{
						message = "Account creation was Unsuccessful! Please try again";
						request.setAttribute("message", message);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

}
