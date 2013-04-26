/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

import database.Database;

import javax.swing.*;
import java.sql.Time;
import java.util.Timer;

/**
 *Helper class which is contains help methods
 * @author Ted
 */
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
     * Takes a String and returns the first letter of the String as capital and rest as lower case.
     * @param input 
     * @return 
     */
    static String singleWordCapitalFirst(String input){
        input = input.toLowerCase();
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
    
    /**
     * Takes a String and returns every word of the string with the first letter as capital.
     * @param input
     * @return 
     */
    public static String capitalFirst(String input){
        String[] table = input.split(" ");
        String output = "";
        for (int i = 0; i < table.length; i++) {
            if(i>0){
                output+= " ";
            }
            if(table[i].equals("and") || table[i].equals("or") || table[i].equals("with")){
                output += table[i];  
            }else{
                output += singleWordCapitalFirst(table[i]); 
            }
        }
        return output;
    }
    
    
        /**
     * Uses showMessageDialog to print out error messages.
     *
     * @param ex Exception object
     * @param error String object
     * @return return showMessageDialog(null, "ERROR! \n" + error + "\n" + ex,"Database Error!", ERROR_MESSAGE);
     * @author Geir Morten Larsen
     */
    public static String errorMessage(Exception ex, String error) {
        if(ex != null && error != null){
            return "ERROR! \n" + error + "\n" + ex;
        }
        return "Error 666: Error while trying to make an error message.";
    }
    /**
     * Checks if a string is less than 255 signs and is not null.
     * @param input
     * @return true if the string is not null and is less than 255 signs, if not it will return false.
     */
    public static boolean stringChecker(String input){
        if(input != null && input.length() < 255){
            return true;
        }
        return false;
    }
    
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


	public static void addTimes(JComboBox singleOrderAddTimeComboBox) {
		String[] times = new String[]{"0900","1000","1100","1200","1300","1400","1500"};
		for (String time : times) singleOrderAddTimeComboBox.addItem(time);
	}
}
