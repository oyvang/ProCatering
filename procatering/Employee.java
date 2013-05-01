package procatering;

import database.Database;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Class Employee
 * The active class of proCatering.
 * @author Team17
 */
public class Employee extends Person {
	private int employeeId;
	private String dob;
	private Database db;
	private Order order;
	private Subscription subscription;

    /**
     * Constructor, creates an object of Employee
     * Adds the parameters to attributes
     * Creates an object of Database
     * @param empId int employee id
     * @param fn String first name
     * @param ln String last name
     * @param phone String phone number
     * @param pCode int postCode (4digits)
     * @param dob String Date of Birth ( dd/mm/yyyy ) TODO make sure the format is correct.
     * @param mail String email
     */
    public Employee(int empId, String fn, String ln, String phone, int pCode, String dob, String mail) {
		super(fn, ln, phone, mail, pCode);
		this.dob = dob;
		this.employeeId = empId;
		db = new Database();
	}

    /**
     * Constructor, creates an object of Employee without an employee id. (needs to be inserted to DB for an id.)
     * Adds the parameters to attributes
     * Creates an object of Database
     * @param fn String first name
     * @param ln String last name
     * @param phone String phone number
     * @param pCode int postCode (4digits)
     * @param dob String Date of Birth ( dd/mm/yyyy ) TODO make sure the format is correct.
     * @param mail String email
     */
	public Employee(String fn, String ln, String phone, int pCode, String dob, String mail) {
		super(fn, ln, phone, mail, pCode);
		this.dob = dob;
		db = new Database();
                employeeId = -1;
	}

    /**
     * Simple copy constructor. It also checks if the employee is already in the database.
     * @param e is the Employee object to be copied
     */
	public Employee(Employee e) {
		super(e.getFirstName(), e.getLastName(), e.getPhoneNumber(), e.getEmail(), e.getPostalCode());
		dob = e.getDob();
		db = new Database();
                if(e.getEmployeeId()>-1){
                    employeeId = e.getEmployeeId();
                }else{
                employeeId = -1;
                }
	}

	/**
	 * Method getEmployee
     * Creates a new employee object with data found in the database on a given <i>employeeId</i>
	 * @param employeeId an integer object that contains the employee id.
	 * @return an employee object with data from the database. If no information found, the method returns <i>null</i>.
	 */
	public static Employee getEmployee(Integer employeeId) {
        Database db = new Database();
		if (employeeId == null || employeeId < 0) {
			return null;
		}
        if(db.getEmployee(employeeId)!=null){
        	return new Employee(db.getEmployee(employeeId));
        }
		return null;
	}

    /**
     * Method getSubscription
     * @return the subscription object attribute
     */
    public Subscription getSubscription(){
        return subscription;
    }

    /**
     * Method getOrder
     * @return the order object attribute
     */
	public Order getOrder() {
		return order;
	}
	/**
	 * Adds an employee to the database
	 *
	 * @param fn    String object first name
	 * @param ln    String object last name
	 * @param phone String object phone number
	 * @param pCode Integer post code
	 * @param dob   String object Date of Birth
	 * @param mail  String object eMail
	 * @param pw    String object password
	 * @return true if successfully added, else it will return false
	 */
	public boolean addEmployee(String fn, String ln, String phone, int pCode, String dob, String mail, String pw) {
		fn = Helper.capitalFirst(fn);
		return !db.employeeExist(new Employee(fn, ln, phone, pCode, dob, mail)) && db.addEmployee(new Employee(fn, ln, phone, pCode, dob, mail), pw);
	}

	/**
	 * Edits a dish to send in a new dish object and the name of the old dish
	 * @param dish Dish object
	 * @param newPrice the new price
	 * @param newCost the new cost
	 * @return true if the database update is successful, else false.
	 */
	public boolean editDish(Dish dish, double newPrice, double newCost) {
                dish.setPrice(newPrice);
                dish.setCost(newCost);
		return db.editDish(dish);
	}

    /**
     * Finds the dish with the given name in the database
     * @param name The search name
     * @return an object of the dish
     */
    public Dish getDish(String name){
        return db.getDish(name);
    }

	/**
	 * Standard get method for date of birth
	 * @return a string with the date
	 */
	public String getDob() {
		return dob;
	}

    /**
     * Standard get method for employee ID
     * @return a int with the employee ID
     */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Edit a Employee by sending inn a new Employee object. The employee object requires an employee ID
	 * @param input An employee object
	 * @return true if the update is successful, false if not
	 */
	public boolean updateEmployee(Employee input) {
		return db.updateEmployee(input);
	}

    /**
     * Changes an employees password
     * @param input Is a string with the new password
     * @param id Is the ID of the given employee
     * @return true if the password update is successful, false if not
     */
	public boolean changeEmployeePassword(String input, int id) {
		if(input == null || id > -1){
                    if(db.getEmployee(id)==null){
                        return false;
                    }
                   
                    else if (db.changeEmployeePassword(input, id)) {
				return true;
			}
                }
		return false;
	}

