/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.DefaultListModel;


/**
 *
 * @author Ted
 */
public class Subscription {
    private Timestamp startDate;
    private Timestamp endDate;
    private Timestamp orderDate;
    private DefaultListModel<OrderContent> content;
    private int employeeId;
    private int customerId;     //use whole object if we need many queries.
    private String status;      // Active, Completed, Pending or Cancelled // TODO: getSubscriptions checks startDate, if started; activate.

    public Subscription(int e_id, int c_id){
        java.util.Date time= new java.util.Date();
        orderDate = new Timestamp(time.getTime());
        this.content = new DefaultListModel<>();
        employeeId = e_id;
        customerId = c_id;
        status = "Pending";
    }
    public Subscription(Subscription s){
        orderDate = s.getOrderDate();
        content = s.getContent();
        employeeId = s.getEmployeeId();
        customerId = s.getCustomerId();
        status = "Pending";
    }
    //TODO add constructor with endDate
    
    //TODO add documentation

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }
    
    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public DefaultListModel<OrderContent> getContent() {
        return content;
    }
    public void addStartDate(Timestamp start){
        startDate = start;
    }
    
    public void addEndDate(Timestamp end){
        endDate = end;
    }
    //TODO FIX
      public boolean addOrderContent(String weekDay, Timestamp delivery) {
        if(weekDay != null){    
            content.addElement(new OrderContent(weekDay, delivery));
            return true;
        }
        return false;
    }
      
    public boolean addDish(Dish dishName, int quantity, int index){
        if(content.getElementAt(index).addDish(dishName, quantity)){
            return true;
        }
        return false;
    }
    
  /*  public void addToDB(){
       Calendar calendar = Calendar.getInstance();
       java.util.Date now = calendar.getTime();
       Timestamp current = new Timestamp(now.getTime());
       
       database.DBConnection db = new database.DBConnection(); 
       db.eQuery("INSERT INTO order (employee_id, customer_id, time_of_order, status) VALUES ("+employeeId+","+ customerId+","+current+", 'active')");
       ResultSet rs = db.gQuery("SELECT order_id FROM order WHERE timestamp = "+current);
       
       while(rs.next()){
           
       }
 
    }*/


}
