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
@WebServlet("/ActionRedirectServlet")
public class ActionRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Connection con = GetConnection.getCon();
		//Logic for approving customers
		if (request.getParameter("action").equals("approve")) {
			ArrayList<Integer> customers = new ArrayList<Integer>();
			try {
				Statement stmt = con.createStatement();
				String query = "SELECT customer_id FROM CUSTOMER c,ADMIN a WHERE c.branch = a.branch AND a.admin_id="
						+ "'"
						+ request.getSession().getAttribute("adminid")
						+ "'" + " AND c.is_approved='no'";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					customers.add(rs.getInt("customer_id"));
				}
				request.setAttribute("customerlist", customers);
				if (customers.isEmpty()) {
					message = "There are no customers that are pending for approval";
					request.setAttribute("message", message);
					request.getRequestDispatcher("index.jsp").forward(request,
							response);
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("approveusers.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//Logic for creating account for users
		else if (request.getParameter("action").equals("create")){
			ArrayList<Integer> activeCustomers = new ArrayList<Integer>();
			try {
				Statement stmt = con.createStatement();
				String query = "SELECT customer_id FROM CUSTOMER c,ADMIN a WHERE c.branch = a.branch AND a.admin_id="
						+ "'"
						+ request.getSession().getAttribute("adminid")
						+ "'" + " AND c.is_approved='yes'";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					activeCustomers.add(rs.getInt("customer_id"));
				}
				request.setAttribute("activeCustomerlist", activeCustomers);
				if (activeCustomers.isEmpty()) {
					message = "There are no customers that are active under this administrator";
					request.setAttribute("message", message);
					request.getRequestDispatcher("index.jsp").forward(request,response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("createAccount.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//Logic for approving loan accounts
				if (request.getParameter("action").equals("approveloan")) {
					ArrayList<Integer> customers = new ArrayList<Integer>();
					ArrayList<String> loantype = new ArrayList<String>();
					ArrayList<Double> loanamount = new ArrayList<Double>();
					ArrayList<Integer> loanacctnumber = new ArrayList<Integer>();
					try {
						Statement stmt = con.createStatement();
						String query = "SELECT c.customer_id,l.loan_type,l.loan_amount,l.loanaccount_number FROM CUSTOMER c,ADMIN a,LOAN l WHERE c.branch = a.branch AND a.admin_id="
								+ "'"
								+ request.getSession().getAttribute("adminid")
								+ "'" + " AND c.customer_id=l.customer_id AND l.loan_status='no'";
						ResultSet rs = stmt.executeQuery(query);
						while (rs.next()) {
							customers.add(rs.getInt(1));
							loantype.add(rs.getString(2));
							loanamount.add(rs.getDouble(3));
							loanacctnumber.add(rs.getInt(4));
						}
						request.setAttribute("loancustomerlist", customers);
						request.setAttribute("loantypelist", loantype);
						request.setAttribute("loanamountlist", loanamount);
						request.setAttribute("loanaccountnumberlist", loanacctnumber);
						if (customers.isEmpty()) {
							message = "There are no pending loan approvals";
							request.setAttribute("message", message);
							request.getRequestDispatcher("index.jsp").forward(request,
									response);
						} else {
							RequestDispatcher rd = request
									.getRequestDispatcher("approveloan.jsp");
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	}
}
