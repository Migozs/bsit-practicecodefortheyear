package lorenzoactivity;

public class Grocery extends Product {
    private String expiration;

    public Grocery(String code, String name, double price, String expiration) {
        super(code, name, price);
        this.expiration = expiration;
    }

    @Override
    public double computePrice() {
        return getPrice() * 0.95; // 5% discount
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Expiration Date: " + expiration);
    }
}
