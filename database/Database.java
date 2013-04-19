
package database;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.DefaultListModel;
import static procatering.Helper.*;


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
    private PreparedStatement preparedStatement;
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
        String closeStatementError = cleanup.closeStatement(preparedStatement);
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
    
	/**public method gQuery gets an result set from the given query
	 * @param query An SQL-query like <code> SELECT * FROM 'COLUMN'</code>
	 * @return
	 * Returns a Result set of the given <code>query</code> returns <i>null</i> if there is an error
	 * @author J�rgen Lien Sell�g */
//	private ResultSet gQuery(String query){
//            if(createConnection()){
//                try{
//                    statement = connection.createStatement();
//                } catch(SQLException sql){
//                    procatering.Helper.errorMessage(sql,"Error 012: Error while trying to get information from the database.");
//                    return null;
//                }
//                try{
//                    ResultSet result = statement.executeQuery(query);
//                    return result;
//                }catch(SQLException sql2){
//                    procatering.Helper.errorMessage(sql2,"Error 014: Error while trying to get information from the database.");
//                    return null;
//                }
//            }
//                return null;
//	}
	
	/**public method eQuery gets an result set from the given query
	* @param query An SQL-query like <code> UPDATE </code> or similar
	* @return * an integer witch contains the number of rows affected returns -1 if there is an error.
	* @author J�rgen Lien Sell�g */
//	private int eQuery(String query){
//            try{ 
//                    connection = DriverManager.getConnection(URL,username,password);
//                    preparedStatement = connection.createStatement();
//                    return statement.executeUpdate(query);
//                }catch(SQLException sql){
//                    System.err.println("Error message: "+sql);
//                    return -1;
//                }finally{
//                    disconnect();
//                }
//             return -1;
//            }
           

        
        /* QUERIES: */
        
        /**
         * 
         * @param input requires sanitized attributes for the database
         * @return 
         */
        public boolean addCustomer(procatering.Customer input) {
            if(input == null){
                return false;
            }
            /*creating strings for every attribute in the customer object:*/ 
//            String fnClean = input.getFirstName().toUpperCase();
//            String lnClean = input.getLastName().toUpperCase();
            try(Connection con = DriverManager.getConnection(URL,username,password);){
                try(
                    PreparedStatement prepStat = con.prepareStatement("INSERT INTO customer"
                    + "(firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode)"
                    +" VALUES('?', '?', '?', '?', '?', '?', '?', '?')");
                    ){
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
                    }catch(SQLException ePrepState){
                        gui.Gui.showErrorMessage(DATABASE_NUMBER,1, ePrepState);    
                        cleanup.dbRollback(con);
                        return false;
                    }
                }catch(SQLException eCon){
                    gui.Gui.showErrorMessage(DATABASE_NUMBER,2,eCon);
                    return false;                    
                }
        }
        
        public procatering.Customer[] getCustomer(String value) {
            /*creating strings for every attribute in the customer object:*/ 
//            String fnClean = input.getFirstName().toUpperCase();
//            String lnClean = input.getLastName().toUpperCase();
//                        SELECT  *
//                        FROM    pages
//                        WHERE   MATCH(title, content) AGAINST ('keyword' IN BOOLEAN MODE)
            try(Connection con = DriverManager.getConnection(URL,username,password);){
                try(
                    PreparedStatement prepStat = con.prepareStatement("SELECT"
                    + "* FROM customer"
                    +" WHERE MATCH(clean_fn, clean_ln, customer_id, phonenumber) AGAINST ('?')");
                    ){
                        con.setAutoCommit(false);
                            prepStat.setString(1, value);
                            ResultSet rs = prepStat.executeQuery();
                            con.commit();
                        con.setAutoCommit(true);
                        DefaultListModel<procatering.Customer> output = new DefaultListModel<>();
                        while(!rs.next()){
                            output.addElement(new procatering.Customer(rs.getString("address"), rs.getString("clean_fn"), rs.getString("clean_ln"), rs.getString("phonenumber"), rs.getString("email"), rs.getInt("postalcode")));
                        }
                        
                        
                        
                        
                        return true;
                    }catch(SQLException ePrepState){
                        gui.Gui.showErrorMessage(DATABASE_NUMBER,1, ePrepState);    
                        cleanup.dbRollback(con);
                        return false;
                    }
                }catch(SQLException eCon){
                    gui.Gui.showErrorMessage(DATABASE_NUMBER,2,eCon);
                    return false;                    
                }
        }
        
        
        
        //TODO: addcustomer:        OK
        //TODO: getCustomer:        
        //TODO: editCustomer:        
        
        //TODO: addEmployee:
        //TODO: getEmployee:
        //TODO: editEmployee:
        
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
//
//+procatering.Helper.capitalFirst(input.getFirstName())+"', '"
//                    + ""+ procatering.Helper.capitalFirst(input.getLastName()) + "', '" + fnClean +"', '"+ lnClean + "', '" + input.getPhoneNumber() +"', '"
//                    + ""+ input.getEmail() + "', '" + input.getAddress() +"', '"+ input.getPostalCode()+ "')");