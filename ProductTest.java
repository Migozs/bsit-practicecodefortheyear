package lorenzoactivity;

import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter electronics code: ");
        String eCode = input.nextLine();
        System.out.print("Enter electronics name: ");
        String eName = input.nextLine();
        System.out.print("Enter electronics price: ");
        double ePrice = input.nextDouble();
        input.nextLine();
        System.out.print("Enter brand: ");
        String eBrand = input.nextLine();
        Product p1 = new Electronics(eCode, eName, ePrice, eBrand);

        System.out.print("\nEnter grocery code: ");
        String gCode = input.nextLine();
        System.out.print("Enter grocery name: ");
        String gName = input.nextLine();
        System.out.print("Enter grocery price: ");
        double gPrice = input.nextDouble();
        input.nextLine();
        System.out.print("Enter expiration date: ");
        String gExpiration = input.nextLine();
        Product p2 = new Grocery(gCode, gName, gPrice, gExpiration);

        System.out.print("\nEnter clothing code: ");
        String cCode = input.nextLine();
        System.out.print("Enter clothing name: ");
        String cName = input.nextLine();
        System.out.print("Enter clothing price: ");
        double cPrice = input.nextDouble();
        input.nextLine();
        System.out.print("Enter clothing size: ");
        String cSize = input.nextLine();
        Product p3 = new Clothing(cCode, cName, cPrice, cSize);

        Product[] items = {p1, p2, p3};

        System.out.println("\n--- PRODUCT LIST ---");
        for (Product p : items) {
            p.showInfo();

            if (p instanceof Electronics) {
                System.out.printf("Final Price (with tax): %.1f\n", p.computePrice());
            } else if (p instanceof Grocery) {
                System.out.printf("Final Price (with discount): %.1f\n", p.computePrice());
            } else if (p instanceof Clothing) {
                System.out.printf("Final Price (with discount + service fee): %.1f\n", p.computePrice());
            }
            System.out.println();
        }

        input.close();
    }
}
