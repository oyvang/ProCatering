package database;

import java.sql.*;
import static procatering.Helper.*;

/**
 * @author Team 17
 */
public class DBClean {
	/**
	 * Close a Connection object
	 *
	 * @param con Connection object
	 * @return returns true if con.close() is sucsessfully or if the connection already are closed, else it will return false.<br><br>
	 *         If an SQLException occure it will return false with an error message.
	 * @author Geir Morten Larsen
	 */
	public boolean closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
				return true;
			} else if (con == null) {
				return true;
			}
		} catch (SQLException ex) {
			gui.Gui.showErrorMessage(DATABASE_NUMBER, 1, ex);
			return false;

		}
		gui.Gui.showErrorMessage(DATABASE_NUMBER, 2, new SQLException("The Database connection is not valid."));
		return false;

	}

	/**
	 * Close a ResultSet object
	 *
	 * @param rs ResultSet object
	 * @return true if rs.close() is sucsessfully closed or if it is already closed, else it will return false.<br><br>if an SQLException occure it
	 *         will return false with an error message.
	 * @author Geir Morten Larsen
	 */
	public boolean closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				return true;
			} else if (rs == null) {
				return true;
			}
		} catch (SQLException ex) {
			gui.Gui.showErrorMessage(DATABASECLEAN_NUMBER, 3, new SQLDataException("Error trying to close database ResultSet"));
			return false;

		}
		gui.Gui.showErrorMessage(DATABASECLEAN_NUMBER, 4, new SQLException("The database ResultSet is not valid."));
		return false;
	}

	/**
	 * Colse a Statement object
	 *
	 * @param state Statement object
	 * @return return true if the state.close() are successfully or if it is already closed, else it will return false <br><br>
	 *         If a SQLException occure it will return false with an error message.
	 * @author Geir Morten Larsen
	 */
	public boolean closeStatement(Statement state) {
		try {
			if (state != null) {
				state.close();
				return true;
			} else if (state == null) {
				return true;
			}

		} catch (SQLException ex) {
			gui.Gui.showErrorMessage(DATABASECLEAN_NUMBER, 5, ex);
			return false;
		}
		gui.Gui.showErrorMessage(DATABASECLEAN_NUMBER, 6, new SQLException("The Statement is not valid"));
		return false;
	}

	/**
	 * Do a rollback() if it is a connection with a database but no autoCommint(con.getAutoCommit()).
	 *
	 * @param con Connection object
	 * @return true if the con.rollback() are sucsessfully, else it will return false. <br><br>
	 *         If an SQLExceptio  occure it will return false with an error message.
	 */

	public boolean dbRollback(Connection con) {
		try {
			if (con != null && !con.getAutoCommit()) {
				con.rollback();
				return true;
			}
		} catch (SQLException ex) {
			gui.Gui.showErrorMessage(DATABASECLEAN_NUMBER, 7, ex);
			return false;
		}
		gui.Gui.showErrorMessage(DATABASECLEAN_NUMBER, 8,new SQLException("Error 004: Error trying to fix an error in the database."));
		return false;
	}

	/**
	 * Enable setAutoCommit on an connection object.
	 *
	 * @param con Connection object
	 * @return return true if con.setAutoCommit(true) are sucsessfully or if con.getAutoCommit are true, else it will return false. <br><br>
	 *         If an SQLException occure it will return false with an error message.
	 */

	public boolean autoCommit(Connection con) {
		try {
			if (con != null && !con.getAutoCommit()) {
				con.setAutoCommit(true);
				return true;
			} else if (con != null && con.getAutoCommit()) {
				return true;
			}
		} catch (SQLException ex) {
			gui.Gui.showErrorMessage(DATABASECLEAN_NUMBER, 9, ex);
			return false;
		}
		gui.Gui.showErrorMessage(DATABASECLEAN_NUMBER, 10, new SQLException("Error in the database transaction."));
		return false;
	}
}

