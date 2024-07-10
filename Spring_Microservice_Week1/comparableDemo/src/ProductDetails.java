import java.util.Comparator;

public class ProductDetails implements Comparable<ProductDetails>{

    int id;
    String productName;
    double price;

    public ProductDetails(int id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(ProductDetails o) {

        return o.id-this.id;
    }


    public static Comparator<ProductDetails> priceComparator = new Comparator<ProductDetails>() {
        @Override
        public int compare(ProductDetails o1, ProductDetails o2) {
            return (int) (o2.getPrice()-o1.getPrice());
        }
    };

    public static Comparator<ProductDetails> productNameComparator = new Comparator<ProductDetails>() {
        @Override
        public int compare(ProductDetails o1, ProductDetails o2) {
            return (o1.getProductName().compareTo(o2.getProductName()));
        }
    };

   // public static Comparator<ProductDetails> productNammeComparator1=(o1,o2)->o1.getProductName().compareTo(o1.getProductName());



}
