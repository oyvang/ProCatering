/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ted
 */
public class Employee extends Person{  //TODO: Fix StringToUpper on "type"
    private String type;
    
    public Employee(String t,String birth, String fn, String ln, String phone, String mail){
    super(birth,  fn,  ln,  phone,  mail);
    this.type = t;
    }

    
    //TODO skriv konstrukt�r for id-kreasjon av et employee-objekt.
    public static Employee getEmployee_id(int employee_id){
        Database db = new Database();
         try(ResultSet rs = db.gQuery("SELECT employee WHERE employee_id ="+employee_id);){
             String type;
             String birth;
             String fName;
             String lName;
             String phone;
             String mail;
             
          while(!rs.next()){
            type = rs.getString("status");  
            birth = rs.getString("dob");
            fName = rs.getString("firstname");
            lName = rs.getString("lastname");
            phone = rs.getString("phone_number");
            mail = rs.getString("email");
          //TODO: CHECK FOR INPUT ERRORS!
           return new Employee(type, birth, fName, lName, phone, mail); 
          }
            
         }catch(SQLException e){
                System.err.println("exception while trying to fetch customers:"+e);
        }

        
    	return null;
    	//Tips: SQL-henting fra databasen
    }
    
    //TODO legg til dokumentasjon
    public String getType() {
        return type;
    }
    //TODO legg til dokumentasjon
    public void setType(String type) {
        this.type = type;
    }    

    @Override
    public String toString() {
        return "Employee{" + "type=" + type + " "+ super.toString()+'}';
    }
    
    
}