    /**
     * Returns a DefaultListModel with the dish category specified.
     * @param id a category id.
     * @return a DefaultListModel containing all the dishes in the specified category.
     */
    public DefaultListModel<Dish> getDishes(int id){
    	return db.getDishes(id);
    }

	/**
	 * toString returns a string representation of the employee object
	 * @return the last name and first name of the employee
	 */
	@Override
	public String toString() {
		return getLastName()+", "+getFirstName();
	}

    /**
     * Creates an order without any orderContent objects
     * Adds the employee id to the order, and sets the status to "Active"
     * @param c_id Is the customer id
     * @return boolean, returns true if executed successfully
     */
	public boolean createOrder(int c_id) {
		if (c_id > 0) {
			order = new Order(c_id, this.getEmployeeId(), "Active");
			return true;
		}
		return false;
	}

    /**
     * Adds an orderContent object to the Order object's orderContent List.
     * @param deliverDate Timestamp containing the date and time the order is to be delivered.
     * @return boolean, returns true if executed successfully
     */
	public boolean addOrderContent(Timestamp deliverDate) {
		if (deliverDate.after(order.getCurrentDate())) {
			return order.addOrderContent(deliverDate);
		}
		return false;
	}

    /**
     * Adds a dish within: The Order object's orderContentLists' specified object.
     * @param dish Dish object that represents the dish that is to be added
     * @param qty The number of the given dish that is to be added
     * @param index Which OrderContent object within the Order objects content list that is affected.
     * @return boolean, returns true if executed successfully
     */
	public boolean addOrderDishes(Dish dish, int qty, int index) {
		if (dish != null) {
			order.addDish(dish, qty, index);
			return true;
		}
		return false;
	}

