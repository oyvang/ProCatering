package database;

import java.sql.*;
import static javax.swing.JOptionPane.*;
/**
 *
 * @author Team 17
 */
public class DBClean {
//TODO edit documentation for entire class. <--
    /**
     * Close a Connection object
     * @param con Connection object
     * @return returns true if con.close() is sucsessfully or if the connection already are closed, else it will return false.<br><br>
     *         If an SQLException occure it will return false with an error message.
     * @author Geir Morten Larsen
     *
     */
    public String closeConnection(Connection con) {
        try{
            if(con != null) {
                con.close();
                return null;
            }else if(con == null){
                return null;
            }
        }catch (SQLException ex){
           return errorMessage(ex, "Error 006: Error trying to close database Connection");

        }
         return "Error 001: The Database connection is not valid.";

    }
    /**
     * Close a ResultSet object
     * @param rs ResultSet object
     * @return true if rs.close() is sucsessfully closed or if it is already closed, else it will return false.<br><br>if an SQLException occure it
     *          will return false with an error message.
     * @author Geir Morten Larsen
     */
    public String closeResultSet(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
                return null;
            } else if(rs == null){
                return null;
            }
        }catch (SQLException ex) {
            return errorMessage(ex, "Error 007: Error trying to close database ResultSet");

        }
         return "Error 002: The database resultset is not valid.";
    }
    /**
     * Colse a Statement object
     * @param state Statement object
     * @return return true if the state.close() are sucsessfully or if it is already closed, else it will return false <br><br>
     *          If a SQLException occure it will return false with an error message.
     * @author Geir Morten Larsen
     */
    public String closeStatement(Statement state) {
        try {
            if(state != null){
                state.close();
                return null;
            } else if(state == null){
                return null;
            }

        }catch (SQLException ex) {
            return errorMessage(ex, "Error 008: Error trying to close database Statement");
        }
        return "Error 003: The statement is not valid.";
    }

    /**
     * Do a rollback() if it is a connection with a database but no autoCommint(con.getAutoCommit()).
     * @param con Connection object
     * @return true if the con.rollback() are sucsessfully, else it will return false. <br><br>
     *          If an SQLExceptio  occure it will return false with an error message.
     */

    public String dbRollback(Connection con){
        try {
            if(con != null && !con.getAutoCommit()){
                con.rollback();
                return null;
            }
        }catch (SQLException ex){
            return errorMessage(ex, "Error 009: Error trying to rollback");
        }
         return "Error 004: Error trying to fix an error in the database.";
    }
    /**
     * Enable setAutoCommit on an connection object.
     * @param con Connection object
     * @return return true if con.setAutoCommit(true) are sucsessfully or if con.getAutoCommit are true, else it will return false. <br><br>
     *      If an SQLException occure it will return false with an error message.
     */

    public String autoCommit(Connection con){
        try{
            if(con!=null && !con.getAutoCommit()){
                con.setAutoCommit(true);
                return null;
            }else if(con!=null && con.getAutoCommit()){
                return null;
            }
        }catch (SQLException ex) {
            errorMessage(ex, "Error 010: Error trying to start setAutoCommit");
        }
            return "Error 005: Error in the database transaction.";
    }


    /**
     * Uses showMessageDialog to print out error messages.
     *
     * @param ex Exception object
     * @param error String object
     * @return return showMessageDialog(null, "ERROR! \n" + error + "\n" + ex,"Database Error!", ERROR_MESSAGE);
     * @author Geir Morten Larsen
     */
    private String errorMessage(Exception ex, String error) {
        if(ex != null && error != null){
            return "ERROR! \n" + error + "\n" + ex;
        }
        return "Error 666: Error while trying to make an errormessage.";
    }
}

