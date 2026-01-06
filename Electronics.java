package lorenzoactivity;

public class Electronics extends Product {
    private String brand;

    public Electronics(String code, String name, double price, String brand) {
        super(code, name, price);
        this.brand = brand;
    }

    @Override
    public double computePrice() {
        return getPrice() * 1.12; // 12% tax
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Brand: " + brand);
    }
}
