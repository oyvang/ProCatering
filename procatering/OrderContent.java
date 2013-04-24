/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;

/**
 * content of an order or subscription, with deliveryDate( for order ) or deliveryDay( for subscription )
 * @author Ted
 * 
 */
public class OrderContent {
    private DefaultListModel<Dish> dishes;
    private Timestamp deliveryTime;     // timestamp with date and/or time.
    private String deliveryDay;
    
    /*constructor for order */
    public OrderContent(Timestamp delivery){
        deliveryTime = delivery;        // timestamp with time and date.
    }
    /*constructor for subscription */
        public OrderContent(String day, Timestamp time){
        deliveryTime = time;
        deliveryDay = day;
    }
    public DefaultListModel getDishes(){
        return dishes;
    }

    public Timestamp getDeliveryDate() {
        return deliveryTime;
    }

    public String getDeliveryDay() {
        return deliveryDay;
    }
        
    /**
     * Adds a date for an order
     * @param date
     * @return 
     */
    public boolean addDeliveryTime(Timestamp date){
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
    public boolean addDay(String weekDay){
       if(weekDay!=null){
        this.deliveryDay = weekDay;
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
    
    //TODO needs testing
    public DefaultListModel<String> countDishes(DefaultListModel<Dish> dishes){
        DefaultListModel<String> output = new DefaultListModel<>();
        int counter = 1;
        for (int i = 0; i < dishes.size(); i++) {
            if(i == 0){
                output.addElement(dishes.get(i).getName());
            }else if(dishes.get(i).getName().equals(output.get(output.size()))){
                counter++;
            }else if(!dishes.get(i).getName().equals(output.get(output.size()))){
                output.set(output.size(), output.get(output.size())+" "+counter);
                output.addElement(dishes.get(i).toString());
                counter = 1;
            }
        }
        return output;
    }
    /**
     * Removes an element from the dishes list.
     * @param index the index the element for removal lies.
     * @author Tedjk
     */
    public void removeDish(int index){
        dishes.removeElementAt(index);
    }
    
    @Override
    public String toString(){
        String output ="";
        DefaultListModel<String> countList = countDishes(dishes);
        if(deliveryDay !=null){
            //TODO: make deliveryTime to be the time of the day it is to be delivered.
           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'HH:MM'");
           output = deliveryDay+"s: "+simpleDateFormat.format(deliveryTime)+"\n";
            for (int i = 0; i < countList.size(); i++) {
                output += countList.get(i)+"\n";
            }
            return output;
        }else{
            //TODO: make deliveryTime to be the date and time.
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy' 'HH:MM");
            output = deliveryTime+"s: \n";  
            for (int i = 0; i < countList.size(); i++) {
                output += countList.get(i)+"\n";
            }
            return output;
        }
    }
}
