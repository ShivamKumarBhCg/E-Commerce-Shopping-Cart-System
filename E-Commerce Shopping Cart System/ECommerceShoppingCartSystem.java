import java.util.*;

// Product Class
class Product {
    int productId;
    String productName;
    double price;
    int quantity;

    Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }

    void displayProduct() {
        System.out.println(productId + ". " + productName + " - ₹" + price + " x " + quantity + " = ₹" + getTotalPrice());
    }
}

// Cart Class
class Cart {
    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
        System.out.println("Product Added!");
    }

    void removeProduct(int id) {
        boolean found = false;
        for (Product p : products) {
            if (p.productId == id) {
                products.remove(p);
                System.out.println("Product Removed!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found!");
        }
    }

    double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getTotalPrice();
        }
        return total;
    }

    void displayCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("\nProducts in Cart:");
        for (Product p : products) {
            p.displayProduct();
        }
    }

    void checkout() {
        double total = calculateTotal();
        double discount = total * 0.10;
        double tax = (total - discount) * 0.05;
        double finalAmount = total - discount + tax;

        displayCart();

        System.out.println("\nTotal: ₹" + total);
        System.out.println("Discount (10%): ₹" + discount);
        System.out.println("Tax (5%): ₹" + tax);
        System.out.println("Final Amount: ₹" + finalAmount);
    }
}

// Main Class (IMPORTANT)
public class ECommerceShoppingCartSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    cart.addProduct(new Product(id, name, price, qty));
                    break;

                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();
                    cart.removeProduct(removeId);
                    break;

                case 3:
                    cart.displayCart();
                    break;

                case 4:
                    cart.checkout();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}