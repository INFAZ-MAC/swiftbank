package hdse77jdbc.view;

import java.util.Scanner;
import hdse77jdbc.view.CustomerView;
import hdse77jdbc.view.ItemView;
import hdse77jdbc.view.OrderView;


public class MainMenuView {
    
    private static final Scanner scanner = new Scanner(System.in);
    static CustomerView CustomerView=new CustomerView();
    static ItemView ItemView=new ItemView();
    static OrderView OrderView=new OrderView();

    
    public  void loadMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n======================================================================");
            System.out.println("                              MAIN MENU");
            System.out.println("======================================================================");

            System.out.println("  1. Customer Management");
            System.out.println("  2. Item Management");
            System.out.println("  3. Place Order");
            System.out.println("  0. Exit");

            System.out.println("======================================================================");
            System.out.print("  Select Option [0-3]: ");

            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    CustomerView.loadCustomerMenu();
                    break;

                case "2":
                    ItemView.loadItemMenu();
                    break;

                case "3":
                    OrderView.loadOrderMenu();
                    break;

                case "0":
                    running = false;
                    System.out.println("\nApplication Exited Successfully.");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
}