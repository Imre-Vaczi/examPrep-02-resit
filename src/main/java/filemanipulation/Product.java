package filemanipulation;

public class Product {

    private String productID;
    private String name;
    private int price;

    public Product(String productID, String name, int price) {
        this.name = name;
        this.price = price;
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getProductID() {
        return productID;
    }
}
