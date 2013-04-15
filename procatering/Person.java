package procatering ;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;

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

