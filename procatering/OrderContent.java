/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;


import javax.swing.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * content of an order or subscription, with deliveryDate( for order and subscription ) or deliveryDay( for subscription )
 *
 * @author Ted
 */
public class OrderContent {
	private DefaultListModel<Dish> dishes;
	private Timestamp deliveryTime;     // timestamp with date and/or time.
	private String deliveryDay;

	/**
	 * constructor for content to Orders
	 *
	 * @param delivery Timestamp with date and time for delivery of order.
	 */
	public OrderContent(Timestamp delivery) {
		deliveryTime = delivery;
		this.dishes = new DefaultListModel<>();
	}
    /**
     * constructor for content to Orders
     * From DB
     *
     * @param delivery Timestamp with date and time for delivery of order.
     */
    public OrderContent( Timestamp delivery, DefaultListModel<Dish> dishlist) {

        deliveryTime = delivery;
        this.dishes = dishlist;
    }

	/**
     * constructor for content to subscriptions
     *
     * @param day  String of the weekday for repeated delivery, full name with capital letter first. ( "Wednesday" )
     * @param time Timestamp that contains the time of delivery for the given day
     */
    public OrderContent(String day, Timestamp time) {
        deliveryTime = time;
        deliveryDay = day;
        this.dishes = new DefaultListModel<>();
    }
    /**
     * constructor for content to subscriptions
     * From DB
     *
     * @param day  String of the weekday for repeated delivery, full name with capital letter first. ( "Wednesday" )
     * @param time Timestamp that contains the time of delivery for the given day
     */
    public OrderContent(String day, Timestamp time, DefaultListModel<Dish> dishlist) {

        deliveryTime = time;
        deliveryDay = day;
        this.dishes = dishlist;
    }



	/**
	 * Method getDishes
	 *
	 * @return a DefaultListModel containing all the dishes
	 */
	public DefaultListModel<Dish> getDishes() {
		return dishes;
	}
        /**
         * Find a Dish object at the given index
         * @param index Integer (dishes index)
         * @return a dish object
         */
        public Dish getDishIndex(int index){
            if(index <= dishes.getSize() && index > -1){
                return dishes.get(index);
            }
            return null;
        }

	/**
	 * Method getDeliveryDate
	 *
	 * @return Timestamp with the delivery time (Only time for subscription, time and date for order)
	 */
	public Timestamp getDeliveryDate() {
		return deliveryTime;
	}

	/**
	 * Method getDeliveryDay
	 *
	 * @return String with the delivery day(Only for subscription)
	 */
	public String getDeliveryDay() {
		return deliveryDay;
	}

	/**
	 * Method addDeliveryTime
	 * Adds a date for an order
	 *
	 * @param date Timestamp containing the time of delivery(subscription) or the time and date of delivery(order)
	 * @return
	 */
	public boolean addDeliveryTime(Timestamp date) {
		if (date != null) {
			this.deliveryTime = date;
			return true;
		}
		return false;
	}

	/**
	 * Method addDay
	 * Adds a weekday for repeated delivery to a subscription.
	 *
	 * @param weekDay whole name of the day with capital first letter.
	 * @return boolean true if it is successfully added
	 */
	public boolean addDay(String weekDay) {
		if (weekDay != null) {
			this.deliveryDay = weekDay;
			return true;
		}
		return false;
	}

	/**
	 * Method addDish
	 * Adds a dish to the DefaultListModel containing dishes ( dishes )
	 *
	 * @param dishName This dish object will be added to the dishes list.
	 * @param quantity This amount of dishName will be added to the dishes list.
	 * @return boolean returns true if added successfully
	 */
	public boolean addDish(Dish dishName, int quantity) {
		if (dishName != null) {
			for (int i = 0; i < quantity; i++) {
				dishes.addElement(dishName);
			}
			return true;
		}

		return false;
	}

	/**
	 * Method countDishes
	 * help-method for the toString.
	 * counts the occurence of every distinct dish within the dish List
	 *
	 * @param dishes the list of dishes that the OrderContent is containng
	 * @return a DefaultListModel<String> with the distinct dish names and the number of those dishes.
	 */
	//TODO needs testing
	private DefaultListModel<String> countDishes(DefaultListModel<Dish> dishes) {
//		if (dishes == null)
//			return null;
//
//		DefaultListModel<String> output = new DefaultListModel<>();
//		int counter = 1;
//
//		for (int i = 0; i < dishes.size(); i++) {
//			System.out.println(i);
//			if (i == 0) {    // kan man ikke sette denna sjekken før for løkka? vet ikke om det blir noe bedre, for om dishes = 0 så vil ikke denna komme pga 0 < 0 funk it?
//				output.addElement(dishes.get(i).getName());
//			} else if (dishes.get(i).getName().equals(output.get(output.size()))) {
//				counter++;
//			} else if (!dishes.get(i).getName().equals(output.get(output.size()))) {
//				output.set(output.size(), output.get(output.size()) + " " + counter);
//				output.addElement(dishes.get(i).toString());
//				counter = 1;
//			}
//		}
//		return output;
		if (dishes == null)
			return null;
		DefaultListModel<String> output = new DefaultListModel<>();
		output.addElement("<table>");
		for (int i = 0; i < dishes.getSize(); i++) {
			output.addElement("<tr><td halign='left'></td><td halign='left'>"+dishes.get(i).getName()+"</td><td halign='right'>"+dishes.get(i).getPrice()+"</td></tr>");
		}
		output.addElement("</table>");
		return output;
	}

