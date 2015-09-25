

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApproveUsersServlet
 */
@WebServlet("/ApproveUsersServlet")
public class ApproveUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message ="";
		String[] selected = request.getParameterValues("customerid");
		StringBuilder customerids = new StringBuilder();
		customerids.append(selected[0]);
		for(int i=1;i<selected.length;i++){
			customerids.append(",");
			customerids.append(selected[i]);
		}
		Connection con = GetConnection.getCon();
		boolean status = false;
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE CUSTOMER SET is_approved='yes' WHERE customer_id IN ("+customerids.toString()+")");
			int i = ps.executeUpdate();
			if(i != 0){
				message = "Customers are approved successfully";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else{
				message = "Customers are not approved! Please try again";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
