package procatering;

/**
 * Class Order
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
	private Timestamp creationTime;
	private DefaultListModel<OrderContent> ordercontent; // one delivery per object
    private int orderId;

	/**
	 * Constructor for Order.
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

    public Order(int order_id, int customer_id, int employee_id, String status, Timestamp creationTime, DefaultListModel<OrderContent> contentList) {
        ordercontent = new DefaultListModel<>();
        customerId = customer_id;
        employeeId = employee_id;
        this.status = status;
        this.creationTime = creationTime;
        if(contentList != null){
            for (int i = 0; i < contentList.size(); i++) {
                this.ordercontent.addElement(contentList.get(i));
            }
        }
        System.out.println("Order constructor: contentlist == null");
       // ordercontent = contentList;
        orderId = order_id;
    }

	/**
	 * @param customer_id The id of the Customer
	 * @param employee_id The id of the Employee
	 * @param status      The initial status of the Order.
	 */
	public Order(int customer_id, int employee_id, String status) {
		customerId = customer_id;
		employeeId = employee_id;
		this.status = status;
		this.creationTime = getCurrentDate();
		ordercontent = new DefaultListModel();
	}

	/**
	 * Standard copy constructor
	 */
	public Order(Order o) {
		this(o.getCustomerId(), o.getEmployeeId(), o.getStatus(), o.getOrderDate());
		this.creationTime = o.getOrderDate();
		this.ordercontent = o.getOrderContent();
	}


	public int getEmployeeId() {
		return employeeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Method addDish
	 * Adds a dish to the order content list within the Order
	 *
	 * @param dishName Dish object that are to be added
	 * @param quantity The amount of dishes that is to be added
	 * @param index    which OrderContent object in the DefaultListModel that the Dish object is inserted into.
	 * @return boolean, true for successful insertion.
	 */
	public boolean addDish(Dish dishName, int quantity, int index) {
		if (ordercontent.getElementAt(index).addDish(dishName, quantity)) {
			return true;
		}
		return false;
	}

	/**
	 * Method getCurrentDate
	 *
	 * @return a current Timestamp
	 */
	public Timestamp getCurrentDate() {
		java.util.Date time = new java.util.Date();
		Timestamp date = new Timestamp(time.getTime());
		return date;
	}

	/**
	 * see procatering.Order.getCreationTime();
	 *
	 */
	@Deprecated
	public Timestamp getOrderDate() {
		return creationTime;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public String getStatus() {
		return status;
	}

	/**
	 * Method setStatus
	 * Sets the status of an order.
	 *
	 * @param status the status for the order. Available statuses for Order: Active, Completed or Cancelled
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Method getOrderContent
	 *
	 * @return a DefaultListModel<OrderContent> with the orderContent of the order ( Dishes, deliveryDate and time )
	 */
	public DefaultListModel<OrderContent> getOrderContent(){
		return ordercontent;
	}


	/**
	 * Method addOrderContent
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
	//TODO: ADDISH

	public void addDB() {
		database.Database db = new database.Database();
	}

	/**
	 * Method toString
	 *
	 * @return object shows as String with the order created date/time and the content of the order sorted.
	 */
	@Override
	public String toString() {
        return getOrderContent().get(0).getDeliveryDate().toString().substring(0,16);
	}
	/** Method returns a html representation of the object.
	 * @return a html document representation of the object.
	 *
	 * */
	public String toHtml() {
		String output = "<html>";
		output += "<b>Order created: </b><i>" + creationTime.toString().substring(0, 16) + "</i>";
		output += "<table>";
		for (int i = 0; i < ordercontent.size(); i++) {
			output += ordercontent.get(i).toHtml();
		}
		return output;
	}

	public String confirmToHtml(){
		String output = "Receipt for Order<br>";
		for (int i = 0; i < ordercontent.size(); i++) {
			output += ordercontent.get(i).toHtml();
		}

		return output;
	}


	public double[] getSum(){
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

