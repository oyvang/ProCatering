/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

/**
 *
 * @author Ted
 */
public class Customer extends Person{
    private String address;
    
    public Customer(String adr, String fn, String ln, String phone, String mail, int pCode){
        super( fn,  ln,  phone,  mail, pCode);
        this.address = adr;
    }
    public Customer(int c_id){
    	super("p","2","e","e","2"); //slett dette, kun her for � f� bort den j�vla feilmeldinga... 
    	//TODO Skriv sql-kode som henter ut costumerinformasjon fra databasen
    	//N� lages en costumer fra inforamsjonen fra databasen.
    	//parameter i super skives inforamajsonenewn w
    	System.out.println("Slett dette");
    	
    }
    //TODO legg til dokumentasjon
    public String getAddress() {
        return address;
    }
    //TODO legg til dokumentasjon
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "address=" + address +" "+ super.toString()+'}';
    }
    
}
