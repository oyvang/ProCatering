
package database;

import gui.Gui;
import procatering.Employee;

import javax.swing.*;
import java.sql.*;

import static procatering.Helper.DATABASE_NUMBER;

/**
 * @author TEAM 17
 */
public class Database {
	private final String username = "q20";
	private final String password = "mFW6fL3";
	private final String URL = "jdbc:mysql://mysql.stud.aitel.hist.no:3306/q20";
	private final String dbDriver = "com.mysql.jdbc.Driver";
	private Connection connection;
	private PreparedStatement preparedStatement;
	private final DBClean cleanup = new DBClean();

	//TODO create documentation for all classes
	public Database() {
		try {
			Class.forName(dbDriver);
		} catch (Exception error) {
			System.out.println(error);
		}
	}

	/**
	 * addCustomer
	 *
	 * @param input a customer object's attributes are inserted to customer table in DB
	 * @return false if the addition of the customer somehow fails. Returns true if everything went fine.
	 */
	public boolean addCustomer(procatering.Customer input) {
		if (input == null) {
			return false;
		}
		try (Connection con = DriverManager.getConnection(URL, username, password)) {
			try (
					PreparedStatement prepStat = con.prepareStatement("INSERT INTO customer"
							+ "(firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode)"
							+ " VALUES('?', '?', '?', '?', '?', '?', '?', '?')")
			) {
				con.setAutoCommit(false);
				prepStat.setString(1, input.getFirstName());
				prepStat.setString(2, input.getLastName());
				prepStat.setString(3, input.getFirstName().toUpperCase());
				prepStat.setString(4, input.getLastName().toUpperCase());
				prepStat.setString(5, input.getPhoneNumber());
				prepStat.setString(6, input.getEmail());
				prepStat.setString(7, input.getAddress());
				prepStat.setInt(8, input.getPostalCode());
				prepStat.executeUpdate();
				con.commit();
				con.setAutoCommit(true);
				return true;
			} catch (SQLException ePrepState) {
				gui.Gui.showErrorMessage(DATABASE_NUMBER, 1, ePrepState);
				cleanup.dbRollback(con);
				return false;
			}
		} catch (SQLException eCon) {
			gui.Gui.showErrorMessage(DATABASE_NUMBER, 2, eCon);
			return false;
		}
	}

	public DefaultListModel<procatering.Customer> findCustomer(String value) {
            /*creating strings for every attribute in the customer object:*/
//            String fnClean = input.getFirstName().toUpperCase();
//            String lnClean = input.getLastName().toUpperCase();

		try (Connection con = DriverManager.getConnection(URL, username, password)) {
			try (
					PreparedStatement prepStat = con.prepareStatement("SELECT * FROM customer "
							+ "WHERE clean_fn LIKE '%?%' OR clean_ln LIKE '%?%' OR phonenumber LIKE '%?%' OR postalcode LIKE '%?%'")
			) {
				con.setAutoCommit(false);
				prepStat.setString(1, value);
				prepStat.setString(2, value);
				prepStat.setString(3, value);
				prepStat.setString(4, value);
				ResultSet rs = prepStat.executeQuery();
				con.commit();
				con.setAutoCommit(true);
				DefaultListModel<procatering.Customer> output = new DefaultListModel<>();
				while (!rs.next()) {
					output.addElement(new procatering.Customer(rs.getString("address"), rs.getString("clean_fn"), rs.getString("clean_ln"), rs.getString("phonenumber"), rs.getString("email"), rs.getInt("postalcode"), rs.getInt("customer_id")));
				}
				return output;
			} catch (SQLException ePrepState) {
				gui.Gui.showErrorMessage(DATABASE_NUMBER, 1, ePrepState);
				cleanup.dbRollback(con);
				return null;
			}
		} catch (SQLException eCon) {
			gui.Gui.showErrorMessage(DATABASE_NUMBER, 2, eCon);
			return null;
		}
	}

