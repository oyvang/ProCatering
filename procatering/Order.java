package procatering;

/**
 *
 * @author TEAM 17
 */
import javax.swing.DefaultListModel;
import sun.util.calendar.LocalGregorianCalendar.Date;

public class Order {

    private int customerId;
    private int employeeId;
    private Date date;
    private DefaultListModel<OrderContent> ordercontent;

    /* Constructor */
    public Order(int c_id, int e_id) {
        customerId = c_id;
        employeeId = e_id;
        this.date = date;
        ordercontent = new DefaultListModel();
    }

    public DefaultListModel getOrderContent() {
        return ordercontent;
    }

    /**
     * Adds the date the order is made
     * @param date
     */
    public void addDate(Date date) {
        this.date = date;
    }

    /**
     * @param orderObj This ordercontent object will be added to the order list.
     */
    public void addOrderContent(OrderContent orderObj) {
        for (int i = 0; i < ordercontent.getSize(); i++) {
            ordercontent.addElement(orderObj);
        }
    }

    public void removeOrder(int index) {
        ordercontent.removeElementAt(index);
    }
}
