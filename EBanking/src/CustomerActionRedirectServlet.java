import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PendingUsersServlet
 */
@WebServlet("/CustomerActionRedirectServlet")
public class CustomerActionRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Connection con = GetConnection.getCon();
		int status;
		PreparedStatement ps;
		//Logic for applying loan
		if (request.getParameter("action").equals("applyloan")) {
			request.getRequestDispatcher("loanapply.jsp").forward(request, response);
		}
		//Logic for fetching details of customer
		else if (request.getParameter("action").equals("details")){
			ArrayList<Integer> customerid = new ArrayList<Integer>();
			ArrayList<String> firstname = new ArrayList<String>();
			ArrayList<String> lastname = new ArrayList<String>();
			ArrayList<String> address = new ArrayList<String>();
			ArrayList<String> phone = new ArrayList<String>();
			ArrayList<String> branch = new ArrayList<String>();
			ArrayList<Integer> loanacctnumber = new ArrayList<Integer>();
			ArrayList<String> loantype = new ArrayList<String>();
			ArrayList<Double> loanamount = new ArrayList<Double>();
			ArrayList<String> loanstatus = new ArrayList<String>();
			try {
				Statement stmt = con.createStatement();
				String query = "SELECT c.customer_id,c.firstname,c.lastname,c.address,c.phone,c.branch,l.loanaccount_number,l.loan_type,l.loan_amount,l.loan_status FROM CUSTOMER c,LOAN l WHERE c.customer_id="
						+ "'"
						+ request.getSession().getAttribute("customerid")
						+ "'" + " AND c.customer_id=l.customer_id";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					customerid.add(rs.getInt(1));
					firstname.add(rs.getString(2));
					lastname.add(rs.getString(3));
					address.add(rs.getString(4));
					phone.add(rs.getString(5));
					branch.add(rs.getString(6));
					loanacctnumber.add(rs.getInt(7));
					loantype.add(rs.getString(8));
					loanamount.add(rs.getDouble(9));
					loanstatus.add(rs.getString(10));
				}
				request.setAttribute("custid", customerid);
				request.setAttribute("firstname", firstname);
				request.setAttribute("lastname", lastname);
				request.setAttribute("address", address);
				request.setAttribute("phone", phone);
				request.setAttribute("branch", branch);
				request.setAttribute("loanacctnumber", loanacctnumber);
				request.setAttribute("loantype", loantype);
				request.setAttribute("loanamount", loanamount);
				request.setAttribute("loanstatus", loanstatus);
				if (customerid.isEmpty()) {
					message = "You do not have loan account details that can be displayed";
					request.setAttribute("message", message);
					request.getRequestDispatcher("customerindex.jsp").forward(request,
							response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("customerdetails.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
