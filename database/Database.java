
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
public class Database {
    private String username = "q20";
    private String password ="mFW6fL3";
    private String URL = "jdbc:mysql://mysql.stud.aitel.hist.no:3306/q20";
    private String dbDriver = "com.mysql.jdbc.Driver";
    private Connection connection;
    private Statement statement;
    private DBClean cleanup = new DBClean();
    //connection = DriverManager.getConnection(URL,username,password);

    //TODO create documentation for all classes
    public Database () {
        try {
            Class.forName(dbDriver);
        } catch (Exception error){
            System.out.println(error);
        }
    }
        
    /** <h3>public method disconnect()</h3>
     * <p>Closes connection to the database, using the DBClean class. </p>*/
    public String disconnect(){
    	String output ="";
        String closeStatementError = cleanup.closeStatement(statement);
        String closeConnectionError = cleanup.closeConnection(connection);
        
        if(closeConnectionError != null || closeStatementError != null ){
            output += closeConnectionError;
        }
            if(closeStatementError != null){
                output += closeStatementError;
            }
        
    	if(output.equals("")){
            return null;
        }
        return output;
    }
     
    private boolean createConnection(){
        try{
            connection = DriverManager.getConnection(URL,username,password);
            return true;
        }catch(SQLException ex){
            return false;//"Error 011: "+ex;
        } 
    }
    
    public String addCustomer(procatering.Customer custobj) {
        
        return "";
    }
	/**public method gQuery gets an result set from the given query
	 * @param query An SQL-query like <code> SELECT * FROM 'COLUMN'</code>
	 * @return
	 * Returns a Result set of the given <code>query</code> returns <i>null</i> if there is an error
	 * @author J�rgen Lien Sell�g */
	private ResultSet gQuery(String query){
            if(createConnection()){
                try{
                    statement = connection.createStatement();
                } catch(SQLException sql){
                    procatering.errorMessage(sql,"Error 012: Error while trying to get information from the database.");
                    return null;
                }
                try{
                    ResultSet result = statement.executeQuery(query);
                    return result;
                }catch(SQLException sql2){
                    procatering.errorMessage(sql2,"Error 014: Error while trying to get information from the database.");
                    return null;
                }
            }
                return null;
	}
	
	/**public method eQuery gets an result set from the given query
	* @param query An SQL-query like <code> UPDATE </code> or similar
	* @return * an integer witch contains the number of rows affected returns -1 if there is an error.
	* @author J�rgen Lien Sell�g */
	private int eQuery(String query){
            try(Statement statement = connection.createStatement()){ //statement is closed by autoClosable interface implemented in  java7.
                return statement.executeUpdate(query);
            }catch(SQLException sql){
                System.err.println("Error message: "+sql);
                return -1;
            }
	}
}






