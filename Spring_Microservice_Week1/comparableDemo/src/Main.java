import java.util.*;
public class Main {
    public static void main(String[] args) {

        ProductDetails product1 = new ProductDetails(1, "Laptop", 45000);
        ProductDetails product2 = new ProductDetails(2, "Mobile", 25000);
        ProductDetails product3 = new ProductDetails(3, "Charger", 45000);
        ProductDetails product4 = new ProductDetails(4, "HardDisk", 25000);
        ProductDetails product5 = new ProductDetails(5, "Cable", 25000);
        ProductDetails product6 = new ProductDetails(6, "Mouse", 25000);

        List<ProductDetails> allProduct=new ArrayList<ProductDetails>(Arrays.asList(product1,product2,product3,product4,product5,product6));

      Collections.sort(allProduct);
        System.out.println("Sorted by Id");
        for(ProductDetails product:allProduct){
            System.out.println(product);
        }

        Collections.sort(allProduct,ProductDetails.priceComparator.thenComparing(ProductDetails.productNameComparator));
        System.out.println("Sorted by Price");
        for(ProductDetails product:allProduct){
            System.out.println(product);
        }






    }
}