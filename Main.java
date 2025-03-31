import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a Product
class Product {
    String productId;
    String productName;
    double price;

    // Constructor to create a new product
    public Product(String id, String name, double price) {
        this.productId = id;
        this.productName = name;
        this.price = price;
    }
}

// Class to represent the Shopping Cart
class ShoppingCart {
    private ArrayList<Product> cart = new ArrayList<>(); // List to store products

    // Method to add a product to the cart
    public void addProduct(Product product) {
        cart.add(product);
        System.out.println("Product added to cart.");
    }

    // Method to remove a product using its ID
    public void removeProduct(String productId) {
        boolean removed = cart.removeIf(p -> p.productId.equals(productId)); // Remove product by ID
        if (removed) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to calculate total price of the cart
    public double calculateTotalPrice() {
        double total = 0;
        for (Product p : cart) {
            total += p.price; // Add each product's price to total
        }
        return total;
    }

    // Method to show all items in the cart
    public void displayCart() {
        System.out.println("\nYour Cart:");
        for (Product p : cart) {
            System.out.printf("ID: %s | %s - $%.2f\n", p.productId, p.productName, p.price);
        }
        System.out.printf("Total: $%.2f\n", calculateTotalPrice()); // Show total
    }
}

// Main class
public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(); // Create new cart
        Scanner scanner = new Scanner(System.in); // Create scanner
        String choice;

        while (true) {
            // Menu options
            System.out.println("\nOptions: add, remove, view, exit");
            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "add":
                    // Add a new product
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    cart.addProduct(new Product(id, name, price)); // Add to cart
                    break;

                case "remove":
                    // Remove a product by ID
                    System.out.print("Enter Product ID to remove: ");
                    String removeId = scanner.nextLine();
                    cart.removeProduct(removeId);
                    break;

                case "view":
                    // Show what's in the cart
                    cart.displayCart();
                    break;

                case "exit":
                    // Exit the program
                    System.out.println("Thank you for shopping!");
                    scanner.close();
                    return;

                default:
                    // If user types something invalid
                    System.out.println("Invalid option.");
            }
        }
    }
}
