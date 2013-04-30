package procatering;

import database.Database;

import javax.swing.*;

/**
 * Customer class contains all the information about the customer. It also opens for some queries towards the database.
 *
 * @author Ted Kristoffersen
 */
public class Customer extends Person {
    private String address;
    private int customerID;
    private int corporateNum;
    private String corporateName;
    private String note;

    /**
     * This constructor should me used when inserting a customer in the database.
     *
     * @param adr   The customers address
     * @param fn    The customers first name
     * @param ln    The customers last name
     * @param phone The customers phone number
     * @param mail  The customers email
     * @param pCode The customers postal code
     * @param note  The customers special note
     * @author Jørgen Lien Sellæg
     */
    public Customer(String adr, String fn, String ln, String phone, String mail, int pCode, String note) {
        super(fn, ln, phone, mail, pCode);
        this.address = adr;
        this.note = note;
    }

    /**
     * This constructor should me used when extracting a customer from the database.
     *
     * @param adr   The customers address
     * @param fn    The customers first name
     * @param ln    The customers last name
     * @param phone The customers phone number
     * @param mail  The customers email
     * @param pCode The customers postal code
     * @param note  The customers special note
     * @param cid   The customers id in the database.
     * @author Jørgen Lien Sellæg
     */
    public Customer(String adr, String fn, String ln, String phone, String mail, int pCode, String note, int cid) {
        super(fn, ln, phone, mail, pCode);
        this.address = adr;
        this.note = note;
        customerID = cid;
    }

    /**
     * Standard copy constructor. Should be used when it is needed a new reference to the object in memory.
     *
     * @param customer the customer object to be copied.
     */
    public Customer(Customer customer) {
        super(customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber(), customer.getEmail(), customer.getPostalCode());
        this.address = customer.getAddress();
        this.note = customer.getNote();
        this.customerID = customer.getCustomerID();
    }

    /**
     * Method findCustomer returns a DefaltListModel containing all the customers in the database matching search criteria.
     *
     * @param search
     * @return a DefaultListModel<Customer> object.
     */
    public static DefaultListModel<Customer> findCustomer(String search) {
        Database db = new Database();
        return db.findCustomer(search);
    }

    /**
     * Checks whether the customer exist in the database or not.
     *
     * @param customer the customer to be checked against the database.
     * @return true if the customer already exist in the database, false if the customer is not found. A customer is equal to a different customer if the phone number and first name is the same. The first name is not case sensitive.
     */
    public static boolean customerExist(Customer customer) {
        Database db = new Database();
        return db.customerExist(customer);
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
     * Gets the corporate number of the customer.
     *
     * @return the corporate number of the customer, null if it is not set.
     */
    public int getCorporateNum() {
        return corporateNum;
    }

    /**
     * Sets the corporate of the customer.
     *
     * @param corporateNum the new corporate number.
     */
    public void setCorporateNum(int corporateNum) {
        this.corporateNum = corporateNum;
    }

    /**
     * Gets the corporate name of the customer.
     *
     * @return the corporate name of the customer. Null if the field is not set.
     */
    public String getCorporateName() {
        return corporateName;
    }

    /**
     * Sets the corporate name of an customer.
     *
     * @param corporateName The new cooperate name.
     */
    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    /**
     * Gets the customer ID of the customer as it is in the Database.
     *
     * @return the customerID stored in the customer object.
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Simple getter for the customer note.
     *
     * @return the note stored in the object.
     */
    public String getNote() {
        return this.note;
    }

    /**
     * Method adds an customer to the database.
     *
     * @param customer the customer to be added to the database.
     * @return true if the customer is successfully added to the database.
     */
    public boolean addCustomer(Customer customer) {
        Database db = new Database();
        return customer != null && db.addCustomer(customer);
    }

    /**
     * Method gets the postal place of the customer. I.E. if the parameter is set to 0001, the return will be OSLO.
     *
     * @param postCode The postal code that represent the postal place.
     * @return the postal place of the code given. Returns null if no postal place is found.
     */
    public String getPostPlace(String postCode) {
        return Helper.searchPostalCode(postCode);
    }

    /**
     * toString returns a string representation of the customer object.
     *
     * @return the first and last name of the customer. I.E. "Gates, Bill".
     */
    @Override
    public String toString() {
        return getLastName() + ", " + getFirstName();
    }
}