public record Product(String name, double price, String category) {

    public Product(String name, double price) {
        this(name, price, "Uncategorized");
    }
}