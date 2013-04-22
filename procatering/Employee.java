package procatering;
import database.Database;

public class Employee extends Person {
	private final String dob;
	private String type;
	private Database db;

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
	public boolean getEmployee(int id) {
		if (db.getEmployee(id) != null) {
			return true;
		}
		return false;
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
}