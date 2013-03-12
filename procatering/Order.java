package procatering;

/**
 *
 * @author Eirik    
 */
public class Order {
    private int dish;
    private String date;
    private double totalPrice;
    private double totalCost;
    private Employee employee;
    private Customer customer;
    
    /* Constructor */
    public Order(int c_id, int dish, double tp, String date, double tc, int e_id){
        this.dish = dish;
        this.date = date;
        totalPrice = tp;
        totalCost = tc;
        employee = Employee.getEmployee_id(e_id);
        customer = new Customer(c_id);
    }
    
    /* get methodes */
    public int getDish(){
        return dish;
    }
    public String getDate(){
        return date;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public double getTotalCost(){
        return totalCost;
    }
    /* set methodes */
    public void setDish(int dish){
        this.dish = dish;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }
    public void setTotalCost(double totalCost){
        this.totalCost = totalCost;
    }
    public String toString(){
        return "Costumer: " + "/*customer.id */"+ ", Dish: " + dish + ", Price: " + totalPrice + " kr." +
                ", Date: " + date + ",\n (Cost of order: " + totalCost + " kr. " + ", Employee: " + "/*employee.id*/" + ")";
    }
}