	/**
	 * Method removeDish
	 * Removes an element from the dishes list.
	 *
	 * @param index the index the element for removal lies.
	 */
	public void removeDish(int index) {
		dishes.removeElementAt(index);
	}

        
        /**
         * Count equal dishes in the DefaultModelList "dishes".
         * @return a DefaultListModel<String> with string objects example (13x Taco)
         */
        public DefaultListModel<String> countDish(){
            int counter = 0;
            int[] count = new int[100];
            DefaultListModel<Dish> temp = new DefaultListModel<>();
            DefaultListModel<String> output = new DefaultListModel<>();
            for (int i = 0; i < dishes.getSize(); i++) {
                if(!temp.contains(dishes.get(i))){
                   temp.addElement(dishes.get(i)); 
                }
            }
            for (int i = 0; i < temp.size(); i++) {
                for (int j = 0; j < dishes.size(); j++) {
                   if(dishes.get(j).getName().equals(temp.get(i).getName())) {
                       //System.out.println("count.get(i): "+count.get(i));
                       count[i] += 1;
                        }
                   }
                }
            output.clear();
            for (int i = 0; i < temp.size(); i++) {
                output.addElement("<tr><td halign='left'>"+count[i] + " x</td><td>" + temp.get(i).getName()+"</td><td halign='right'>"+temp.get(i).getPrice()+"</td></tr>");
            }
            return output;
        }

    /**
     * Count equal dishes in the DefaultModelList "dishes".
     * @return a DefaultListModel<String> with string objects example (13x Taco)
     */
    public String[][] countDishFish(DefaultListModel<Dish> dishes){
        int counter = 0;
        int[] count = new int[100];
        DefaultListModel<Dish> temp = new DefaultListModel<>();
        DefaultListModel<Integer> output = new DefaultListModel<>();
        for (int i = 0; i < dishes.getSize(); i++) {
            if(!temp.contains(dishes.get(i))){
                temp.addElement(dishes.get(i));
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < dishes.size(); j++) {
                if(dishes.get(j).getName().equals(temp.get(i).getName())) {
                    count[i] += 1;
                }
            }
        }
        String[][] doubleTable= new String[temp.size()][2];
        output.clear();
        for (int i = 0; i < temp.size(); i++) {
            doubleTable[i][0] = temp.get(i).getPrice()+"";
            doubleTable[i][1] = ""+count[i];
        }
        return doubleTable;
    }


	/**
	 * Method toString
	 *
	 * @return String with toString for either subscription or order.
	 */
	@Override
	public String toString() {
		String output = "";
		DefaultListModel<String> countList = countDish();

		if (deliveryDay != null) {
			String simpleDateFormat = new SimpleDateFormat("HH:mm").format(deliveryTime);
			output = deliveryDay + ": " + simpleDateFormat + "<br>";
			if (countList != null){
				for (int i = 0; i < countList.size(); i++) {
					output += countList.get(i) + "<br>";
				}
			}
			return output;
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MMM.yy' - 'HH:mm"); //TODO maybe fix locale.
			output = simpleDateFormat.format(deliveryTime) + ":<br>";
			if (countList != null){
				for (int i = 0; i < countList.size(); i++) {
					output += countList.get(i) + "<br>";
				}
			}
			return output;
		}
	}

	public String toHtml() {
		String output = "";
		DefaultListModel<String> countList = countDish();
		if (deliveryDay != null) {
			String simpleDateFormat = new SimpleDateFormat("HH:mm").format(deliveryTime);
			output = deliveryDay + ": " + simpleDateFormat + "<br>";
			if (countList != null){
				for (int i = 0; i < countList.size(); i++) {
					output += countList.get(i) + "<br>";
				}
			}
			return output;
		} else {
			output = "<tr><td halign='left'>-----------</td><td>---------</td><td halign='right'>----------</td></tr>";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MMM.yy'</td><td>-</td><td>'HH:mm"); //TODO maybe fix locale.
			output += simpleDateFormat.format(deliveryTime);
			if (countList != null){
				for (int i = 0; i < countList.size(); i++) {
					output += countList.get(i);
				}
			output += "</table>";
			}
			return output;
		}
	}
       
        public int countDish(Dish dish){
            int counter=0;
            for (int i = 0; i < dishes.getSize(); i++) {
                if(dishes.get(i).getName().equals(dish.getName())){
                    counter++;
                }
            }
            return counter;
        }
     
}
