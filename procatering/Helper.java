/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

/**
 *Helper class which is contains help methods
 * @author Ted
 */
public class Helper {
    
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
    static String capitalFirst(String input){
        String[] table = input.split(" ");
        String output = "";
        for (int i = 0; i < table.length; i++) {
            if(i>0 && i != table.length-1){
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
    
    
    
    
}
