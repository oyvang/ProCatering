package procatering ;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;

/**
 * Person include get and set methodes for: <br> - DOB (Date of Birth), firstName, lastName, phoneNumber, email. <br>
 * - all of these are a object of the type String.<br><br>
 * The class constuctor require (String, String, String, String, String) and are going to fill the variables (DOB,firstName,lastName,phoneNumber,email)
 * @author TEAM 17
 * 
 */

public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int postalCode;
    
    
    /**
     * Person constuctor excepect all parameters have been checked and is correct before trying to create an object of person.
     * @param fn String
     * @param ln String
     * @param phone String
     * @param mail String
     * @param pCode String postal code
     */ 
    public Person(String fn, String ln, String phone, String mail, int pCode){ 

        DOB = birth;
        firstName = fn;
        lastName = ln;
        phoneNumber = phone;
        email = mail;
        postalCode = pCode;
        
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
     * 
     * @return returns the postal code
     */
    public int getPostalCode(){
        return postalCode;
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
 * @param birth String
 * constructor(String type, String, String, String, String, String)
 * @author TEAM 17
 */
class Employee extends Person{ 
    private final String DOB;
    private String type;
    database.Database db;
    
    public Employee(String birth, String type,String birth, String fn, String ln, String phone, String mail, int pCode){
    super(fn,  ln,  phone,  mail, pCode);
    this.type = type.toUpperCase();
    db = new database.Database();
    DOB = birth;
    }


    /**
     * Create a new employee object and returns a reference to that object
     * @param employeeId Employee object
     * @return employee object if sucsessfully fetched from the database if not it will return null
     */
    public static Employee getEmployee(int employeeId){
        Database db = new Database();
         try(ResultSet rs = db.gQuery("SELECT employee WHERE employee_id = "+employeeId+";")){
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
            db.disconnect();
            if(type!=null && birth != null && fName != null && lName != null 
                    && phone != null && mail != null){
                return new Employee(type, birth, fName, lName, phone, mail);
            }
          }           
         }catch(SQLException e){
                System.err.println("exception while trying to fetch customers:"+e);
        }
        db.disconnect();
    	return null;
    	//Tips: SQL-henting fra databasen
    }
    
    /**
     * addEmployee uses a Database object to add a new Employee to the database
     * @param type
     * @param birth
     * @param fn
     * @param ln
     * @param phone
     * @param mail
     * @return a boolean. true if sucsessfully added a new employee, else it will return false;
     */
    public boolean addEmployee (String type,String birth, String fn, String ln, String phone, String mail){
        String cleanFN = fn.toUpperCase();
        String cleanLN = ln.toUpperCase();
        fn = capitalFirst(fn);
        if(db.addEmployee(type,birth,fn,ln,cleanFN,cleanLN,phone,mail)){
            return true;
        }
        return false;
    }
    
       // TO DO:
        // Lag en metode som finner customer... metoden skal sende informasjon vidre til Database db og bruke en metode der som gjør jobben.
    
    /**
     * addCustomer uses a db object and adds a new customer to the database. This metode will turn all first letters in fn and ln to uppercase
     * @param adr
     * @param birth
     * @param fn
     * @param ln
     * @param phone
     * @param mail
     * @return a boolean. if true it has sucsessfully added a new customer to the database, else it will return false.
     */
     public boolean addCustomer (String adr,String birth, String fn, String ln, String phone, String mail){
        String cleanFN = fn.toUpperCase();
        String cleanLN = ln.toUpperCase();
        fn = Helper.capitalFirst(fn);
        if(db.addCustomer(new Customer(adr,birth,fn,ln,phone,mail))){
            return true;
        }
        return false;
    }
    
    /**
     * addDish uses a Database object to add a new dish to the database. this metode will make the first letter in name to uppercase.
     * @param name
     * @param sellPrice
     * @param cost
     * @return a boolean. true if sucsessfully added, else it will return false.
     */
     public boolean addDish(String name, double sellPrice, double cost){
        name = capitalFirst(name);  // skal bruke firstLetterToUppare metode fra Helper classen
        if(db.addDish(name, sellPrice, cost)){
            return true;
        }
        return false;
        }  

     /**
      * updateDishPrices uses a Database object to update both price and cost of an existing dish in the database.
      * @param name
      * @param newPrice
      * @param cost
      * @return a boolean. true if sucsessfully updatet, else it will return false.
      */
    public boolean updateDishPrices(String name, double newPrice, double cost){
        name = capitalFirst(name);
        if(db.updateDishPrices(name, newPrice, cost)){
            return true;
        }
        return false;
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