import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Product> allProduct= List.of(
          new Product(1,"Laptop",45000),
          new Product(2,"Mobile",15000),
          new Product(3,"Earphone",1000),
          new Product(4,"Charger",500),
          new Product(5,"Mouse",300),
          new Product(6,"Keyboard",1000)
        );

        // Using Stream API to filter products with price greater than 1000
        allProduct.stream()
                .filter(product->product.price>1000)
                .forEach(System.out::println);

        // Map name,price to a new list

        List<String> productNames=allProduct.stream()
                .map(product -> product.name)
                .toList();

        System.out.println(productNames);

        // Min price product
        Product minPriceProduct=allProduct.stream()
                .min((product1,product2)-> (int) (product1.price-product2.price))
                .get();

        System.out.println(minPriceProduct);

        // total price of all product
        double totalPrice=allProduct.stream()
                .mapToDouble(product -> product.price)
                .sum();

        System.out.println(totalPrice);
    }
}