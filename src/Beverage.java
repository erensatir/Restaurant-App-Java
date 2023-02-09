public class Beverage extends Product{
    public Beverage(String name, double sellingPrice, double purchaseprice){
        super(name,sellingPrice,purchaseprice,0.0);
    }
    public double calculateExpense(){
        return this.getPurchasePrice();
    }

}
