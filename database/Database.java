
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
import procatering.*;



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
    
    
    public boolean addEmployee(Employee input, String pw) {
        if(input == null){
            return false;
        }
        /*creating strings for every attribute in the customer object:*/
        //            String fnClean = input.getFirstName().toUpperCase();
        //            String lnClean = input.getLastName().toUpperCase();
        try(Connection con = DriverManager.getConnection(URL,username,password);){
            try(
                    PreparedStatement prepStat = con.prepareStatement("INSERT INTO customer"
                            + "(type_id, firstname, lastname, clean_fn, clean_ln, password, phonenumber,"
                            + "postalcode, dob, email)"
                            +" VALUES('?', '?', '?', '?', '?', '?', '?', '?', '?', '?')");
                    ){
                con.setAutoCommit(false);
                prepStat.setString(1, input.getType());
                prepStat.setString(2, input.getFirstName());
                prepStat.setString(3, input.getLastName());
                prepStat.setString(4, input.getFirstName().toUpperCase());
                prepStat.setString(5, input.getLastName().toUpperCase());
                prepStat.setString(6, pw);
                prepStat.setString(7, input.getPhoneNumber());
                prepStat.setInt(8, input.getPostalCode());
                prepStat.setString(9, input.getDob());;
                prepStat.setString(10, input.getEmail());
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
    
    public Employee getEmployee(int id) {
        if(id <1){
            return null;
        }
        /*creating strings for every attribute in the customer object:*/
        try(Connection con = DriverManager.getConnection(URL,username,password);){
            try(
                    PreparedStatement prepStat = con.prepareStatement("SELECT * FROM employee"
                            + "WHERE employee_id = ?;");
                    ){
                        prepStat.setInt(1, id);
                try( ResultSet rs = prepStat.executeQuery();) {
                    
                    while(!rs.next()){
                        String type = rs.getString("type_id");
                        String fn = rs.getString("firstname");
                        String ln = rs.getString("lastname");
                        String dob = rs.getString("dob");
                        String phone = rs.getString("phonenumber");
                        String mail = rs.getString("mail");
                        int pCode = rs.getInt("postalcode");
                        
                        if(type!=null && fn != null && ln != null && dob != null
                                && phone != null && mail != null && pCode > 999 && pCode < 10000){
                            return new Employee(type, fn, ln, phone, pCode, dob, mail);
                        }else {
                            return null;
                        }
                    } //String type, String fn, String ln, String phone, int pCode,String dob, String mail
                    
                }catch(SQLException ePrepState){
                    gui.Gui.showErrorMessage(DATABASE_NUMBER,1, ePrepState);
                    cleanup.dbRollback(con);
                    return null;
                }
                
            }catch(SQLException ePrepState){
                gui.Gui.showErrorMessage(DATABASE_NUMBER,1, ePrepState);
                cleanup.dbRollback(con);
                return null;
            }
        }catch(SQLException eCon){
            gui.Gui.showErrorMessage(DATABASE_NUMBER,2,eCon);
            return null;
        }
        return null;   /// WHY NOT UNREACHABLE!?
    }
    
      public boolean updateEmployee(procatering.Employee input, int id) {
            if(input == null){
                return false;
            }
            /*creating strings for every attribute in the customer object:*/ 
//            String fnClean = input.getFirstName().toUpperCase();
//            String lnClean = input.getLastName().toUpperCase();
            try(Connection con = DriverManager.getConnection(URL,username,password);){
                try(
                    PreparedStatement prepStat = con.prepareStatement("Update customer"
                    + "SET type_id = ?, firstname = ?, lastname = ?, clean_fn = ?, clean_ln = ?, password = ?, dob = ?, email = ?," 
                    +" WHERE employee_id = ?;");
                    ){
                        con.setAutoCommit(false);
                            prepStat.setString(1, input.getType());
                            prepStat.setString(2, input.getFirstName());
                            prepStat.setString(3, input.getLastName());
                            prepStat.setString(4, input.getFirstName().toUpperCase());
                            prepStat.setString(5, input.getLastName().toUpperCase());
                            prepStat.setString(6, input.getPhoneNumber());
                            prepStat.setInt(7, input.getPostalCode());
                            prepStat.setString(8, input.getDob());
                            prepStat.setString(9, input.getEmail());
                            prepStat.setInt(10, id);
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
      
      public boolean changeEmployeePassword(String input, int id){
                  if(input == null){
                return false;
            }
            /*creating strings for every attribute in the customer object:*/ 
//            String fnClean = input.getFirstName().toUpperCase();
//            String lnClean = input.getLastName().toUpperCase();
            try(Connection con = DriverManager.getConnection(URL,username,password);){
                try(
                    PreparedStatement prepStat = con.prepareStatement("Update customer"
                    + "SET password = ?,"
                    +" WHERE employee_id = ?;");
                    ){
                        con.setAutoCommit(false);
                            prepStat.setString(1, input);;
                            prepStat.setInt(2, id);
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
    
    
    
    



//TODO: addcustomer:        OK
//TODO: getCustomer:
//TODO: editCustomer:

//TODO: addEmployee:    done
//TODO: getEmployee:    done
//TODO: editEmployee:   done
//TODO: changeEmployeePassword: done      

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

