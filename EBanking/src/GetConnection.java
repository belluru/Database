
import java.sql.*;

public class GetConnection {
	private GetConnection() {
	}

	public static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/belluru?"
					+ "user=root&password=asdf");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("Exception in GetCon");
		}

	}

	public static Connection getCon() {
		return con;
	}

	/**
	 * This function is used to return the unique customer_id
	 * @return
	 */
	public static int getPrimaryKey() {
		int nextvalue = 0;
		Connection con = GetConnection.getCon();
		PreparedStatement ps2;
		try {

			ps2 = con.prepareStatement("select MAX(customer_id) from CUSTOMER");
			ResultSet rs = ps2.executeQuery();
			rs.next();
			nextvalue = rs.getInt(1);
			//Setting up the first customer_id of the bank to 10001000
			if (nextvalue == 0) {
				nextvalue = 10001000;
			} else {
				nextvalue = nextvalue + 1;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nextvalue;
	}
	
	/*This function is used to return unique accountnumber*/
	public static int getAccountNumber() {
		int nextvalue = 0;
		Connection con = GetConnection.getCon();
		PreparedStatement ps2;
		try {

			ps2 = con.prepareStatement("select MAX(account_number) from ACCOUNT");
			ResultSet rs = ps2.executeQuery();
			rs.next();
			nextvalue = rs.getInt(1);
			//Setting up the first customer_id of the bank to 10001000
			if (nextvalue == 0) {
				nextvalue = 10256852;
			} else {
				nextvalue = nextvalue + 1;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nextvalue;
	}
	
	/*This function is used to return unique loanaccountnumber*/
	public static int getLoanAccountNumber() {
		int nextvalue = 0;
		Connection con = GetConnection.getCon();
		PreparedStatement ps2;
		try {

			ps2 = con.prepareStatement("select MAX(loanaccount_number) from LOAN");
			ResultSet rs = ps2.executeQuery();
			rs.next();
			nextvalue = rs.getInt(1);
			//Setting up the first customer_id of the bank to 10001000
			if (nextvalue == 0) {
				nextvalue = 65423;
			} else {
				nextvalue = nextvalue + 1;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nextvalue;
	}
}