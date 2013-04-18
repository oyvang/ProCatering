/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

import javax.swing.DefaultListModel;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 * content of an order or subscription, with date(order) or day(subscription)
 * @author Ted
 */
public class OrderContent {
    private DefaultListModel<Dish> dishes;
    private Date date;
    private int day;
    
    /*constructor */
    public OrderContent(){
        dishes = new DefaultListModel<Dish>();
    }
    
    public DefaultListModel getDishes(){
        return dishes;
    }
    
    /**
     * Adds a date for an order
     * @param date
     * @return 
     */
    public boolean addDate(Date date){
       if(date != null){
        this.date = date;
        return true;
       }
       return false;
    }
    
    /**
     * Adds a weekday to a subscription.
     * @param dayNumber 1 for monday, 7 for sunday
     * @return boolean
     * @author Tedjk
     */
    public boolean addDay(int dayNumber){
       if(dayNumber > 1 || dayNumber < 8){
        this.day = dayNumber;
        return true;
       }
       return false;
    }
    
   
    
    
    
    
    /**
     * 
     * @param dishObj This dish object will be added to the dishes list.
     * @param quantity This amount of dishes will be added to the dishes list.
     * @return boolean
     * @author Tedjk
     */
    public boolean addDish(Dish dishObj, int quantity){
        if(dishObj != null){
            for (int i = 0; i < quantity; i++) {
                dishes.addElement(dishObj);
            }
            return true;
        }
        
        return false;
    }
    
    /**
     * Removes an element from the dishes list.
     * @param index the index the element for removal lies.
     * @author Tedjk
     */
    public void removeDish(int index){
        dishes.removeElementAt(index);
    }
}
