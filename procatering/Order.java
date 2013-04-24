
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
    private String status;      // Active, Completed or Cancelled
    private Timestamp orderDate;
    private DefaultListModel<OrderContent> ordercontent;
    
    /* Constructor */
    public Order(int c_id, int e_id, String status) {
        customerId = c_id;
        employeeId = e_id;
        this.status = status;
        this.orderDate = orderDate;
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
    
    public boolean addDish(Dish dishName, int quantity, int index){
        if(ordercontent.getElementAt(index).addDish(dishName, quantity)){
            return true;
        }
        return false;
    }
     /**
     * Adds the orderDate the order is made
     * @param orderDate
     */
    public Timestamp getCurrentDate(){
        java.util.Date time= new java.util.Date();
	Timestamp date = new Timestamp(time.getTime());
        return date;
    }
    public Timestamp getOrderDate(){
        return orderDate;
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
    public boolean addOrderContent(Timestamp delivery) {
        if(delivery != null){    
            ordercontent.addElement(new OrderContent(delivery));
            return true;
        }
        return false;
    }
    //TODO: ADDISH
    
    public void addDB(){
        database.Database db = new database.Database();
    }
    
    @Override
    public String toString() {
        String output ="Order created: "+orderDate+"\n\n";
        for (int i = 0; i < ordercontent.size(); i++) {
            output+= ordercontent.get(i)+"\n"; 
        }
        return output;
    }
}

