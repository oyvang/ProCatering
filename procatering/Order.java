
package procatering;

/**
 *
 * @author TEAM 17
 */

import database.Database;
import java.sql.Timestamp;
import javax.swing.*;

public class Order {
    
    private int customerId;
    private int employeeId;
    private String status;
    private Timestamp date;
    private DefaultListModel<OrderContent> ordercontent;
    
    /* Constructor */
    public Order(int c_id, int e_id, String status) {
        customerId = c_id;
        employeeId = e_id;
        this.status = status;
        this.date = date;
        ordercontent = new DefaultListModel();
	}
    
     /** Standard copy constructor */ 
    public Order(Order o){
        this(o.getCustomerId(),o.getEmployeeId(),o.getStatus());
        this.date = o.getDate();
        this.ordercontent = o.getOrderContent();
    }
	
    public int getEmployeeId(){
        return employeeId;
    }
    
    public int getCustomerId(){
        return customerId;
    }
    
     /**
     * Adds the date the order is made
     * @param date
     */
    public Timestamp getDate(){
        java.util.Date time= new java.util.Date();
	Timestamp date = new Timestamp(time.getTime());
        return date;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    public DefaultListModel getOrderContent() {
        return ordercontent;
    }
    
    
    /**
     * @param orderObj This ordercontent object will be added to the order list.
     */
    public boolean addOrderContent(DefaultListModel<Dish> dishes, Timestamp delivery) {
        if(dishes != null){    
            ordercontent.addElement(new OrderContent(dishes, delivery));
            return true;
        }
        return false;
    }
    
    public void addDB(){
        database.Database db = new database.Database();
    }
    
    @Override
    public String toString() {
        Database db = new Database();
        Customer customer = db.getCustomer(customerId);
        return customer.getLastName() + ", " + customer.getFirstName()+ " - " + date;
    }
}

