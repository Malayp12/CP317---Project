import java.io.*;
import java.util.*;

class InventoryManager {
    private Map<Integer, Supplier> suppliers = new HashMap<>();
    private List<Product> products = new ArrayList<>();
    private PriorityQueue<Product> productQueue = new PriorityQueue<>();

    public void readSupplierFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(",\s*");
                    if (parts.length < 2) throw new IllegalArgumentException("Invalid Supplier Data: " + line);
                    int supplierID = Integer.parseInt(parts[0]);
                    suppliers.put(supplierID, new Supplier(supplierID, parts[1]));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid supplier entry (NumberFormat Error): " + line);
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping invalid supplier entry (Invalid Data Format): " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading supplier file: " + e.getMessage());
        }
    }

    public void readProductFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(",\s*");
                    if (parts.length < 7) throw new IllegalArgumentException("Invalid Product Data: " + line);
                    int productID = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String description = parts[2];
                    double price = Double.parseDouble(parts[3].replace("$", ""));
                    int quantity = Integer.parseInt(parts[4]);
                    String status = parts[5];
                    int supplierID = Integer.parseInt(parts[6]);

                    Product product = new Product(productID, name, description, price, quantity, status, supplierID);
                    if (suppliers.containsKey(supplierID)) {
                        product.setSupplierName(suppliers.get(supplierID).getName());
                    } else {
                        product.setSupplierName("Unknown Supplier");
                    }
                    productQueue.add(product);
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid product entry (NumberFormat Error): " + line);
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping invalid product entry (Invalid Data Format): " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading product file: " + e.getMessage());
        }
    }

    public void mergeSort(List<Product> products, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(products, left, mid);
            mergeSort(products, mid + 1, right);
            merge(products, left, mid, right);
        }
    }

    private void merge(List<Product> products, int left, int mid, int right) {
        List<Product> leftList = new ArrayList<>(products.subList(left, mid + 1));
        List<Product> rightList = new ArrayList<>(products.subList(mid + 1, right + 1));
       
        int i = 0, j = 0, k = left;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).getProductID() <= rightList.get(j).getProductID()) {
                products.set(k++, leftList.get(i++));
            } else {
                products.set(k++, rightList.get(j++));
            }
        }
        while (i < leftList.size()) {
            products.set(k++, leftList.get(i++));
        }
        while (j < rightList.size()) {
            products.set(k++, rightList.get(j++));
        }
    }

    public void writeToFile(String outputPath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("InventoryFile.txt"))) {
            List<Product> sortedProducts = new ArrayList<>(productQueue);
            mergeSort(sortedProducts, 0, sortedProducts.size() - 1);
           
            bw.write("Product ID, Product Name, Description, Quantity, Price, Status, Supplier Name\n");
            for (Product p : sortedProducts) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }
    }
}