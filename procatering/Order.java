package procatering;

import database.Database;

import javax.swing.*;
import java.sql.Timestamp;

/**
 * Class Order creates an object of OrderContent and are beeing used for a singel order insted of subscription order. <br><br>
 * <dl>
 * <dt>Constructors:</dt>
 * <dd>- int customer_id, int employee_id, String status, Timestamp creationTime</dd>
 * <dd>- int order_id, int customer_id, int employee_id, String status, Timestamp creationTime, DefaultListModel<OrderContent> contentList</dd>
 * <dd>- int customer_id, int employee_id, String status</dd>
 * <dd>- Order o</dd>
 * </dl>
 * <br> The String status should be one of these values (Active, Completed, Cancelled or Pending)<br>
 * The DefaultListModel should include one delivery for each object
 *
 * @author Team 17
 */
public class Order {

	private int customerId;
	private int employeeId;
	private String status;      
	private Timestamp creationTime;
	private DefaultListModel<OrderContent> ordercontent; 
	private int orderId;

	/**
	 * This constructor do <b>not</b> initialize orderId
	 *
	 * @param customer_id The id of the Customer
	 * @param employee_id The id of the Employee
	 * @param status      The initial status of the Order.
	 */
	public Order(int customer_id, int employee_id, String status, Timestamp creationTime) {
		customerId = customer_id;
		employeeId = employee_id;
		this.status = status;
		this.creationTime = creationTime;
		ordercontent = new DefaultListModel<>();
	}
        /**
         * This constructor checks if contentList with OrderContent equals null, if not it will copy each object and add them into orderconten
         * @param order_id
         * @param customer_id
         * @param employee_id
         * @param status
         * @param creationTime
         * @param contentList 
         */
	public Order(int order_id, int customer_id, int employee_id, String status, Timestamp creationTime, DefaultListModel<OrderContent> contentList) {
		ordercontent = new DefaultListModel<>();
		customerId = customer_id;
		employeeId = employee_id;
		this.status = status;
		this.creationTime = creationTime;
		if (contentList != null) {
			for (int i = 0; i < contentList.size(); i++) {
				this.ordercontent.addElement(contentList.get(i));
			}
		}
		System.out.println("Order constructor: contentlist == null");
		// ordercontent = contentList;
		orderId = order_id;
	}

        /**
         * This constructor do <b>not</b> initialize orderId
         * @param customer_id
         * @param employee_id
         * @param status 
         */
	public Order(int customer_id, int employee_id, String status) {
		customerId = customer_id;
		employeeId = employee_id;
		this.status = status;
		this.creationTime = getCurrentDate();
		ordercontent = new DefaultListModel();
	}


        /**
         * Standard copy constructor which only Standard copy constructor creationTime and ordercontent
         * @param o  Order object
         */
	public Order(Order o) {
		this(o.getCustomerId(), o.getEmployeeId(), o.getStatus(), o.getOrderDate());
		this.creationTime = o.getOrderDate();
		this.ordercontent = o.getOrderContent();
	}

        /**
         * 
         * @return an int value of employeeId
         */
	public int getEmployeeId() {
		return employeeId;
	}
        /**
         * 
         * @return an int value of customerId
         */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Adds a dish to the order content list within the Order
	 *
	 * @param dishName Dish object that are to be added
	 * @param quantity The amount of dishes that is to be added
	 * @param index    which OrderContent object in the DefaultListModel that the Dish object is inserted into.
	 * @return boolean true for successful insertion; else false
	 */
	public boolean addDish(Dish dishName, int quantity, int index) {
		if (ordercontent.getElementAt(index).addDish(dishName, quantity)) {
			return true;
		}
		return false;
	}

	/**
	 * Get the current Time
	 * @return a current Timestamp
	 */
	public Timestamp getCurrentDate() {
		java.util.Date time = new java.util.Date();
		Timestamp date = new Timestamp(time.getTime());
		return date;
	}

        /**
         * Find the time an order have been created
         * @return a Timestamp value of creation time
         * @deprecated
         * @see procatering.Order.getCreationTime()
         */
	@Deprecated
	public Timestamp getOrderDate() {
		return creationTime;
	}
        /**
         * Find the time an order have been created
         * @return a Timestamp value
         */
	public Timestamp getCreationTime() {
		return creationTime;
	}
        /**
         * 
         * @return int value of orderId
         */
	public int getOrderId() {
		return orderId;
	}
        /**
         * 
         * @return a String value of status
         */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of an order.
	 * Available statuses for Order: Active, Completed, Cancelled or Pending
	 * @param status the status for the order.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 *
	 * @return a DefaultListModel<OrderContent> with the orderContent of the order ( Dishes, deliveryDate and time )
	 */
	public DefaultListModel<OrderContent> getOrderContent() {
		return ordercontent;
	}


	/**
	 * Creates an OrderContent object for adding of dishes, and adds it to the DefaultListModel<orderContent>
	 *
	 * @param delivery Timestamp with the date and time for delivery.
	 */
	public boolean addOrderContent(Timestamp delivery) {
		if (delivery != null) {
			ordercontent.addElement(new OrderContent(delivery));
			return true;
		}
		return false;
	}
        //TODO UNUSED
	public void addDB() {
		database.Database db = new database.Database();
	}

	/**
	 *
	 * @return object shows as String with the order created date/time and the content of the order sorted.
	 */
	@Override
	public String toString() {
		return "Order id #" + getOrderId() + " for " + getCustomer(getCustomerId()).toString();
		//getOrderContent().get(0).getDeliveryDate().toString().substring(0,16);
	}
        
        /**
         * Find one spesific customer by customer id
         * @param customerId customers id 
         * @return a Customer object; or null
         */
	private Customer getCustomer(int customerId) {
		Database db = new Database();
		return db.getCustomer(customerId);
	}

	/**
	 *
	 * @return a html document representation of the object.
	 */
	public String toHtml() {
		String output = "<html>";
		output += "<b>Order created: </b><i>" + creationTime.toString().substring(0, 16) + "</i>";
		output += "<table>";
		for (int i = 0; i < ordercontent.size(); i++) {
			output += ordercontent.get(i).toHtml();
		}
		return output;
	}
        /**
         * Create an receipt for Order that are customized for html
         * @return string value
         */
	public String confirmToHtml() {
		String output = "Receipt for Order<br>";
		for (int i = 0; i < ordercontent.size(); i++) {
			output += ordercontent.get(i).toHtml();
		}

		return output;
	}

        /**
         *  Find total sum for an order
         * @return double [] with two exact equal numbers
         */
	public double[] getSum() {
		Double total = 0.0;
		for (int i = 0; i < ordercontent.size(); i++) {
			DefaultListModel<Dish> d = ordercontent.get(i).getDishes();
			for (int j = 0; j < d.size(); j++) {
				total += d.get(i).getPrice();
			}
		}
		Double sum = total;

		return new double[]{sum, total};
	}

}

