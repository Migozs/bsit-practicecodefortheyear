package lorenzoactivity;

public class Clothing extends Product {
    private String size;

    public Clothing(String code, String name, double price, String size) {
        super(code, name, price);
        this.size = size;
    }

    @Override
    public double computePrice() {
        double discounted = getPrice() * 0.90; // 10% discount
        double service = getPrice() * 0.05;    // 5% service fee (original price)
        return discounted + service;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Size: " + size);
    }
}