    /**
     * Checks if the order contains the needed attributes
     * Adds the order to the database.
     * if successfully added, sets the order object to null.
     * @return boolean, returns true if executed successfully
     */
    public boolean addOrder() {     //TODO Check if we need to control other contents
        DefaultListModel<OrderContent> check = order.getOrderContent();
        if (check != null && check.size() > 0 ) {
            if (db.addOrder(new Order(order))) {
                order = null;
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Initiates the Subscription object
     * @param c_id customer id the Subscription is ordered to.
     * @return boolean, returns true if executed successfully
     */
	public boolean createSubscription(int c_id) {
		if (c_id > 0) {
			subscription = new Subscription(this.getEmployeeId(),c_id );
			return true;
		}
		return false;
	}

    /**
     * Adds the date of activation of the subscription.
     * @param startDate Timestamp of the date of activation.
     * @return boolean, returns true if executed successfully
     */
	public boolean addSubscriptionStartDate(Timestamp startDate) {
		if (startDate != null && startDate.after(subscription.getOrderDate())) {
			subscription.addStartDate(startDate);
			return true;
		}
		return false;
	}

    /**
     * Adds a date for termination of the subscription
     * @param endDate Timestamp of the date of termination
     * @return boolean, returns true if executed successfully
     */
	public boolean addSubscriptionEndDate(Timestamp endDate) {
		if (endDate != null && endDate.after(subscription.getStartDate())) {
			subscription.addEndDate(endDate);
			return true;
		}
		return false;
	}

        /**
         * Adds a new dish to the database, it will also add dish and category names that are not in the database.
         * @param dish Dish object
         * @param catNames DefaultListModel<String> (DefaultListModel is because the dish can be in more then one category)
         * @param ingredient DefaultListModel<String>
         * @return true if successfully added, else it will return false.
         */
        public boolean addNewDish(Dish dish, DefaultListModel<String> catNames, DefaultListModel<String> ingredient) {
            if(dish == null || catNames.isEmpty() || ingredient.isEmpty()){
                return false;
            }
            int en = 0;
            int to = 0;
            try{
                if(!db.dishExist(Helper.capitalFirst(dish.getName()))) {
                    for (int i = 0; i < catNames.getSize(); i++) {
                        if(!db.cateogryExist(Helper.capitalFirst(catNames.get(i)))){
                            db.addCategory(Helper.capitalFirst(catNames.get(i)));
                        }
                    }
                    for (int i = 0; i < ingredient.getSize(); i++) {
                        if(!db.ingredientExist(Helper.capitalFirst(ingredient.get(i)))){
                            db.addIngredient(Helper.capitalFirst(ingredient.get(i)));
                        }
                    }
                    
                    if(db.addDish(dish)){
                        for (int i = 0; i < catNames.getSize(); i++) {
                            db.insertDishCat(Helper.capitalFirst(dish.getName()), Helper.capitalFirst(catNames.get(i)));
                            en++;
                            
                        }
                        for (int i = 0; i < ingredient.getSize(); i++) {
                            db.insertDishIngredient(Helper.capitalFirst(dish.getName()), Helper.capitalFirst(ingredient.get(i)));
                            to++;
                        }
						return en == catNames.getSize() && to == ingredient.getSize();
					}
                }
            }catch (SQLException ePrepState) {
                return false;
                
            }
            return false;
        }

    /**
     * Adds order content to a subscription with given delivery day and time. It also checks if the order is an subscription.
     * @param weekday The name of the day (if null the order is not a subscription)
     * @param deliveryTime The time of the day the subscription shall be delivered
     * @return true if successfully added, false if either the order is not a subscription or the order content was not successfully added
     */
	public boolean addSubscriptionContent(String weekday, Timestamp deliveryTime) {
		if (weekday != null && deliveryTime.after(subscription.getOrderDate())) {
			subscription.addOrderContent(weekday, deliveryTime);
			return true;
		}
		return false;
	}

    /**
     * Checks if the subscription contains the needed attributes
     * Adds the subscription to the database.
     * @return boolean, returns true if executed successfully
     */
    public boolean addSubscription() {     //TODO Check if we need to control other contents
		DefaultListModel<OrderContent> check1 = subscription.getContent();
		Timestamp check2 = subscription.getStartDate();
		if (check1 != null && check1.size() > 0 && check2 != null) {
			if (db.addSubscription(new Subscription(subscription))) {
				subscription = null;
				return true;
			}
            System.out.println("Something weent wrong in the insert to db method or query...");
            return false;
		}
        System.out.println("Subscription incomplete...");
        return false;
	}
    public double sumOrder(double discount){
        System.out.println("BETA"); //TODO make it happen
        return 0.00;
    }

    /**
     * Gets all the categories from the database and order them by name
     * @return a DefaultListModel with all the categories
     */
    public DefaultListModel<Category> getCategories(){
            return db.getCategories();
    }

    /**
     * Sets the status of the dish with the given name to 0(sets it to inactive)
     * @param name of the desired dish
     * @return true if the update is successful, false if not
     */
    public boolean hideDish(String name){
        if(name == null){
            return false;
        }
		return db.hideDish(Helper.capitalFirst(name));
	}

    /**
     * Sets the status of the dish with the given name to 1(sets it to active)
     * @param name of the desired dish
     * @return true if the update is successful, false if not
     */
    public boolean activateDish(String name){
        if(name == null){
            return false;
        }
            return db.activateDish(Helper.capitalFirst(name));
    }

    /**
     * Checks if the employee with the given ID exists and delete it
     * @param id The employees ID number
     * @return true if successful, false if not
     */
    public boolean removeEmployee(int id){
        return db.employeeExist(db.getEmployee(id)) && db.removeEmployee(id);
    }

    /**
     * Removes a category from the database, based on the string value
     * @param name of the category that shall be removed
     * @return true if successfully, false if not
     */
    public boolean removeCategory (String name){
        if(name ==null){
            return false;
        }
        return db.removeCategory(Helper.capitalFirst(name));
    }

    /**
     * Adds a category to the database, based on the string value
     * @param name of the category
     * @return true if successful, false if not
     */
    public boolean addCatergory (String name){
        if(name == null){
            return false;
        }
        return db.addCategory(Helper.capitalFirst(name));
    }

    /**
     * Finds an order based on the customer. Searches the customer database on first name, last name, phone number and postal code
     * @param input search criteria
     * @return the orders the given customer have ordered in a DefaultListModel
     */
    public DefaultListModel findOrders(String input) {
        return db.findOrder(input);
    }

    /**
     * Gives the orders that the customer, with the given order id ,have ordered
     * @param customerID is the ID of the desired customer
     * @return the orders that match the customers ID in a DefaultListModel
     */
    public Customer getOrder(int customerID){
        if(customerID < 0){
            return null;
        }
        return db.getCustomer(customerID);
    }

    /**
     * Shows all the employees
     * @return a DefaultListModel with all the employees
     */
	public DefaultListModel<Employee> getEmployees(){
		Database db = new Database();
		return db.getEmployees();
	}

	/**
	 * Gives the orders witch is going to be delivered today
	 * @param today The timestamp to get the order.
	 * @return an ArrayList with string tables with the content of the result.
	 */
	public ArrayList<String[]> getTodayOrder(String today){
		Database db = new Database();
		return db.getTodayOrder(today);
	}

    /**
     * Returners all the orders that is not a subscription
     * @return a DefaultListModel containing all the orders in the database, returns null if nothing is found.
     */
    public DefaultListModel<Order> getOrders() {
        Database db = new Database();
        return db.getAllOrders2();
    }

    /**
     * Returners all subscriptions
     * @return a DefaultListModel containing all the subscriptions in the database, returns null if nothing is found.
     */
    public DefaultListModel<Subscription> getSubscriptions(){
        Database db = new Database();
        return db.getAllSubscriptions();
    }

    /**
     * Gives all the subscriptions that is going to be delivered today
     * @param today timestamp on the given time
     * @return an ArrayList of all the subscriptions
     */
	public ArrayList<String[]> getTodaySubscription(String today) {
		Database db = new Database();
		return db.getTodaySubscription(today);
	}

    /**
     * Finds the top 5 dishes, sorted by most sold
     * @return a DefaultListModel of the dishes
     */
	public DefaultListModel<String[]> getTopDishes(){
		Database db = new Database();
		return db.topDishes();
	}

}
