

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
 * Servlet implementation class CreateLoanAccountServlet
 */
@WebServlet("/CreateLoanAccountServlet")
public class CreateLoanAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Connection con = GetConnection.getCon();
		int status;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("Insert into LOAN values(?,?,?,?,?)");
			int	loanaccount_number=GetConnection.getLoanAccountNumber();
			//Setting the values of all the columns for CUSTOMER table.
			ps.setInt(1,loanaccount_number);
			ps.setString(2,request.getParameter("loantype"));
			ps.setString(3,request.getParameter("loanamount"));
			ps.setString(4,"no");
			ps.setInt(5,Integer.parseInt(request.getSession().getAttribute("customerid").toString()));
			
			status=ps.executeUpdate();
			if(status != 0){
				message = "Applied for loan successfully ! Pending for administrator approval";
				request.setAttribute("message", message);
				request.getRequestDispatcher("customerindex.jsp").forward(request, response);
			}
			else{
				message = "Application was unsuccessful! Please try again";
				request.setAttribute("message", message);
				request.getRequestDispatcher("customerindex.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
