import java.util.*;

class Product implements Comparable<Product> {
    private int productID;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String status;
    private int supplierID;
    private String supplierName;

    public Product(int productID, String name, String description, double price, int quantity, String status, int supplierID) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.supplierID = supplierID;
    }

    public int getProductID() {
        return productID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productID, other.productID);
    }

    @Override
    public String toString() {
        return productID + ", " + name + ", " + description + ", " + quantity + ", " + price + ", " + status + ", " + supplierName;
    }
}
