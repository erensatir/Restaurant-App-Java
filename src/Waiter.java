import java.lang.reflect.Array;
import java.util.ArrayList;

public class Waiter extends Employee {
    private double orderRate = 0.10;
    private ArrayList<Order> ordersReceived = new ArrayList<>();
    private double expenseofOrders = 0;
    private double expenseofWaiter = 0;


    public Waiter(int id, String name) {
        super(id, name);
    }

    public double calculateExpense() {
        for (Order order : ordersReceived) {
            for (Product product : ((order).getOrderedProducts())) {
                this.expenseofOrders += ((product).calculateExpense());
            }
        }

            for (int i = 0; i < ordersReceived.size(); i++) {
                this.expenseofWaiter += ((ordersReceived.get(i).calculateTotalPrice()) * orderRate);
            }

        return this.expenseofOrders+this.expenseofWaiter;
    }

    public ArrayList<Order> getOrdersReceived(){
        return this.ordersReceived;

    }
    public void createOrder(Order orders){
this.ordersReceived.add(orders);
    }
}