	public procatering.Customer getCustomer(int cid) {
            /*creating strings for every attribute in the customer object:*/
//            String fnClean = input.getFirstName().toUpperCase();
//            String lnClean = input.getLastName().toUpperCase();

		try (Connection con = DriverManager.getConnection(URL, username, password)) {
			try (
					PreparedStatement prepStat = con.prepareStatement("SELECT * FROM customer WHERE customer_id = ?")
			) {
				con.setAutoCommit(false);
				prepStat.setInt(1, cid);
				ResultSet rs = prepStat.executeQuery();
				con.commit();
				con.setAutoCommit(true);
				rs.first();
				return new procatering.Customer(rs.getString("address"), rs.getString("clean_fn"), rs.getString("clean_ln"), rs.getString("phonenumber"), rs.getString("email"), rs.getInt("postalcode"), rs.getInt("customer_id"));
			} catch (SQLException ePrepState) {
				gui.Gui.showErrorMessage(DATABASE_NUMBER, 1, ePrepState);
				cleanup.dbRollback(con);
				return null;
			}
		} catch (SQLException eCon) {
			gui.Gui.showErrorMessage(DATABASE_NUMBER, 2, eCon);
			return null;
		}
	}

	public boolean updateCustomer(procatering.Customer input, int cid) {
		if (input == null || cid < 1) {
			return false;
		}
		try (Connection con = DriverManager.getConnection(URL, username, password)) {
			try (
					PreparedStatement prepStat = con.prepareStatement("UPDATE customer "
							+ "SET firstname = '?', lastname = '?', clean_fn = '?', clean_ln = '?', phonenumber = '?', email = '?', address = '?', postalcode = '?'"
							+ " WHERE customer_id = ?")
			) {
				con.setAutoCommit(false);
				prepStat.setString(1, input.getFirstName());
				prepStat.setString(2, input.getLastName());
				prepStat.setString(3, input.getFirstName().toUpperCase());
				prepStat.setString(4, input.getLastName().toUpperCase());
				prepStat.setString(5, input.getPhoneNumber());
				prepStat.setString(6, input.getEmail());
				prepStat.setString(7, input.getAddress());
				prepStat.setInt(8, input.getPostalCode());
				prepStat.setInt(9, cid);
				prepStat.executeUpdate();
				con.commit();
				con.setAutoCommit(true);
				return true;
			} catch (SQLException ePrepState) {
				gui.Gui.showErrorMessage(DATABASE_NUMBER, 1, ePrepState);
				cleanup.dbRollback(con);
				return false;
			}
		} catch (SQLException eCon) {
			gui.Gui.showErrorMessage(DATABASE_NUMBER, 2, eCon);
			return false;
		}
	}

	public String getPasswordFromDatabase(int id) {
		String query = "SELECT password FROM employee WHERE employee_id = ?";
		try (Connection con = DriverManager.getConnection(URL, username, password);
			 PreparedStatement prep = con.prepareStatement(query)) {
			prep.setInt(id, id);
			ResultSet ans = prep.executeQuery();
			ans.first();
			return ans.getString(1);
		} catch (SQLException e) {
			Gui.showErrorMessage(DATABASE_NUMBER,100,e);
			return null;
		}
	}

	public static Employee getEmployee(int EmployeeId){
		//TODO write method.
		return null;
	}
	//TODO: add customer:        OK
	//TODO: getCustomer:
	//TODO: editCustomer:
	//TODO: add customer:        OK
	//TODO: findCustomer:       OK
	//TODO: getCustomer:        OK
	//TODO: updateCustomer:     OK
	//TODO: addEmployee:        OK
	//TODO: getEmployee:        gm
	//TODO: editEmployee:       gm

	//TODO: addDish:
	//TODO: getDish:
	//TODO: getDishes:
	//TODO: editDish:
	//TODO: removeDish:

	//TODO: addCategory:
	//TODO: getCategories:
	//TODO: editCategory:
	//TODO: removeCategory:

	//TODO: addOrder:
	//TODO: getOrder:
	//TODO: getOrders:
	//TODO: editOrder:      ?

	//TODO: addSubscription:
	//TODO: getSubscription:
	//TODO: getSubscriptions:
	//TODO: editSubscription:
}

//
//+procatering.Helper.capitalFirst(input.getFirstName())+"', '"
//                    + ""+ procatering.Helper.capitalFirst(input.getLastName()) + "', '" + fnClean +"', '"+ lnClean + "', '" + input.getPhoneNumber() +"', '"
//                    + ""+ input.getEmail() + "', '" + input.getAddress() +"', '"+ input.getPostalCode()+ "')");
