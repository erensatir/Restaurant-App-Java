import java.util.ArrayList;
import java.util.Random;

public class Restaurant  {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private double totalexpense=0;
    private double totalrevenue=0;


    public Restaurant() {
        initEmployees();
        initProducts();
    }

    private void initEmployees() {

        addCook("Monica", 100);

        addWaiter("Ross");
        addWaiter("Phobe");
        addWaiter("Rachel");
    }

    private void initProducts() {

        // Parameters for Product Constructor:
        // Product Name, Selling Price, Purchase Price and Utility Cost

        products.add(new MainDish("Pizza", 6, 2, 2));
        products.add(new MainDish("Burger", 5, 1.5, 2));

        products.add(new Beverage("Coke", 2, 0.5));
        products.add(new Beverage("Lemonade", 2, 0.3));

        products.add(new Dessert("Tiramusu", 4, 1, 1));
        products.add(new Dessert("Cake", 3, 0.5, 1));
        products.add(new Dessert("Ice Cream", 3, 0.5, 0.5));

        ArrayList<Product> HGproducts = new ArrayList<>();
        HGproducts.add(new MainDish("Pizza", 6, 2, 2));
        HGproducts.add(new Beverage("Coke", 2, 0.5));
        HGproducts.add(new Dessert("Tiramusu", 4, 1, 1));
        products.add(new MenuProduct("Hunger Games Menu", HGproducts));

        ArrayList<Product> Kidsproducts = new ArrayList<>();
        Kidsproducts.add(new MainDish("Burger", 5, 1.5, 2));
        Kidsproducts.add(new Beverage("Lemonade", 2, 0.3));
        Kidsproducts.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
        products.add(new MenuProduct("Kids Menu", Kidsproducts));
    }

    public void addWaiter(String name){
        employees.add(new Waiter(employees.size()+1, name));
        // I've added plus one because the id of the employees cannot be 0
    }
    public void addCook(String name, double salary) {
        employees.add(new Cook(employees.size()+1, name,salary));
        // I've added plus one because the id of the employees cannot be 0
    }
    public Waiter assignWaiter() {
        Random random = new Random();
        int pick = random.nextInt(employees.size());
        while (true) {
            if (employees.get(pick) instanceof Waiter) {
                return (Waiter) employees.get(pick);
            }
        }
    }

    public void listEmployees(){
        for(int i = 0;i< employees.size();i++){
            System.out.println(employees.get(i));
        }
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }
    public double calculateExpenses(){
        for(Employee employee : this.employees){
            if (employee instanceof Cook){
                totalexpense+= employee.calculateExpense();
            }
            if (employee instanceof Waiter){
                totalexpense+= employee.calculateExpense();
            }
        }
        return totalexpense;
    }
    public double calculateRevenue(){
        for(Employee employee : employees){
            if (employee instanceof Waiter){
                for (int i =0;i<((Waiter) employee).getOrdersReceived().size();i++){
                    totalrevenue+=((Waiter) employee).getOrdersReceived().get(i).calculateTotalPrice();
                }
            }
        }
        return totalrevenue;
    }

    // Implement the rest of the class
}

