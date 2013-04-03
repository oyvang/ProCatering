
package database;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author TEAM 17
 *
 */ 
public class DBConnection {
    private String username = "guutorg_team17";
    private String password ="etSterktpass0rdmeddollartegn$";
    private String URL = "jdbc:mysql://ida.host1.no:3306/guutorg_procatering";
    private String dbDriver = "com.mysql.jdbc.Driver";
    private Connection connection;
    private Statement statement;
    private DBClean cleanup = new DBClean();
    
    /** constructor for DBConnection.</h3> 
     * Establishes a database connection to the server hard coded in the source file
     * */
    public DBConnection () {
            try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(URL,username,password);
            } catch (Exception error){
                showMessageDialog(null, "An Error have occurred when trying to accses the database!\n\n" + error,"ERROR!", ERROR_MESSAGE);
                System.out.println(error);
        }
    }
        
    /** <h3>public method disconnect()</h3>
     * <p>Closes connection to the database, using the DBClean class. </p>*/
    public void disconnect(){
    	cleanup.closeStatement(statement);
    	cleanup.closeConnection(connection);
    }
     

	/**public method gQuery gets an result set from the given query
	 * @param query An SQL-query like <code> SELECT * FROM 'COLUMN'</code>
	 * @return
	 * Returns a Result set of the given <code>query</code> returns <i>null</i> if there is an error
	 * @author Jørgen Lien Sellæg */
	public ResultSet gQuery(String query){
		try{
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			return result;
		} catch(SQLException sql){
			System.err.println("Error message: "+sql);
			return null;
		}
	}
	
	/**public method eQuery gets an result set from the given query
	* @param query An SQL-query like <code> UPDATE </code> or similar
	* @return * an integer witch contains the number of rows affected returns -1 if there is an error.
	* @author Jørgen Lien Sellæg */
	public int eQuery(String query){
		try(Statement statement = connection.createStatement()){ //statement is closed by try-catch
			return statement.executeUpdate(query);
		}catch(SQLException sql){
			System.err.println("Error message: "+sql);
			return -1;
		}
	}
}






