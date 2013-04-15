package database;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


/** Class SecurityChecker */
public class SecurityChecker {

	public boolean checkPassword(int employee_id, String password){
	
		String dbPass = getPasswordFromDatabase(employee_id);
		
		if(dbPass == null || password == null){
			return false;
		}
		
	try {
		if(MD5(password).equals(dbPass)){
			return true;
		}
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
		
		
	}
	/** Gets a MD5 hash from the database and returns it as a String
	 * @param id of the column witch contains the password 
	 * @return String with a md5 hash of a password
	 * @author J�rgen Lien Sell�g
	 * */
	private String getPasswordFromDatabase(int id){
		Database con = new Database();
		
		/* Selects the password from the database to be compared. */
		String query = "SELECT employee.password FROM employee WHERE employee_id = '"+id+"'";
		
		
		try{
			ResultSet set = con.gQuery(query);
			while(set.next()){
				String retur = set.getString("password");
				return retur;
			}
			return null;
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "An Error have occurred when trying to accses the database!\n\n" + error,"ERROR!", ERROR_MESSAGE);
			return null;
		}
		finally{
			con.disconnect();
		}
	}

//TODO legg til dokumentasjon for md5sjekkeren.
	
		 
	    private static String convertToHex(byte[] data) { 
	        StringBuffer buf = new StringBuffer();
	        for (int i = 0; i < data.length; i++) { 
	            int halfbyte = (data[i] >>> 4) & 0x0F;
	            int two_halfs = 0;
	            do { 
	                if ((0 <= halfbyte) && (halfbyte <= 9)) 
	                    buf.append((char) ('0' + halfbyte));
	                else 
	                    buf.append((char) ('a' + (halfbyte - 10)));
	                halfbyte = data[i] & 0x0F;
	            } while(two_halfs++ < 1);
	        } 
	        return buf.toString();
	    } 
	 
	    public static String MD5(String text) 
	    throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
	        MessageDigest md;
	        md = MessageDigest.getInstance("MD5");
	        byte[] md5hash = new byte[32];
	        md.update(text.getBytes("iso-8859-1"), 0, text.length());
	        md5hash = md.digest();
	        return convertToHex(md5hash);
	    }
		public boolean checkAdmin() {
			// TODO Create check if the user is admin.
			return false;
		} 
	
}
