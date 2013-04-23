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

    public Subscription() {
        this.content = new DefaultListModel<>();
    }
    
    public void addStartDate(Timestamp start){
        startDate = start;
    }
    
    public void addEndDate(Timestamp end){
        endDate = end;
    }
    
      public boolean addOrderContent(DefaultListModel<Dish> dishes,int weekDay, Timestamp delivery) {
        if(dishes != null){    
            content.addElement(new OrderContent(dishes, weekDay, delivery));
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
