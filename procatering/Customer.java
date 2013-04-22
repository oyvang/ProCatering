package procatering;

/**
 * @author Ted
 */
public class Customer extends Person{
    private String address;
    private int customerID;

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
    @Override
    public String toString() {
        return "Customer{" + "address=" + address +" "+ super.toString()+'}';
    }
}
