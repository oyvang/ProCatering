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
    Employee e = new Employee("bjarne", "jacobsen", "65873248", 123654, "bjarne@procatering.org", "Qwert123");

    Dish dish = new Dish("Jorgie", 99,56);
    
    DefaultListModel<String> catNames = new DefaultListModel<>();
    DefaultListModel<String> ingredient = new DefaultListModel<>();
    
    catNames.addElement("svett");      
    ingredient.addElement("guut");
 

//        System.out.println((e.addNewDish(dish, catNames, ingredient)));   //funke
    
//        System.out.println(e.removeDish("jorgie"));   //funke
        
//        System.out.println(e.editDish(e.getDish("jorgie"), 1000, 500));   //funke
    
//        System.out.println(e.addEmployee("ornulf", "olsen", "65873248", 2500,"03041989", "ornulf@procatering.org", "Qwert123")); // funke
    
//        if(e.getEmployee(16)!=null){         //FUNKE
//           
//            Employee s = new Employee(e.getEmployee(16));
//            System.out.println(s.getEmployeeId());
//      
//            if(s !=null){
//                s.setFirstName("ornulf");
//                 s.setLastName("olsen");
//                 System.out.println(e.updateEmployee(s));
//            }
//        }
       // System.out.println(e.changeEmployeePassword("jara", 16));  // FUNKE
    
//        DefaultListModel en = e.getDishes(1);   // FUNKE
//        System.out.println(en.get(0));
    
    
    }
}
