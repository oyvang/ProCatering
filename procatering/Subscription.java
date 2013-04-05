/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

import java.sql.Timestamp;
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
    private int employeeID;
    private int customerID;     //use whole object if we need many queries.

    public Subscription() {
        this.content = new DefaultListModel<OrderContent>();
    }
    
    public void addStartDate(Date start){
        startDate = start;
    }
    
    public void addEndDate(Date end){
        endDate = end;
    }
    
    public void addOrderContent(OrderContent cont){
        content.addElement(cont);
    }
    
    public void addToDB(){
       database.DBConnection db = new database.DBConnection();
       
       db.eQuery("INSERT INTO table_name (column1, column2, column3,...) VALUES (value1, value2, value3,...));
 
    }
}
