package procatering ;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;

/**
 * Person include get and set methodes for: <br> - DOB (Date of Birth), firstName, lastName, phoneNumber, email. <br>
 * - all of these are a object of the type String.<br><br>
 * The class constuctor require (String, String, String, String, String) and are going to fill the variables (DOB,firstName,lastName,phoneNumber,email)
 * @author TEAM 17
 * 
 */

public class Person {
    private final String DOB;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    
    
    /**
     * Person constuctor excepect all parameters have been checked and is correct before trying to create an object of person.
     * @param birth String
     * @param fn String
     * @param ln String
     * @param phone String
     * @param mail  
     */ 
    public Person(String birth, String fn, String ln, String phone, String mail){

        DOB = birth;
        firstName = fn;
        lastName = ln;
        phoneNumber = phone;
        email = mail;
        
    }
    /**
     * DOB are of object type String
     * @return DOB 
     */
    public String getDOB(){
        return DOB;
    }
    /**
     * firstName are of object type String
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * set firstName variable to equal the parameter firstName
     * @param firstName String object
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * lastName are of object type String
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * set lastName variable to equal the parameter lastName
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * phoneNumber are of object type String
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * set phoneNumber variable to equal the parameter phoneNumber
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * email are of object type String
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * set email variable to equal the parameter email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * toString are of the type String
     * @return class information: <br>DOB, firstName, lastName, phoneNumber, email
     */
    @Override
    public String toString() {
        return "Person{" + "DOB=" + DOB + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + '}';
    }
}

/**
 * Customer cunstructor takes a String pluss the same constructor as the class Person<br>
 * constructor(String type, String, String, String, String, String)
 * @author TEAM 17
 */
class Employee extends Person{ 
    private String type;
    
    public Employee(String t,String birth, String fn, String ln, String phone, String mail){
    super(birth,  fn,  ln,  phone,  mail);
    this.type = t.toUpperCase();
    }


    /**
     * Create a  new employee object and returns a reference to that object
     * @param employee_id Employee object
     * @return employee object if sucsessfully fetched from the database if not it will return null
     */
    public static Employee getEmployee_id(int employee_id){
        DBConnection db = new DBConnection();
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
            if(type!=null && birth != null && fName != null && lName != null 
                    && phone != null && mail != null){
                return new Employee(type, birth, fName, lName, phone, mail);
            }
          }
            
         }catch(SQLException e){
                System.err.println("exception while trying to fetch customers:"+e);
        }

        
    	return null;
    	//Tips: SQL-henting fra databasen
    }
    
    /**
     * type are of object type String
     * @return type
     */
    public String getType() {
        return type;
    }
    /**
     * set type variable to the parameter type
     * @param type String object
     */
    public void setType(String type) {
        this.type = type.toUpperCase();
    }    
    /**
     * toString are of the object String
     * @return class information and Person class toString: <br>
     * returns: type + Person toString
     */
    @Override
    public String toString() {
        return "Employee{" + "type=" + type + " "+ super.toString()+'}';
    }
    
    
}
/**
 * Customer cunstructor takes a String pluss the same constructor as the class Person<br>
 * constructor(String address, String, String, String, String, String)
 * @author GM
 */
class Customer extends Person{
    private String address;
    
    public Customer(String adr,String birth, String fn, String ln, String phone, String mail){
        super( birth,  fn,  ln,  phone,  mail);
        this.address = adr;
    }

    /**
     * address are of object type String
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**
     * set address to equal the parameter address
     * @param address String object
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * toString are of the object type String
     * @return class information pluss Person class information
     * returns: address + Person.toString
     */
    @Override
    public String toString() {
        return "Customer{" + "address=" + address +" "+ super.toString()+'}';
    }
    
}
