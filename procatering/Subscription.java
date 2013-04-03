/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

import javax.swing.DefaultListModel;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author Ted
 */
public class Subscription {
    private Date startDate;
    private Date endDate;
    private DefaultListModel<OrderContent> content;

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
    
    public void addDB(){
       database.DBConnection db = new database.DBConnection();
       
       db.eQuery("INSERT INTO table_name (column1, column2, column3,...) VALUES (value1, value2, value3,...));
       
       
    }
}
