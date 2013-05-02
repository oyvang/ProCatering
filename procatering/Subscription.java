package procatering;

import database.Database;
import java.sql.Timestamp;
import javax.swing.DefaultListModel;


/**
 * Class Subscription are for a subscription order and uses an opbject from OrderContent
 * <dl>
 *  <dt>Constructors:</dt>
 *      <dd>- int e_id, int c_id</dd>
 *      <dd>- int order_id,int e_id, int c_id, Timestamp created, DefaultListModel<OrderContent> contentList, String status</dd>
 *      <dd>- Subscription s</dd>
 * </dl>
 * 
 * The variable status should have the Straing value: Active, Completed, Pending or Cancelled
 * @author Team 17
 */
    // TODO: getSubscriptions checks startDate, if started; activate.
public class Subscription {
    private Timestamp startDate;
    private Timestamp endDate;
    private Timestamp orderDate;
    private DefaultListModel<OrderContent> content;
    private int employeeId;
    private int customerId;
    private String status;     
    private int OrderId;

    /**
     * This constructor should <b>only</b> be used before the order have been added to the database. This is because the variable OrderId are <b>NOT</b> assigned with this constructor and if an object with this constructor use the methode getOrderId() you will get an exception.
     * <br><br>
     * orderDate equal current Timestamp.<br>
     * content = new DefaultListModel()<br>
     * status = "Pending" 
     * @param e_id input for employee id
     * @param c_id input for customer id
     * @deprecated 
     */
    //TODO fix check for what status it should be and change the documentation afterwards.
    public Subscription(int e_id, int c_id){
        java.util.Date time= new java.util.Date();
        orderDate = new Timestamp(time.getTime());
        this.content = new DefaultListModel<>();
        employeeId = e_id;
        customerId = c_id;
        status = "Pending"; 
    }

    /**
     * Constructor, creates an object of Subscription<br>
     * orderDate equal current Timestamp.<br>
     * content = new DefaultListModel()<br>
     * status = "Pending" 
     * @param order_id input for order id
     * @param e_id input for employee id
     * @param c_id input for customer id
     */
    public Subscription(int order_id,int e_id, int c_id, Timestamp created, DefaultListModel<OrderContent> contentList, String status){
        OrderId = order_id;
        orderDate = created;
        this.content = contentList;
        employeeId = e_id;
        customerId = c_id;
        status = "Pending";
    }
    /**
     * This constructor do <b>NOT</b> assigned the variable OrderId and will give an exception if the metode getOrderId() are used. 
     * Simple copy-constructor<br>
     * But set the <b>status</b> variable to equal <i>"Pending"</i> witch is the default value.
     * @param s Subscription object
     * @deprecated 
     */
    public Subscription(Subscription s){
        orderDate = s.getOrderDate();
        content = s.getContent();
        employeeId = s.getEmployeeId();
        customerId = s.getCustomerId();
        status = "Pending";
        startDate = s.getStartDate();
        endDate = s.getEndDate();
    }
    /**
     * 
     * @return String object with status; Default: "Pending"
     */
    public String getStatus() {
        return status;
    }
    /**
     * 
     * @return int with the given orderId,
     */
    public int getOrderId() {
        return OrderId;
    }

    /**
     * 
     * @return Timestamp with the orderDate; Default current timestamp when object are created
     */
    public Timestamp getOrderDate() {
        return orderDate;
    }

    /**
     * @return int with the employee id
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @return int with the customer id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @return Timestamp with the date the subscription is to be activated, or null if not assigned
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * @return Timestamp with the date when the subscription is terminated, or null if not assigned
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * @return DefaultListModel<OrderContent> the list of the orderContent for the subscription
     */
    public DefaultListModel<OrderContent> getContent() {
        return content;
    }

    /**
     * set a value to the variable startDate
     * @param start Timestamp containing the date that the subscription is activated.
     */
    public void addStartDate(Timestamp start){
        startDate = start;
    }

    /**
     * Set a value to the variable endDate
     * @param end Timestamp containing the date that the subscription is terminated
     */
    public void addEndDate(Timestamp end){
        endDate = end;
    }

    /**
     * Adds an OrderContent object to the list of ordercontent <i>(DefaultListModel content)</i>, the OrderContent do not include any Dish objects.
     * @param weekDay String of the given week day that should be added.
     * @param delivery Timestamp of the time of the weekDay the order is delivered repeatedly
     * @return boolean returns true if executed successfully with correct argument input; returns false if weekDay is allready added to content or if weekDay equals null
     */
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
     * Removes an ordercontent that is added on a given day
     * @param weekDay the weekday that you wish to be removed
     * @return boolean true if removed from content; else false
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
     * Adds a Dish object to the DefaultListModel content
     * @param dishName Name of the dish that should be added.
     * @param quantity The ammount of the current dish that should be added to an order
     * @param index Which OrderConent object the dish is added to ( index of content <i>DefaultListModel</i> )
     * @return boolean  true if added successfully; else false
     */
    public boolean addDish(Dish dishName, int quantity, int index){
        if(content.getElementAt(index).addDish(dishName, quantity)){
            return true;
        }
        return false;
    }
    /**
     * Overview of the subscription for presentation in gui
     * @return String of the subscription object<br><br>
     * "Order id #"+ getOrderId()+" for "+getCustomer(getCustomerId()).toString()
     */
    public String toString(){
            return "Order id #"+ getOrderId()+" for "+getCustomer(getCustomerId()).toString();
            //getOrderContent().get(0).getDeliveryDate().toString().substring(0,16);
        }
    /**
     * Find one spesific custumer by the given customer id
     * @param customerId The customers id
     * @return a Customer object if found in the database; or null.
     */
    private Customer getCustomer(int customerId) {
        Database db = new Database();
        return db.getCustomer(customerId);
    }
    /**
     * Used for the receipt part of the gui. 
     * @return a String which is customized for html code; if no dish is added it will return:<br>
     * "Receipt for Order"<br>
     * "Day of the week that are added allready"
     */
    public String confirmToHtml(){
        String output = "Receipt for Order<br>";
        for (int i = 0; i < content.size(); i++) {
            output += content.get(i).toHtml();
        }

        return output;
    }
    /**
     * Uses for order overview in the GUI when creating an order.
     * @return a String which is customized for html
     */
    
    public String toHtml() {
        String output = "<html>";
        output += "<b>Order created: </b><i>" + orderDate.toString().substring(0, 16) + "</i><br>";
        output += "";
        if(getStartDate() != null){
            output+="<b>Activation date: </b>"+getStartDate().toString().substring(0, 16)+"<br>";
        }
        if(getEndDate() != null){
            output+="<b>Termination date: </b>"+getEndDate().toString().substring(0, 16)+"<br>";
        }
        for (int i = 0; i < content.size(); i++) {
            output +=content.get(i).toHtml();
        }
        return output;
    }
}
