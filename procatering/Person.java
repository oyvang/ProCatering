package procatering;

import database.Database;

/**
 * Person include get and set method's for: <br> - DOB (Date of Birth), firstName, lastName, phoneNumber, email. <br>
 * - all of these are a object of the type String.<br><br>
 * The class constructor require (String, String, String, String) and are going to fill the variables (firstName,lastName,phoneNumber,email)
 *
 * @author TEAM 17
 */

public abstract class Person {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private int postalCode;

	/**
	 * Person constructor except all parameters have been checked and is correct before trying to create an object of person.
	 *
	 * @param fn    String
	 * @param ln    String
	 * @param phone String
	 * @param mail  String
	 * @param pCode String postal code
	 */
	public Person(String fn, String ln, String phone, String mail, int pCode) {
		firstName = fn;
		lastName = ln;
		phoneNumber = phone;
		email = mail;
		postalCode = pCode;
	}

	/**
	 * firstName are of object type String
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set firstName variable to equal the parameter firstName
	 * @param firstName String object
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * lastName are of object type String
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set lastName variable to equal the parameter lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * phoneNumber are of object type String
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * set phoneNumber variable to equal the parameter phoneNumber
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * email are of object type String
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * set email variable to equal the parameter email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return returns the postal code
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * toString is of the type String
	 * @return class information: <br>DOB, firstName, lastName, phoneNumber, email
	 */
	@Override
	public String toString() {
		return "Person{ firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + '}';
	}
}

