

package procatering;

import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author GeirMorten
 */
public class Employee extends Person{ 
    private final String dob;
    private String type;
    database.Database db;
    
    public Employee(String type, String fn, String ln, String phone, int pCode,String dob, String mail){
    super(fn,  ln,  phone,  mail, pCode);
    this.type = type.toUpperCase();
    this.dob = dob;
    db = new Database();
    }
    
    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type.toUpperCase();
    }
    public String getDob () {
        return dob;
    }


    public boolean addEmployee (String type, String fn, String ln, String phone, int pCode,String dob, String mail, String pw){
        fn = Helper.capitalFirst(fn);
        if(999 < pCode && pCode> 10000){
            if(db.addEmployee(new Employee(type, fn, ln, phone, pCode,dob, mail),pw)){
                return true;
            
            //SJEKK  999 < POSTALCODE >10000
            }
        }
        return false;
    }
    
    public boolean getEmployee (int id){
        if(db.getEmployee(id)!= null){
            return true;
        }
        return false;
    }
    
    public boolean updateEmployee (Employee input, int id){
        if(db.updateEmployee(input, id)){
            return true;
        }
        return false;
    }
    
    public boolean changeEmployeePassword (String input, int id){
        if(db.changeEmployeePassword(input, id)){
            return true;
        }
        return false;
    }
    
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