/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;


import java.sql.Timestamp;
import javax.swing.DefaultListModel;

/**
 * content of an order or subscription, with deliveryDate( for order ) or deliveryDay( for subscription )
 * @author Ted
 * 
 */
public class OrderContent {
    private DefaultListModel<Dish> dishes;
    private Timestamp deliveryTime;     // timestamp with date and/or time.
    private int deliveryDay;
    
    /*constructor for order */
    public OrderContent(DefaultListModel<Dish> dishesInput, Timestamp delivery){
        dishes = dishesInput;
        deliveryTime = delivery;        // timestamp with time and date.
    }
    /*constructor for subscription */
        public OrderContent(DefaultListModel<Dish> dishesInput, int day, Timestamp time){
        dishes = dishesInput;
    }
    public DefaultListModel getDishes(){
        return dishes;
    }

    public Timestamp getDeliveryDate() {
        return deliveryTime;
    }

    public int getDeliveryDay() {
        return deliveryDay;
    }
        
    /**
     * Adds a date for an order
     * @param date
     * @return 
     */
    public boolean addDate(Timestamp date){
       if(date != null){
        this.deliveryTime = date;
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
        this.deliveryDay = dayNumber;
        return true;
       }
       return false;
    }
    /**
     * 
     * @param dishName This dish object will be added to the dishes list.
     * @param quantity This amount of dishes will be added to the dishes list.
     * @return boolean
     * @author Tedjk
     */
    public boolean addDish(Dish dishName, int quantity){
        if(dishName != null){
            for (int i = 0; i < quantity; i++) {
                dishes.addElement(dishName);
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
