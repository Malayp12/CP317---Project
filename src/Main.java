public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.readSupplierFile("data/SupplierFile.txt");
        manager.readProductFile("data/ProductFile.txt");
        manager.writeToFile("InventoryFile.txt");

        System.out.println("Processing completed. Check InventoryFile.txt.");
    }
}
