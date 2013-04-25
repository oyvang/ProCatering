/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

import javax.swing.DefaultListModel;
import procatering.Employee;

/**
 *
 * @author GM
 */
public class test {
    public static void main(String[] args) {
       Employee e = new Employee("Test", "TEst", "Test", 123654, "Test", "Test");
    Dish dish = new Dish("Jorgie", 99,56);
    DefaultListModel<String> catNames = new DefaultListModel<>();
    
    catNames.addElement("svett");
    
    DefaultListModel<String> ingredient = new DefaultListModel<>();
    ingredient.addElement("guut");
 

//    System.out.println((e.addNewDish(dish, catNames, ingredient))); 
    
        System.out.println(e.removeDish("jorgie"));
    
    }
    
}
