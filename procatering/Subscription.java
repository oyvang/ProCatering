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
    private int OrderId;

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
        status = "Pending"; //TODO fix check for what status it should be.
    }

    /**
     * Constructor, creates an object of Subscription
     * From DB
     * Sets the orderDate to current Timestamp.
     * Sets status to "Pending" ( updates in the getSubscription in Database.java )
     * Creates a DefaultListModel with OrderContent
     * @param order_id input for order id
     * @param e_id input for employee id
     * @param c_id input for customer id
     */
    public Subscription(int order_id,int e_id, int c_id, Timestamp start, Timestamp created, DefaultListModel<OrderContent> contentList, String status){
        OrderId = order_id;
        orderDate = created;
        this.content = contentList;
        employeeId = e_id;
        customerId = c_id;
        status = "Pending";
    }
    /*
        private void subscriptionActivationDateSubmitButtonActionPerformed() {
        Date date = subscriptionDatePicker.getDate();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH);//TODO move.
        int dd = cal.get(Calendar.DATE);
        int time = Integer.parseInt(singleOrderAddTimeComboBox.getSelectedItem().toString().trim().substring(0, 2));
        Timestamp ts = new Timestamp(yy-1900,mm,dd,0,0,0,0); //TODO Possible fix this... NOT
        System.out.println(ts); //TODO remove
        loggedInEmployee.addSubscriptionStartDate(ts);
        subscriptionUpdateTextpane();
    }
     */

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
     * Adds an empty (with no dishes) OrderContent object to the list of ordercontent,
     * If the day already is added, nothing gets added
     * @param weekDay String The day this order is to be delivered repeatedly ( Full name of day with capital first letter )
     * @param delivery Timestamp of the time of the weekDay the order is delivered repeatedly
     * @return boolean returns true if executed successfully with correct argument input
     */
    //TODO FIX
    public boolean addOrderContent(String weekDay, Timestamp delivery) {
        if(weekDay != null){
            for (int i = 0; i<content.size();i++){
                if(content.getElementAt(i).getDeliveryDay().equals(weekDay)){
                    return false;
                }
            }
            content.addElement(new OrderContent(weekDay, delivery));
            return true;
        }
        return false;
    }

    /**
     *Method removeOrderContent
     * removes an ordercontent thad is added on a given day
     * @param weekDay String of day of week, Capital first letter.
     * @return boolean, if successfully removed; true
     */
    public boolean removeOrderContent(String weekDay){
        for (int i = 0; i<content.size(); i++){
            if(content.get(i).getDeliveryDay().equals(weekDay)){
                content.removeElementAt(i);
                return true;
            }
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
        String output = "<b>Order created:</b> "+ getOrderDate().toString().substring(0,16)+"<br>";
        if(getStartDate() != null){
            output += "<b>Activation date:</b> "+ this.getStartDate().toString().substring(0,11)+"<br>";
        }
        if(getEndDate() != null){
            output += "<b>Termination date:</b> "+ this.getEndDate().toString().substring(0,11)+"<br>";
        }
        if(this.content != null){
            output+= "<b>Days:</b><br>";
            for (int i = 0; i<content.size(); i++){
                output +=content.getElementAt(i).toString();
            }
		}
        return output;
    }
}
