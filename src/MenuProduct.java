import java.util.ArrayList;

public class MenuProduct extends Product {

    private ArrayList<Product> individualProducts;
    private double tempnum = 0.0;
    private double tempnum2 = 0.0;

    public MenuProduct(String name, ArrayList<Product> products) {
        super(name);
        this.individualProducts = products;
        super.setSellingPrice(calculateSellingPrice());
    }

    public ArrayList<Product> getIndividualProducts() {
        return this.individualProducts;
    }

    public double calculateExpense() {
        for (Product product : this.individualProducts) {
            this.tempnum += ((product).calculateExpense());
        }
        return this.tempnum;
    }

    private double calculateSellingPrice() {

        for (Product product : this.individualProducts) {
            if (product instanceof MainDish) {
                this.tempnum2 += ((product).getSellingPrice()) * (0.9);
            }
            if (product instanceof Dessert) {
                this.tempnum2 += ((product).getSellingPrice() * (0.8));
            }
            if (product instanceof Beverage) {
                this.tempnum2 += ((product).getSellingPrice() * (0.5));
            }
        }
        return this.tempnum2;

    }
}
