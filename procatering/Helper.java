package procatering;

import database.Database;
import javax.swing.*;
import java.sql.Time;
import java.util.Timer;

/**
 * Helper class contains help methods where each methode are static.
 * @author Team 17
 */
//TODO seartchPostalCode skal vell egentlig ikke opprette et DB object, men kjøres gjennom employee? Om dette endres må dokumentasjonen endres også.
public class Helper {
    public static final int GUI_NUMBER = 1;
    public static final int DATABASE_NUMBER = 2;
    public static final int HELPER_NUMBER = 3;
    public static final int PERSON_NUMBER = 4;
    public static final int ORDER_NUMBER = 5;
    public static final int ORDERCONTENT_NUMBER = 6;
    public static final int SUBSCRIPTION_NUMBER = 7;
    public static final int SECURITYCHECKER_NUMBER = 8;
    public static final int DISH_NUMBER = 9;
    public static final int DATABASECLEAN_NUMBER = 10;
    /**
     * Change the string to lower case, then the first letter to capital. There is no check if the String equals null
     * @param input
     * @return String with first letter as capital
     */
    static String singleWordCapitalFirst(String input){
        input = input.toLowerCase();
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
    
    /**
     * Takes a String and returns every first letter in a word as capital.
     * @param input String object to be customized with every first letter of a word to capital
     * @return a customized string
     */
    public static String capitalFirst(String input){
        String[] table = input.split(" ");
        String output = "";
        for (int i = 0; i < table.length; i++) {
            if(i>0){
                output+= " ";
            }
            if(table[i].equalsIgnoreCase("and") || table[i].equalsIgnoreCase("or") || table[i].equalsIgnoreCase("with") || table[i].equalsIgnoreCase("in") || table[i].equalsIgnoreCase("a") || table[i].equalsIgnoreCase("over")){
                output += table[i].toLowerCase();  
            }else{
                output += singleWordCapitalFirst(table[i]); 
            }
        }
        return output;
    }
    
    
    /**
     * @param ex Exception object
     * @param error String object with given error message
     * @return return showMessageDialog(null, "ERROR! \n" + error + "\n" + ex,"Database Error!", ERROR_MESSAGE);
     */
    public static String errorMessage(Exception ex, String error) {
        if(ex != null && error != null){
            return "ERROR! \n" + error + "\n" + ex;
        }
        return "Error 666: Error while trying to make an error message.";
    }
    /**
     * Checks if a string is less than 255 or null
     * @param input the given string that should be checked
     * @return boolean true if the string is not null and is less than 255 signs; else false.
     */
    public static boolean stringChecker(String input){
        if(input != null && input.length() < 255){
            return true;
        }
        return false;
    }
    /**
     * Use melthodes for seartch after postal code place
     * @param postalCode string with postalcode
     * @return string with postal code place, else "N/A"
     */
    public static String searchPostalCode(String postalCode){
        Database db = new Database();
        Boolean gtg = true;
        Integer postInt = 0;
        try {
                postInt = Integer.parseInt(postalCode);
        } catch (NumberFormatException e) {
                gui.Gui.showErrorMessage(HELPER_NUMBER, 1, new Exception("The postal code must be a number"));
                System.err.println(e);
                gtg = false;
        }
        if (gtg) {
                return db.findPostPlace(postInt);
        } else {
                return "N/A";
        }
	}

        /**
         * Adds times to a JComboBox in singleOrderAddTimeComboBox.addItem(String time)
         * @param singleOrderAddTimeComboBox JComboBox object
         */
	public static void addTimes(JComboBox singleOrderAddTimeComboBox) {
		String[] times = new String[]{"0900","1000","1100","1200","1300","1400","1500"};
		for (String time : times) singleOrderAddTimeComboBox.addItem(time);
	}
}
