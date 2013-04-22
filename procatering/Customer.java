package procatering;

import database.Database;

import javax.swing.*;

/**
 * @author Ted
 */
public class Customer extends Person{
    private String address;
    private int customerID;

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
	 * @author Team17
	 * //TODO legg til dokumentasjon
	 */
    public String getAddress() {
        return address;
    }
	/**
	 * @author Team17
	 * //TODO legg til dokumentasjon
	 */
    public void setAddress(String address) {
        this.address = address;
    }

	public static DefaultListModel<Customer> findCustomer(String search){
		Database db = new Database();
		return db.findCustomer(search);
	}

    @Override
    public String toString() {
        return getLastName()+", "+getFirstName();
    }

	public boolean addCustomer(Customer customer) {
		Database db = new Database();
		if(customer != null)
			return db.addCustomer(customer);
		return false;
	}
}
