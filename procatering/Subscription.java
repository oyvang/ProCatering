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
 * Class Subscription
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

    /**
     * Constructor, creates an object of Subscription
     * Sets the orderDate to current Timestamp.
     * Sets status to "Pending" ( updates in the getSubscription in Database.java )
     * Creates a DefaultListModel with OrderContent
     * @param e_id input for employee id
     * @param c_id input for customer id
     */
    public Subscription(int e_id, int c_id){
        java.util.Date time= new java.util.Date();
        orderDate = new Timestamp(time.getTime());
        this.content = new DefaultListModel<>();
        employeeId = e_id;
        customerId = c_id;
        status = "Pending";
    }

    /** Simple copy-constructor */
    public Subscription(Subscription s){
        orderDate = s.getOrderDate();
        content = s.getContent();
        employeeId = s.getEmployeeId();
        customerId = s.getCustomerId();
        status = "Pending";
    }

    /**
     * Method getOrderDate
     * @return Timestamp with the orderDate
     */
    public Timestamp getOrderDate() {
        return orderDate;
    }

    /**
     * Method getEmployeeId
     * @return int with the employee id
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Method getCustomerId
     * @return int with the customer id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Method getStartDate
     * @return Timestamp with the date the subscription is to be activated
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * Method getEndDate
     * @return Timestamp with the date when the subscription is terminated ( optional )
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * Method getContent
     * @return DefaultListModel<OrderContent> the list of the orderContent for the subscription
     */
    public DefaultListModel<OrderContent> getContent() {
        return content;
    }

    /**
     * Method addSTartDate
     * @param start Timestamp containing the date that the subscription is activated.
     */
    public void addStartDate(Timestamp start){
        startDate = start;
    }

    /**
     * Method addEndDate
     * @param end Timestamp containing the date that the subscription is terminated
     */
    public void addEndDate(Timestamp end){
        endDate = end;
    }

    /**
     * Method addOrderContent
     * Adds an empty (with no dishes) OrderContent object to the list of ordercontent
     * @param weekDay String The day this order is to be delivered repeatedly ( Full name of day with capital first letter )
     * @param delivery Timestamp of the time of the weekDay the order is delivered repeatedly
     * @return boolean returns true if executed successfully with correct argument input
     */
    //TODO FIX
      public boolean addOrderContent(String weekDay, Timestamp delivery) {
        if(weekDay != null){    
            content.addElement(new OrderContent(weekDay, delivery));
            return true;
        }
        return false;
    }

    /**
     * Method addDish
     * Adds a dish to the DefaultListModel containing dishes ( dishes )
     * @param dishName This dish object will be added to the dishes list.
     * @param quantity This amount of dishName will be added to the dishes list.
     * @param index Which OrderConent object the dish is added to. ( index of the content DefaultListModel )
     * @return boolean returns true if added successfully
     */
    public boolean addDish(Dish dishName, int quantity, int index){
        if(content.getElementAt(index).addDish(dishName, quantity)){
            return true;
        }
        return false;
    }
    /**
     * Method toString
     * overview of the subscription for presentation in gui
     * @return String of the subscription object
     */
    public String toString(){
        String output = "Order date: "+ getOrderDate();


        return output;
    }
}
