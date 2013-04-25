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
    Dish dish = new Dish("Hai", 99,56);
    DefaultListModel<String> catNames = new DefaultListModel<>();
    
    catNames.addElement("Category");
    
    DefaultListModel<String> ingredient = new DefaultListModel<>();
    ingredient.addElement("Gullerot");
    
  
    if(e.addNewDish(dish, catNames, ingredient)) {
    System.out.println("YAY!"); 
    }
    
    
    }
    
}
