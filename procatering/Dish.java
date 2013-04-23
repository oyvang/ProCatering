/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

/**
 *
 * @author GM
 */
public class Dish {
    private String name;
    private double price;
    private double cost;
    
    public Dish (String name, double price, double cost){
        this.name = name;
        this.price = price;
        this.cost = cost;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getCost() {
        return cost;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name + ", " + price;
    }
    
    
}
