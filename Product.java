package lorenzoactivity;

public abstract class Product {
    private String code;
    private String name;
    private double price;
    public static int productCount = 0;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
        productCount++;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract double computePrice();

    public void showInfo() {
        System.out.println("Product Code: " + code);
        System.out.println("Product Name: " + name);
        System.out.println("Base Price: " + price);
    }
}
