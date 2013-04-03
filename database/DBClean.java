package database;

import java.sql.*;
import static javax.swing.JOptionPane.*;
/**
 *
 * @author Team 17
 */
public class DBClean {

    /**
     * Close a Connection object
     * @param con Connection object
     * @return returns true if con.close() is sucsessfully or if the connection already are closed, else it will return false.<br><br>
     *         If an SQLException occure it will return false with an error message.
     * @author Geir Morten Larsen
     *
     */
    public boolean closeConnection(Connection con) {
        try{
            if(con != null) {
                con.close();
                return true;
            }else if(con == null){
                return true;
            }
        }catch (SQLException ex){
            errorMessage(ex, "Error trying to close database Connection");

        }
        return false;

    }
    /**
     * Close a ResultSet object
     * @param rs ResultSet object
     * @return true if rs.close() is sucsessfully closed or if it is already closed, else it will return false.<br><br>if an SQLException occure it
     *          will return false with an error message.
     * @author Geir Morten Larsen
     */
    public boolean closeResultSet(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
                return true;
            } else if(rs == null){
                return true;
            }
        }catch (SQLException ex) {
            errorMessage(ex, "Error trying to close database ResultSet");

        }

        return false;
    }
    /**
     * Colse a Statement object
     * @param state Statement object
     * @return return true if the state.close() are sucsessfully or if it is already closed, else it will return false <br><br>
     *          If a SQLException occure it will return false with an error message.
     * @author Geir Morten Larsen
     */
    public boolean closeStatement(Statement state) {
        try {
            if(state != null){

                state.close();
                return true;
            } else if(state == null){
                return true;
            }

        }catch (SQLException ex) {
            errorMessage(ex, "Error trying to close database Statement");
        }
        return false;
    }

    /**
     * Do a rollback() if it is a connection with a database but no autoCommint(con.getAutoCommit()).
     * @param con Connection object
     * @return true if the con.rollback() are sucsessfully, else it will return false. <br><br>
     *          If an SQLExceptio  occure it will return false with an error message.
     */

    public boolean dbRollback(Connection con){
        try {
            if(con != null && !con.getAutoCommit()){
                con.rollback();
                return true;
            }
        }catch (SQLException ex){
            errorMessage(ex, "Error trying to rollback");
        }
        return false;
    }
    /**
     * Enable setAutoCommit on an connection object.
     * @param con Connection object
     * @return return true if con.setAutoCommit(true) are sucsessfully or if con.getAutoCommit are true, else it will return false. <br><br>
     *      If an SQLException occure it will return false with an error message.
     */

    public boolean autoCommit(Connection con){
        try{
            if(con!=null && !con.getAutoCommit()){
                con.setAutoCommit(true);
                return true;
            }else if(con!=null && con.getAutoCommit()){
                return true;
            }
        }catch (SQLException ex) {
            errorMessage(ex, "Error trying to start setAutoCommit");
        }
        return false;
    }


    /**
     * Uses showMessageDialog to print out error messages.
     *
     * @param ex Exception object
     * @param error String object
     * @return return showMessageDialog(null, "ERROR! \n" + error + "\n" + ex,"Database Error!", ERROR_MESSAGE);
     * @author Geir Morten Larsen
     */
    private void errorMessage(Exception ex, String error) {
        showMessageDialog(null, "ERROR! \n" + error + "\n" + ex,"Database Error!", ERROR_MESSAGE);
    }
}

