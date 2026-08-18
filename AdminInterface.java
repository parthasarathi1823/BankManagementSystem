import java.util.Scanner;

public class AdminInterface {

    public static void adminInterface(Bank bank, Scanner scan) {

        while (true) {

            System.out.println("\n========== ADMIN PANEL ==========");
            System.out.println("1. Display all accounts");
            System.out.println("2. Update Customer Details");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scan.next();
                continue;
            }
            int choice = scan.nextInt();

            switch (choice) {

                case 1:
                    bank.displayAllAccounts();
                    break;

                case 2:


                case 5:
                    System.out.println("Returning to panel control!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
