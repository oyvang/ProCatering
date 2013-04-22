package procatering;

/**
 *
 * @author TEAM 17
 */

import javax.swing.*;
import java.sql.Timestamp;

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
    public int getEmployeeId(){
        return employeeId;
    }
    
    public int getCustomerId(){
        return customerId;
    }
    
    public Timestamp getDate(){
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
     * Adds the date the order is made
     * @param date
     */
    public void addDate(Timestamp date) {
        this.date = date;
    }

    /**
     * @param orderObj This ordercontent object will be added to the order list.
     */
    public void addOrderContent(OrderContent orderObj) {
        for (int i = 0; i < ordercontent.getSize(); i++) {
            ordercontent.addElement(orderObj);
        }
    }

    public void addDB(){
       database.Database db = new database.Database();
    }
}
