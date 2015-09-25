

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApproveLoanServlet
 */
@WebServlet("/ApproveLoanServlet")
public class ApproveLoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message ="";
		String[] selected = request.getParameterValues("loanacctnum");
		StringBuilder acctnumbers = new StringBuilder();
		acctnumbers.append(selected[0]);
		for(int i=1;i<selected.length;i++){
			acctnumbers.append(",");
			acctnumbers.append(selected[i]);
		}
		Connection con = GetConnection.getCon();
		boolean status = false;
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE LOAN SET loan_status='yes' WHERE loanaccount_number IN ("+acctnumbers.toString()+")");
			int i = ps.executeUpdate();
			if(i != 0){
				message = "Loans are approved successfully";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else{
				message = "Loans are not approved! Please try again";
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
