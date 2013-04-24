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
    private int id = -1;
    
    public Dish (String name, double price, double cost){
        this.name = name;
        this.price = price;
        this.cost = cost;
    }
    public Dish (String name, double price, double cost, int id){
        this.name= name;
        this.price = price;
        this.cost = cost;
        this.id = id;
    }
    
    /** Standard copy constructor */ 
    public Dish(Dish d){
        this(d.getName(),d.getPrice(),d.getCost());
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
    public int getID() {
        return id;
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
