package procatering;

import database.Database;

import javax.swing.*;

/**
 * @author Ted
 */
public class Customer extends Person{
    private String address;
    private int customerID;
    private int corporateNum;
    private String corporateName;

	/**
	 * Customer object. Extended from Person.
	 * @param adr The customers address
	 * @param fn The customers firstname
	 * @param ln The customers lastname
	 * @param phone The customers phone number
	 * @param mail The customers email address
	 * @param pCode The customers postal code
	 * @author Jørgen Lien Sellæg
	 */
    public Customer(String adr, String fn, String ln, String phone, String mail, int pCode){
        super(fn,  ln,  phone,  mail, pCode);
        this.address = adr;
    }
	/**
	 * @author Team17
	 * //TODO legg til dokumentasjon
	 */
    public Customer(String adr, String fn, String ln, String phone, String mail, int pCode, int cid){
        super( fn,  ln,  phone,  mail, pCode);
        this.address = adr;
        customerID = cid;
    }
	/**
	 * Regular get method for address.
	 * Returns a string value of the address.
	 */
    public String getAddress() {
        return address;
    }
	/**
	 * Regular set method for the address
	 * Assigns a new string value to the address.
	 */
    public void setAddress(String address) {
        this.address = address;
    }

	/**
	 * Method findCustomer returns a DefaltListModel containing all the customers in the database matching search criteria.
	 * @param search
	 * @return a DefaultListModel<Customer> object.
	 */
	public static DefaultListModel<Customer> findCustomer(String search){
		Database db = new Database();
		return db.findCustomer(search);
	}
    public int getCorporateNum() {
        return corporateNum;
    }

    public void setCorporateNum(int corporateNum) {
        this.corporateNum = corporateNum;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
    
	public boolean addCustomer(Customer customer) {
		Database db = new Database();
		if(customer != null)
			return db.addCustomer(customer);
		return false;
	}

	@Override
	/**
	 * toString returns a string representation of the customer object.
	 */
	public String toString() {
		return getLastName()+", "+getFirstName();
	}
}
