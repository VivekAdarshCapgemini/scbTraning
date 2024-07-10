public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99);
        System.out.println("Product 1: " + product1.name() + ", Price: $" + product1.price() + ", Category: " + product1.category());

        Product product2 = new Product("Mouse", 15.99);
        System.out.println("Product 2: " + product2.name() + ", Price: $" + product2.price());
    }
}
