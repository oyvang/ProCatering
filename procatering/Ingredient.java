/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

/**
 *
 * @author GM
 */
public class Ingredient {
    private String name;
    private int ingredientID = -1;
    
    public Ingredient (int ingredientID,String name){
        this.name=name;
        this.ingredientID=ingredientID;
    }
    
    public String getName(){
        return name;
    }
    
    public int getIngredientID(){
        return ingredientID;
    }
    public String toString() {
        return this.name;
    }
}
