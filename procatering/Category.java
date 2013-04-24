
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

/**
 *
 * @author GM
 */
public class Category {
    
    private String name;
    private int categoryID = -1;
    
    public Category (int categoryID,String name){
        this.name = name;
        this.categoryID=categoryID;
    }
    
    public String getName(){
        return name;
    }
    public int getIngredientID() {
        return categoryID;
    }
}

