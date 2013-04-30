/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

import java.sql.Timestamp;
import javax.swing.DefaultListModel;
import procatering.Employee;

/**
 *
 * @author GM
 */
public class test {
    public static void main(String[] args) {
    Employee e = new Employee("bjarne", "jacobsen", "65873248", 123654, "bjarne@procatering.org", "Qwert123");

    Dish dish = new Dish("taco", 99,56);
    Timestamp st = new Timestamp(8,5,6,4,2,1,6);
    OrderContent o = new OrderContent(st);
    
    DefaultListModel<String> catNames = new DefaultListModel<>();
    DefaultListModel<String> ingredient = new DefaultListModel<>();
    
    catNames.addElement("meat");      
    ingredient.addElement("tacokrydder");
 
        /** DISHES **/                                                          /** DISHES **/ 
//       System.out.println((e.addNewDish(dish, catNames, ingredient)));        //ADD
//       System.out.println(e.hideDish("jorgie"));                              //HIDE
//       System.out.println(e.activateDish("jorgie"));                          //ACTIVATE
//       System.out.println(e.editDish(e.getDish("jorgie"), 1000, 500));        //EDIT
//         Dish katt = new Dish("Katt", 54, 68);
//         Dish ted = new Dish("Ted", 54, 68);
//         o.addDish((katt), 2); 
//         o.addDish((katt), 2); 
//         o.addDish((katt), 2); 
//         o.addDish((ted), 2); 
//         o.addDish((ted), 2); 
//         System.out.println(o.countDish(new Dish("Katt", 54, 68)));           //Count dish
    
        /** EMPLOYEE **/                                                        /** EMPLOYEE **/
//        System.out.println(e.addEmployee("Ted","sky", "65873248", 2500,
//            "03041989", "ornulf@procatering.org", "Qwert123"));               // ADD
//        if(e.getEmployee(16)!=null){         
//            Employee s = new Employee(e.getEmployee(16));     
//            if(s !=null){
//                s.setFirstName("ornulf");
//                 s.setLastName("olsen");
//                 System.out.println(e.updateEmployee(s));
//            }
//        }                                                                     //UPDATE
//        System.out.println(e.changeEmployeePassword("jara", 16));             //PASSWORD
//        System.out.println(e.removeEmployee(20));                             //REMOVE
    
        /** CATEGORIES **/                                                      /** CATEGORIES **/
//        System.out.println(e.removeCategory("svett"));                        //REMOVE
      
    }
}
