import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//////////////////////////////////////////    MainClass   /////////////////////////////////////////////////////////////

public class Main {

    static Scanner input = new Scanner(System.in);

    static User user = new User("INFAS", "1001");

    static StockManagement system = new StockManagement();

    public static void main(String[] args) {
        loginPage();
    }

    ///////////////////////////////////////////////Login////////////////////////////////////////////////////////////////

    public static void loginPage() {

        clearConsole();

        System.out.println("+------------------------------------------------------------+");
        System.out.println("|                        LOGIN PAGE                          |");
        System.out.println("+------------------------------------------------------------+");
        System.out.println();

        while (true) {

            System.out.print("User Name : ");
            String uName = input.nextLine();

            if (user.verifyUser(uName)) {
                break;
            }

            System.out.println("User name is invalid. Please try again!\n");
        }

        while (true) {

            System.out.print("\nPassword : ");
            String pass = input.nextLine();

            if (user.verifyPassword(pass)) {
                break;
            }

            System.out.println("Password is incorrect. Please try again!\n");
        }

        System.out.println();
        System.out.println("Hey " + user.getUserName());

        homepage();
    }

   /////////////////////////////////////////////Home Page ///////////////////////////////////////////////////////////////
   
    public static void homepage() {

        while (true) {

            clearConsole();

            System.out.println("+------------------------------------------------------------+");
            System.out.println("|         WELCOME TO IJSE STOCK MANAGEMENT SYSTEM            |");
            System.out.println("+------------------------------------------------------------+");

            System.out.println("[1] Change the Credentials\t\t[2] Supplier Manage");
            System.out.println("[3] Stock Manage\t\t\t[4] Log out");
            System.out.println("[5] Exit the System");

            System.out.print("\nEnter an option to continue > ");

            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:
                    credentialManage();
                    break;

                case 2:
                    supplierManage();
                    break;

                case 3:
                    stockManage();
                    break;

                case 4:
                    loginPage();
                    return;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("\nInvalid Option!");
                    input.nextLine();
            }
        }
    }

    // ============================================================
    // CREDENTIAL MANAGEMENT
    // ============================================================

    public static void credentialManage() {

        clearConsole();

        System.out.println("+------------------------------------------------------------+");
        System.out.println("|                CHANGE CREDENTIAL MANAGE                    |");
        System.out.println("+------------------------------------------------------------+");

        while (true) {

            System.out.print(
                    "Please enter the user name to verify it's you: "
            );

            String verifyUser = input.nextLine();

            if (user.verifyUser(verifyUser)) {
                break;
            }

            System.out.println("Invalid user name. Try again!\n");
        }

        while (true) {

            System.out.print("Enter your current password : ");

            String currentPassword = input.nextLine();

            if (user.verifyPassword(currentPassword)) {
                break;
            }

            System.out.println("Incorrect password. Try again!\n");
        }

        System.out.print("Enter your new password : ");

        String newPassword = input.nextLine();

        user.changePassword(newPassword);

        System.out.println("\nPassword changed successfully...!");

        System.out.print("Do you want to go home page (Y/N) : ");

        String choice = input.nextLine();

        if (!choice.equalsIgnoreCase("Y")) {
            System.exit(0);
        }
    }

    // ============================================================
    // SUPPLIER MANAGEMENT
    // ============================================================

    public static void supplierManage() {

        while (true) {

            clearConsole();

            System.out.println("+------------------------------------------------------------+");
            System.out.println("|                        SUPPLIER MANAGE                     |");
            System.out.println("+------------------------------------------------------------+");

            System.out.println("[1] Add Supplier\t\t[2] Update Supplier");
            System.out.println("[3] Delete Supplier\t\t[4] View Suppliers");
            System.out.println("[5] Search Supplier\t\t[6] Home Page");

            System.out.print("\nEnter an option to continue > ");

            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:
                    addSupplier();
                    break;

                case 2:
                    updateSupplier();
                    break;

                case 3:
                    deleteSupplier();
                    break;

                case 4:
                    viewSupplier();
                    break;

                case 5:
                    searchSupplier();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Option!");
                    input.nextLine();
            }
        }
    }

    // ============================================================
    // ADD SUPPLIER
    // ============================================================

    public static void addSupplier() {

        clearConsole();

        System.out.println("=====================================");
        System.out.println("|           ADD SUPPLIER             |");
        System.out.println("=====================================");

        System.out.print("Supplier ID : ");
        String id = input.nextLine();

        if (system.searchSupplier(id) != null) {

            System.out.println("Supplier ID already exists!");
            input.nextLine();
            return;
        }

        System.out.print("Supplier Name : ");
        String name = input.nextLine();

        Supplier supplier = new Supplier(id, name);

        system.addSupplier(supplier);

        input.nextLine();
    }

    // ============================================================
    // VIEW SUPPLIER
    // ============================================================

    public static void viewSupplier() {

        clearConsole();

        System.out.println("=======================================");
        System.out.println("|           VIEW SUPPLIER             |");
        System.out.println("=======================================");

        system.viewSuppliers();

        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }

    // ============================================================
    // SEARCH SUPPLIER
    // ============================================================

    public static void searchSupplier() {

        clearConsole();

        System.out.println("+--------------------------------------------------+");
        System.out.println("|                SEARCH SUPPLIER                   |");
        System.out.println("+--------------------------------------------------+");

        System.out.print("\nEnter Supplier ID : ");

        String id = input.nextLine();

        Supplier supplier = system.searchSupplier(id);

        if (supplier != null) {

            System.out.println("\nSupplier Found");
            System.out.println("Supplier ID : " + supplier.getSupplierId());
            System.out.println("Supplier Name : " + supplier.getSupplierName());

        } else {

            System.out.println("Supplier Not Found...");
        }

        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }

    // ============================================================
    // UPDATE SUPPLIER
    // ============================================================

    public static void updateSupplier() {

        clearConsole();

        System.out.println("+--------------------------------------------------+");
        System.out.println("|               UPDATE SUPPLIER                    |");
        System.out.println("+--------------------------------------------------+");

        System.out.print("\nEnter Supplier ID : ");

        String id = input.nextLine();

        Supplier supplier = system.searchSupplier(id);

        if (supplier == null) {

            System.out.println("Supplier Not Found...");
            input.nextLine();
            return;
        }

        System.out.println(
                "Current Name : " + supplier.getSupplierName()
        );

        System.out.print("New Name : ");

        String newName = input.nextLine();

        system.updateSupplier(id, newName);

        System.out.println("Supplier Updated Successfully...");

        input.nextLine();
    }

    
    /////////////////////////////////////////// DELETE SUPPLIER/////////////////////////////////////////////////
    

    public static void deleteSupplier() {

        clearConsole();

        System.out.println("+--------------------------------------------------+");
        System.out.println("|                 DELETE SUPPLIER                  |");
        System.out.println("+--------------------------------------------------+");

        System.out.print("\nEnter Supplier ID : ");

        String id = input.nextLine();

        if (system.deleteSupplier(id)) {

            System.out.println("Supplier Deleted Successfully...");

        } else {

            System.out.println("Supplier Not Found...");
        }

        input.nextLine();
    }

    
    /////////////////////////////////////// STOCK MANAGEMENT///////////////////////////////////////////////////////////
    

    public static void stockManage() {

        while (true) {

            clearConsole();

            System.out.println("+------------------------------------------------------------+");
            System.out.println("|                  STOCK MANAGEMENT                          |");
            System.out.println("+------------------------------------------------------------+");

            System.out.println(
                    "[1] Manage Item Categories\t\t[2] Add Item"
            );

            System.out.println(
                    "[3] Get Items Supplier Wise\t\t[4] View Items"
            );

            System.out.println(
                    "[5] Rank Items Per Unit Price\t\t[6] Home Page"
            );

            System.out.print("\nEnter an option to continue > ");

            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:
                    manageItemCategories();
                    break;

                case 2:
                    addItem();
                    break;

                case 3:
                    getItemsSupplierWise();
                    break;

                case 4:
                    viewItems();
                    break;

                case 5:
                    rankItemsPerUnitPrice();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Option......!");
                    input.nextLine();
            }
        }
    }

    ////////////////////////////////////////Category Management////////////////////////////////////////////////////////////////////

    public static void manageItemCategories() {

        while (true) {

            clearConsole();

            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                 MANAGE ITEM CATEGORY                   |");
            System.out.println("+--------------------------------------------------------+");

            System.out.println(
                    "[1] Add New Item Category\t\t[2] Delete Item Category"
            );

            System.out.println(
                    "[3] Update Item Category\t\t[4] Stock Management"
            );

            System.out.print("\nEnter an option to continue > ");

            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:
                    addNewItemCategory();
                    break;

                case 2:
                    deleteItemCategory();
                    break;

                case 3:
                    updateItemCategory();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("\nInvalid Option...");
                    input.nextLine();
            }
        }
    }

    //////////////////////////////////////////////////Add Category /////////////////////////////////////////////////

    public static void addNewItemCategory() {

        clearConsole();

        System.out.println("+--------------------------------------------------+");
        System.out.println("|               ADD NEW ITEM CATEGORY              |");
        System.out.println("+--------------------------------------------------+");

        System.out.print("Enter the new item category : ");

        String name = input.nextLine();

        Category category = new Category(name);

        if (system.addCategory(category)) {

            System.out.println("Added Successfully!");

        } else {

            System.out.println(
                    "That item category already exists."
            );
        }

        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }

    //////////////////////////////////////////////Delete Category //////////////////////////////////////////////////////////////////////

    public static void deleteItemCategory() {

        clearConsole();

        System.out.println("+--------------------------------------------------+");
        System.out.println("|             DELETE ITEM CATEGORY                 |");
        System.out.println("+--------------------------------------------------+");

        System.out.print("Enter Delete item category : ");

        String name = input.nextLine();

        if (system.deleteCategory(name)) {

            System.out.println("Delete Successfully!");

        } else {

            System.out.println("Item Category Not Found!");
        }

        input.nextLine();
    }

    // ============================================================
    // UPDATE CATEGORY
    // ============================================================

    public static void updateItemCategory() {

        clearConsole();

        System.out.println("+--------------------------------------------------+");
        System.out.println("|              UPDATE ITEM CATEGORY                |");
        System.out.println("+--------------------------------------------------+");

        System.out.print("Enter Update item category : ");

        String oldName = input.nextLine();

        Category category = system.findCategory(oldName);

        if (category == null) {

            System.out.println("Item Category Not Found!");
            input.nextLine();
            return;
        }

        System.out.println(
                "Currently available item category : "
                        + category.getCategoryName()
        );

        System.out.print("Enter New Item Category : ");

        String newName = input.nextLine();

        if (system.updateCategory(oldName, newName)) {

            System.out.println("Update Successfully!");

        } else {

            System.out.println("New category already exists!");
        }

        input.nextLine();
    }

    ////////////////////////////////////////Add Item //////////////////////////////////////////////////////////////////

    public static void addItem() {

        clearConsole();

        System.out.println("+------------------------------------------------------+");
        System.out.println("|                    ADD ITEM                          |");
        System.out.println("+------------------------------------------------------+");

        if (!system.hasCategories()) {

            System.out.println(
                    "OOPS! You don't have any item categories."
            );

            System.out.println(
                    "Please add a category first."
            );

            input.nextLine();
            return;
        }

        if (!system.hasSuppliers()) {

            System.out.println(
                    "You don't have any suppliers."
            );

            System.out.println(
                    "Please add a supplier first."
            );

            input.nextLine();
            return;
        }

        System.out.print("Item Code : ");

        String code = input.nextLine();

        if (system.searchItem(code) != null) {

            System.out.println("Item code already exists!");
            input.nextLine();
            return;
        }

        System.out.print("Description : ");

        String description = input.nextLine();

        System.out.print("Unit Price : ");

        double price = input.nextDouble();

        System.out.print("Quantity : ");

        int quantity = input.nextInt();

        input.nextLine();

        System.out.print("Category : ");

        String categoryName = input.nextLine();

        Category category = system.findCategory(categoryName);

        if (category == null) {

            System.out.println("Category Not Found!");
            input.nextLine();
            return;
        }

        System.out.print("Supplier ID : ");

        String supplierId = input.nextLine();

        Supplier supplier = system.searchSupplier(supplierId);

        if (supplier == null) {

            System.out.println("Supplier Not Found!");
            input.nextLine();
            return;
        }

        Item item = new Item(
                code,
                description,
                price,
                quantity,
                category,
                supplier
        );

        if (system.addItem(item)) {

            System.out.println("\nItem Added Successfully!");

        } else {

            System.out.println("\nItem Code Already Exists!");
        }

        input.nextLine();
    }

   
    /////////////////////////////////////////////SUPPLIER WISE ITEMS////////////////////////////////////////////////////////////////
   

    public static void getItemsSupplierWise() {

        clearConsole();

        System.out.println("+------------------------------------------------------+");
        System.out.println("|                  SUPPLIER WISE ITEMS                 |");
        System.out.println("+------------------------------------------------------+");

        System.out.print("\nEnter Supplier ID : ");

        String supplierId = input.nextLine();

        system.getItemsSupplierWise(supplierId);

        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }

    
    /////////////////////////////////////////////VIEW ITEMS /////////////////////////////////////////////////////////////////////////
     
    public static void viewItems() {

        clearConsole();

        System.out.println("+------------------------------------------------------+");
        System.out.println("|                     VIEW ITEMS                       |");
        System.out.println("+------------------------------------------------------+");

        system.viewItems();

        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }

    
    ////////////////////////////////////////////RANK ITEMS////////////////////////////////////////////////////////////////////

    public static void rankItemsPerUnitPrice() {

        clearConsole();

        System.out.println("+------------------------------------------------------+");
        System.out.println("|                  RANKED UNIT PRICE                   |");
        System.out.println("+------------------------------------------------------+");

        system.rankItemsPerUnitPrice();

        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }

    // ============================================================
    // CLEAR CONSOLE
    // ============================================================

    private static void clearConsole() {

        try {

            new ProcessBuilder(
                    "cmd",
                    "/c",
                    "cls"
            )
            .inheritIO()
            .start()
            .waitFor();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}



//////////////////////////////////////////////////USER CLASS///////////////////////////////////////////////////////////


class User {

    private String userName;
    private String password;

    public User(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public boolean login(String userName, String password) {

        return this.userName.equals(userName)
                && this.password.equals(password);
    }

    public boolean verifyUser(String userName) {

        return this.userName.equals(userName);
    }

    public boolean verifyPassword(String password) {

        return this.password.equals(password);
    }

    public void changePassword(String newPassword) {

        this.password = newPassword;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }
}



///////////////////////////////////////////////SUPPLIER CLASS//////////////////////////////////////////////////////////////////

class Supplier {

    private String supplierId;
    private String supplierName;

    public Supplier(String supplierId, String supplierName) {

        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public String getSupplierId() {

        return supplierId;
    }

    public void setSupplierId(String supplierId) {

        this.supplierId = supplierId;
    }

    public String getSupplierName() {

        return supplierName;
    }

    public void setSupplierName(String supplierName) {

        this.supplierName = supplierName;
    }
}



/////////////////////////////////////////////////CATEGORY CLASS////////////////////////////////////////////////////////////


class Category {

    private String categoryName;

    public Category(String categoryName) {

        this.categoryName = categoryName;
    }

    public String getCategoryName() {

        return categoryName;
    }

    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;
    }
}



//////////////////////////////////////////////////////////ITEM CLASS///////////////////////////////////////////////////////////////


class Item {

    private String itemCode;
    private String description;
    private double unitPrice;
    private int quantity;

    private Category category;
    private Supplier supplier;

    public Item(
            String itemCode,
            String description,
            double unitPrice,
            int quantity,
            Category category,
            Supplier supplier) {

        this.itemCode = itemCode;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.category = category;
        this.supplier = supplier;
    }

    public String getItemCode() {

        return itemCode;
    }

    public void setItemCode(String itemCode) {

        this.itemCode = itemCode;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public double getUnitPrice() {

        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {

        this.unitPrice = unitPrice;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public Category getCategory() {

        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public Supplier getSupplier() {

        return supplier;
    }

    public void setSupplier(Supplier supplier) {

        this.supplier = supplier;
    }
}



/////////////////////////////////////////////STOCK MANAGEMENT CLASS/////////////////////////////////////////////////////

class StockManagement {

    private ArrayList<Supplier> suppliers;
    private ArrayList<Category> categories;
    private ArrayList<Item> items;

    public StockManagement() {

        suppliers = new ArrayList<>();
        categories = new ArrayList<>();
        items = new ArrayList<>();
    }

    
    ///////////////////////////////////////////////////SUPPLIER///////////////////////////////////////////////////////////
    

    public void addSupplier(Supplier supplier) {

        suppliers.add(supplier);

        System.out.println("\nSupplier Added Successfully...");
    }

    public Supplier searchSupplier(String id) {

        for (Supplier supplier : suppliers) {

            if (supplier.getSupplierId().equalsIgnoreCase(id)) {

                return supplier;
            }
        }

        return null;
    }

    public boolean updateSupplier(
            String id,
            String newName) {

        Supplier supplier = searchSupplier(id);

        if (supplier != null) {

            supplier.setSupplierName(newName);

            return true;
        }

        return false;
    }

    public boolean deleteSupplier(String id) {

        Supplier supplier = searchSupplier(id);

        if (supplier != null) {

            suppliers.remove(supplier);

            return true;
        }

        return false;
    }

    public void viewSuppliers() {

        if (suppliers.isEmpty()) {

            System.out.println("No Suppliers Found...");
            return;
        }

        System.out.println("Supplier ID\tSupplier Name");
        System.out.println("--------------------------------------");

        for (Supplier supplier : suppliers) {

            System.out.println(
                    supplier.getSupplierId()
                            + "\t\t"
                            + supplier.getSupplierName()
            );
        }
    }

    public boolean hasSuppliers() {

        return !suppliers.isEmpty();
    }

    

    //////////////////////////////////////////////// CATEGORY ////////////////////////////////////////////////////
   

    public boolean addCategory(Category category) {

        for (Category existing : categories) {

            if (existing.getCategoryName()
                    .equalsIgnoreCase(
                            category.getCategoryName())) {

                return false;
            }
        }

        categories.add(category);

        return true;
    }

    public boolean deleteCategory(String name) {

        Category category = findCategory(name);

        if (category != null) {

            categories.remove(category);

            return true;
        }

        return false;
    }

    public Category findCategory(String name) {

        for (Category category : categories) {

            if (category.getCategoryName()
                    .equalsIgnoreCase(name)) {

                return category;
            }
        }

        return null;
    }

    public boolean updateCategory(
            String oldName,
            String newName) {

        Category category = findCategory(oldName);

        if (category == null) {

            return false;
        }

        if (findCategory(newName) != null) {

            return false;
        }

        category.setCategoryName(newName);

        return true;
    }

    public boolean hasCategories() {

        return !categories.isEmpty();
    }

   //////////////////////////////////////////////////////Item///////////////////////////////////////////////////////////////

    public boolean addItem(Item item) {

        for (Item existing : items) {

            if (existing.getItemCode()
                    .equalsIgnoreCase(item.getItemCode())) {

                return false;
            }
        }

        items.add(item);

        return true;
    }

    public Item searchItem(String itemCode) {

        for (Item item : items) {

            if (item.getItemCode()
                    .equalsIgnoreCase(itemCode)) {

                return item;
            }
        }

        return null;
    }

    public void viewItems() {

        if (items.isEmpty()) {

            System.out.println("No Items Found...");
            return;
        }

        System.out.println(
                "+----------+----------------------+------------+------------+----------------+"
        );

        System.out.printf(
                "| %-8s | %-20s | %-10s | %-10s | %-14s |%n",
                "CODE",
                "DESCRIPTION",
                "PRICE",
                "QTY",
                "CATEGORY"
        );

        System.out.println(
                "+----------+----------------------+------------+------------+----------------+"
        );

        for (Item item : items) {

            System.out.printf(
                    "| %-8s | %-20s | %-10.2f | %-10d | %-14s |%n",
                    item.getItemCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQuantity(),
                    item.getCategory().getCategoryName()
            );
        }

        System.out.println(
                "+----------+----------------------+------------+------------+----------------+"
        );
    }

   //////////////////////////////////////////////Supplier Wise Items///////////////////////////////////////////////////////////////


    public void getItemsSupplierWise(String supplierId) {

        boolean found = false;

        Supplier supplier = searchSupplier(supplierId);

        if (supplier == null) {

            System.out.println("Supplier Not Found...");
            return;
        }

        System.out.println(
                "\nItems supplied by: "
                        + supplier.getSupplierName()
        );

        for (Item item : items) {

            if (item.getSupplier()
                    .getSupplierId()
                    .equalsIgnoreCase(supplierId)) {

                System.out.println(
                        item.getItemCode()
                                + " | "
                                + item.getDescription()
                                + " | "
                                + item.getUnitPrice()
                                + " | Qty: "
                                + item.getQuantity()
                                + " | "
                                + item.getCategory()
                                .getCategoryName()
                );

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No items found for this supplier."
            );
        }
    }

    /////////////////////////////////////////////////////Rank Items///////////////////////////////////////////////////////////////


    public void rankItemsPerUnitPrice() {

        if (items.isEmpty()) {

            System.out.println("No Items Found...");
            return;
        }

        ArrayList<Item> sortedItems =
                new ArrayList<>(items);

        sortedItems.sort(
                Comparator.comparingDouble(
                        Item::getUnitPrice
                )
        );

        System.out.println(
                "+----------+----------------------+------------+------------+----------------+"
        );

        System.out.printf(
                "| %-8s | %-20s | %-10s | %-10s | %-14s |%n",
                "CODE",
                "DESCRIPTION",
                "PRICE",
                "QTY",
                "CATEGORY"
        );

        System.out.println(
                "+----------+----------------------+------------+------------+----------------+"
        );

        for (Item item : sortedItems) {

            System.out.printf(
                    "| %-8s | %-20s | %-10.2f | %-10d | %-14s |%n",
                    item.getItemCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQuantity(),
                    item.getCategory().getCategoryName()
            );
        }

        System.out.println(
                "+----------+----------------------+------------+------------+----------------+"
        );
    }
}