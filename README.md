# Inventory Data Formatter

## Overview
The **Inventory Data Formatter** is a Java-based software designed to process and format inventory data. It reads product and supplier details from input files, sorts and structures the information using **Merge Sort, Priority Queue, and Linked List**, and outputs a well-organized inventory file.

## Features
✅ Reads data from **ProductFile.txt** and **SupplierFile.txt**
✅ Uses **Merge Sort** to arrange products by Product ID
✅ Utilizes **Priority Queue** and **Linked List** for efficient sorting and storage
✅ Implements **Offensive Programming** for robust error handling
✅ Outputs formatted inventory data to **InventoryFile.txt**

## Project Structure
```
CP317D_Project/
├── src/
│   ├── Main.java          # Runs the program
│   ├── InventoryManager.java # Handles file reading, sorting, writing
│   ├── Product.java       # Represents product details
│   ├── Supplier.java      # Represents supplier details
├── data/
│   ├── ProductFile.txt    # Input file for products
│   ├── SupplierFile.txt   # Input file for suppliers
├── InventoryFile.txt      # Output file (Generated after execution)
├── README.txt             # Project documentation
```

## Installation & Setup
### Prerequisites
- Install **Java JDK 17+**
- Install **VS Code** or any Java-supported IDE

### Running the Project
1. **Clone the Repository**
   ```sh
   git clone https://github.com/your-repo/inventory-data-formatter.git
   cd inventory-data-formatter
   ```
2. **Compile and Run the Project**
   ```sh
   cd src
   javac *.java
   java Main
   ```
3. **Check the Output**
   - Open `InventoryFile.txt` to view the formatted data

## Example Input & Output
### **ProductFile.txt**
```
2591, Camera, DSLR Camera, $799.9, 50, B, 7890
3374, Laptop, MacBook Pro, $1799.9, 30, A, 9512
```
### **SupplierFile.txt**
```
9512, Acme Corporation
7890, Samsung
```
### **InventoryFile.txt (Generated Output)**
```
Product ID, Product Name, Description, Quantity, Price, Status, Supplier Name
2591, Camera, DSLR Camera, 50, 799.9, B, Samsung
3374, Laptop, MacBook Pro, 30, 1799.9, A, Acme Corporation
```

## Error Handling & Logging
The program follows **Offensive Programming**, ensuring that:
- **Corrupt/invalid entries** are skipped with detailed logs.
- Errors are printed to the console without stopping execution.
- If an **input file is missing**, an error message is displayed.

## Contributors
- **Himanshu Mehta** – Java Implementation
- **Malay Patel** – Software Design & Testing
- **Sean Nguyen** – Documentation & Code Review
- **Shiraz Qasmi** – Project Architecture & Debugging

## License
This project is open-source and available under the **MIT License**.

---
