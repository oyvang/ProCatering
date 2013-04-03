package procatering ;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;

/**
 * 
 * @author TEAM 17
 * 
 */
public class Person {
    private final String DOB;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    
    
    /** Constructor */
    public Person(String birth, String fn, String ln, String phone, String mail){
        /* Check if correct syntax is inserted */
        
        /* creating*/
        DOB = birth;
        firstName = fn;
        lastName = ln;
        phoneNumber = phone;
        email = mail;
    }

    public String getDOB(){
        return DOB;
        //TODO legg til dokumentasjon
    }
    
    public String getFirstName() {
        return firstName;
      //TODO legg til dokumentasjon
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
      //TODO legg til dokumentasjon
    }

    public String getLastName() {
        return lastName;
      //TODO legg til dokumentasjon
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
      //TODO legg til dokumentasjon
    }

    public String getPhoneNumber() {
        return phoneNumber;
      //TODO legg til dokumentasjon
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
      //TODO legg til dokumentasjon
    }

    public String getEmail() {
        return email;
      //TODO legg til dokumentasjon
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" + "DOB=" + DOB + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + '}';
    }
}
//TODO legg til dokumentasjon

class Employee extends Person{  //TODO: Fix StringToUpper on "type"
    private String type;
    
    public Employee(String t,String birth, String fn, String ln, String phone, String mail){
    super(birth,  fn,  ln,  phone,  mail);
    this.type = t;
    }

    
    //TODO skriv konstruktør for id-kreasjon av et employee-objekt.
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

class Customer extends Person{
    private String address;
    
    public Customer(String adr,String birth, String fn, String ln, String phone, String mail){
        super( birth,  fn,  ln,  phone,  mail);
        this.address = adr;
    }
    public Customer(int c_id){
    	super("p","2","e","e","2"); //slett dette, kun her for å få bort den jævla feilmeldinga... 
    	//TODO Skriv sql-kode som henter ut costumerinformasjon fra databasen
    	//Nå lages en costumer fra inforamsjonen fra databasen.
    	//parameter i super skives inforamajsonenewn w
    	System.out.println("Slett dette");
    	
    }
    //TODO legg til dokumentasjon
    public String getAddress() {
        return address;
    }
    //TODO legg til dokumentasjon
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "address=" + address +" "+ super.toString()+'}';
    }
    
}
