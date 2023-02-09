import java.util.ArrayList;

public class Order {
    private ArrayList<Product> orderedProducts = new ArrayList<>();
    private double totalPrice ;
    private double temp;

    public Order() {

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product products) {
        orderedProducts.add(products);
    }

    public void listOrder() {
        for (int i = 0; i < this.orderedProducts.size(); i++) {
            System.out.println(this.orderedProducts.get(i));

                   }
    }

    public ArrayList<Product> getOrderedProducts() {
        return this.orderedProducts;
    }

    public double calculateTotalPrice() {
        this.temp=0;
        for (Product product : this.orderedProducts) {
            this.temp += ((product).getSellingPrice());
        }
        this.totalPrice+=temp;
        return getTotalPrice();
    }
}
//    public double calculateTotalPrice(){
//
//for (int i = 0;i< orderedProducts.size();i++){
//  this.totalPrice += orderedProducts.get(i).getSellingPrice();
//}
//return this.getTotalPrice();
//}



//no problem
