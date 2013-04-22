package procatering;

import database.Database;

public class Employee extends Person {
	private final String DOB;
	private String type;
	database.Database db;

	public Employee(String fn, String ln, String phone, String mail, int pCode, String type, String birth) {
		super(fn, ln, phone, mail, pCode);
		this.type = type.toUpperCase();
		db = new database.Database();
		DOB = birth;
	}

	/**
	 * Method creates a new employee object with data found in the database on given <i>employeeId</i>
	 * @param employeeId an integer object that contains the employee id.
	 * @return an employee object with data from the database. If no information found, the method returns <i>null</i>.
	 * @author Jørgen Lien Sellæg
	 */
	public static Employee getEmployee(Integer employeeId) {
		if(employeeId == null || employeeId <= 0) {
			return null;
		}
		return Database.getEmployee(employeeId);
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

	// TODO:Lag en metode som finner customer... metoden skal sende informasjon vidre til Database db og bruke en metode der som gjør jobben.

	/**
	 * addCustomer uses a db object and adds a new customer to the database. This metode will turn all first letters in fn and ln to uppercase
	 *
	 * @param adr
	 * @param birth
	 * @param fn
	 * @param ln
	 * @param phone
	 * @param mail
	 * @return a boolean. if true it has sucsessfully added a new customer to the database, else it will return false.
	 */
	public boolean addCustomer(String adr, String birth, String fn, String ln, String phone, String mail) {
//		String cleanFN = fn.toUpperCase();
//		String cleanLN = ln.toUpperCase();
//		fn = Helper.capitalFirst(fn);
//		if (db.addCustomer(new Customer(adr, birth, fn, ln, phone, mail))) {
//			return true;
//		}
		return false;
	}

	/**
	 * addDish uses a Database object to add a new dish to the database. this metode will make the first letter in name to uppercase.
	 *
	 * @param name
	 * @param sellPrice
	 * @param cost
	 * @return a boolean. true if sucsessfully added, else it will return false.
	 */
	public boolean addDish(String name, double sellPrice, double cost) {
//		name = capitalFirst(name);  // skal bruke firstLetterToUppare metode fra Helper classen
//		if (db.addDish(name, sellPrice, cost)) {
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

	/**
	 * set type variable to the parameter type
	 *
	 * @param type String object
	 */
	public void setType(String type) {
		this.type = type.toUpperCase();
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
}