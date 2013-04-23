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
	 * @author Team17
	 * //TODO legg til dokumentasjon
	 */
    public Customer(String adr, String fn, String ln, String phone, String mail, int pCode){
        super( fn,  ln,  phone,  mail, pCode);
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
    
    public static DefaultListModel<Customer> findCustomer(String search){
            Database db = new Database();
            return db.findCustomer(search);
    }


    @Override
    public String toString() {
        return getLastName()+", "+getFirstName();
    }
}
