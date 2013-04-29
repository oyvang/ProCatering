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

    Dish dish = new Dish("taco", 99,56);
    
    DefaultListModel<String> catNames = new DefaultListModel<>();
    DefaultListModel<String> ingredient = new DefaultListModel<>();
    
    catNames.addElement("meat");      
    ingredient.addElement("tacokrydder");
 
        /** DISHES **/                                                          /** DISHES **/ 
//       System.out.println((e.addNewDish(dish, catNames, ingredient)));        //ADD
//       System.out.println(e.hideDish("jorgie"));                              //HIDE
//       System.out.println(e.activateDish("jorgie"));                          //ACTIVATE
//       System.out.println(e.editDish(e.getDish("jorgie"), 1000, 500));        //EDIT
//   
//      /** EMPLOYEE **/                                                        /** EMPLOYEE **/
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
//    
//      /** CATEGORIES **/                                                      /** CATEGORIES **/
//        System.out.println(e.removeCategory("svett"));                        //REMOVE
//          System.out.println(e.addCatergory("mad-corck"));                    //ADD
    
        /** ORDERS **/                                                          /**ORDERS**/
//        for (int i = 0; i < e.findOrders("o").getSize(); i++) {
//            System.out.println(e.findOrders("o").get(i));
//        }                                                                     //Search
          System.out.println(e.getOrder(2));
          
    }
}
