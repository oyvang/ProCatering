package procatering;
import database.Database;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.DefaultListModel;

public class Employee extends Person {
	private int employeeId;
        private final String dob;
	private String type;
	private Database db;
        private Order order;
        private Subscription subscription;

        public Employee(int empId, String type, String fn, String ln, String phone, int pCode, String dob, String mail) {
           //Person(String fn, String ln, String phone, String mail, int pCode)
           super(fn, ln, phone, mail, pCode);
           this.type = type.toUpperCase();
           this.dob = dob;
           this.employeeId = empId;
           db = new Database();
	}
        
        public Employee(String type, String fn, String ln, String phone, int pCode, String dob, String mail) {
		//Person(String fn, String ln, String phone, String mail, int pCode)
		super(fn, ln, phone, mail, pCode);
		this.type = type.toUpperCase();
		this.dob = dob;
		db = new Database();
	}
	public Employee(Employee e){
		//Person(String fn, String ln, String phone, String mail, int pCode)
		super(e.getFirstName(),e.getLastName(),e.getPhoneNumber(),e.getEmail(),e.getPostalCode());
		dob = e.getDob();
		type = e.getType();
	}

	/**
	 * Method creates a new employee object with data found in the database on given <i>employeeId</i>
	 * @param employeeId an integer object that contains the employee id.
	 * @return an employee object with data from the database. If no information found, the method returns <i>null</i>.
	 * @author Jørgen Lien Sellæg
	 */
	public static Employee getEmployee(Integer employeeId) {
		Database db = new Database();
		if (employeeId == null || employeeId <= 0) {
			return null;
		}
		return new Employee(db.getEmployee(employeeId));
	}
	
	/**
	 * Method addEmployee uses a Database object to add a new Employee to the database
	 *
	 * @param type
	 * @param birth
	 * @param fn
	 * @param ln
	 * @param phone
	 * @param mail
	 * @return a boolean. true if successfully added a new employee, else it will return false;
	 */
	public boolean addEmployee(String type, String birth, String fn, String ln, String phone, String mail) {
//		String cleanFN = fn.toUpperCase();
//		String cleanLN = ln.toUpperCase();
//		fn = capitalFirst(fn);
//		if (db.addEmployee(type, birth, fn, ln, cleanFN, cleanLN, phone, mail)) {
//			return true;
//		}
		return false;
	}

	/**
	 * updateDishPrices uses a Database object to update both price and cost of an existing dish in the database.
	 *
	 * @param name
	 * @param newPrice
	 * @param cost
	 * @return a boolean. true if sucsessfully updatet, else it will return false.
	 */
	public boolean updateDishPrices(String name, double newPrice, double cost) {
//		name = capitalFirst(name);
//		if (db.updateDishPrices(name, newPrice, cost)) {
//			return true;
//		}
		return false;
	}

	/**
	 * type are of object type String
	 *
	 * @return type
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type.toUpperCase();
	}

	public String getDob() {
		return dob;
	}

        public int getEmployeeId() {
            return employeeId;
        }
	public boolean addEmployee(String type, String fn, String ln, String phone, int pCode, String dob, String mail, String pw) {
		fn = Helper.capitalFirst(fn);
		if (999 < pCode && pCode > 10000) {
			if (db.addEmployee(new Employee(type, fn, ln, phone, pCode, dob, mail), pw)) {
				return true;

				//SJEKK  999 < POSTALCODE >10000
			}
		}
		return false;
	}

	public boolean updateEmployee(Employee input, int id) {
		if (db.updateEmployee(input, id)) {
			return true;
		}
		return false;
	}

	public boolean changeEmployeePassword(String input, int id) {
		if (db.changeEmployeePassword(input, id)) {
			return true;
		}
		return false;
	}

	/**
	 * toString are of the object String
	 *
	 * @return class information and Person class toString: <br>
	 *         returns: type + Person toString
	 */
	@Override
	public String toString() {
		return "Employee{" + "type=" + type + " " + super.toString() + '}';
	}
        
        /* TODO:
         * addOrder ok
         * order.addContent ok
         * addSubscription
         * subscription.addContent
         */     
        public boolean createOrder(int c_id){
            if(c_id > 0){
                order = new Order(c_id, this.getEmployeeId(), "Active");
                return true;
            }
            return false;
        }
        public boolean addOrderContent(Timestamp deliverDate){
            if(deliverDate.after(order.getCurrentDate())){
                if(order.addOrderContent(deliverDate)){
                    return true;
                }
                return false;
            }
            return false;
        }
        
        public boolean addOrderDishes(Dish dish, int qty, int index){
            if(dish != null){
                order.addDish(dish, qty, index);
                return true;
            }
            return false;
        }
        
        public boolean createSubscription(int c_id){
            if(c_id > 0){
                subscription = new Subscription(c_id, this.getEmployeeId());
                return true;
            }
            return false;
        }
        public boolean addSubscriptionStartDate(Timestamp startDate){
            if(startDate != null && startDate.after(subscription.getOrderDate())){
                subscription.addStartDate(startDate);
                return true;
            }
            return false;
        }
        public boolean addSubscriptionEndDate(Timestamp endDate){
            if(endDate != null && endDate.after(subscription.getStartDate())){
                subscription.addEndDate(endDate);
                return true;
            }
            return false;
        }
        public boolean addSubscriptionContent( String weekday, Timestamp deliveryTime){
            if(weekday != null && deliveryTime.after(subscription.getOrderDate())){
                 subscription.addOrderContent(weekday, deliveryTime);
                 return true;
            }
            return false;
        }
        
        public boolean addSubscription(){
            DefaultListModel<OrderContent> check1 = subscription.getContent();
            Timestamp check2 = subscription.getStartDate();
            if(check1 != null && check1.size()>0 && check2 != null){
                if(db.addSubscription(new Subscription(subscription))){
                    subscription = null;
                    return true;
                }
                return false;
            }
            return false;
        }
}