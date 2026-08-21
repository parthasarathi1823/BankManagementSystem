import java.util.Scanner;

public class AdminInterface {

    public static void adminInterface(Bank bank, Scanner scan) {

        while (true) {

            System.out.println();
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║              ADMIN PANEL                 ║");
            System.out.println("╠══════════════════════════════════════════╣");
            System.out.println("║  1. Display all accounts                 ║");
            System.out.println("║  2. Update Customer Details              ║");
            System.out.println("║  3. Update Activity Status               ║");
            System.out.println("║  4. Exit                                 ║");
            System.out.println("╚══════════════════════════════════════════╝");

            System.out.print("Enter your choice: ");
            if (!scan.hasNextInt()) {
                System.out.println(">>> Invalid input! Please enter a number.");
                BankInterface.discardToken(scan);
                continue;
            }
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                case 1:
                    bank.displayAllAccounts();
                    break;

                case 2:
                    System.out.println();
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.println("║            Update Information              ║");
                    System.out.println("╠════════════════════════════════════════════╣");
                    System.out.println("║  Enter the new values.                     ║");
                    System.out.println("║  Enter '-' to keep the existing value.     ║");
                    System.out.println("╚════════════════════════════════════════════╝");
                    System.out.println();

                    System.out.print("Enter the Account number: ");
                    if (!scan.hasNextInt()) {
                        System.out.println(">>> Invalid account number!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    int accountNo = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter the name: ");
                    String name = scan.nextLine().trim();

                    System.out.print("Enter the phone: ");
                    String phone = scan.nextLine().trim();

                    bank.modifyAccountDetails(accountNo, name, phone);
                    break;

                case 3:
                    System.out.println();
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.println("║         Update Activity Status             ║");
                    System.out.println("╠════════════════════════════════════════════╣");
                    System.out.println("║  This will toggle Active / Inactive.       ║");
                    System.out.println("╚════════════════════════════════════════════╝");
                    System.out.println();

                    System.out.print("Enter Account Number: ");
                    if (!scan.hasNextInt()) {
                        System.out.println(">>> Invalid account number!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    int account = scan.nextInt();
                    scan.nextLine();

                    bank.changeActivity(account);
                    break;

                case 4:
                    System.out.println(">>> Returning to main menu!");
                    return;

                default:
                    System.out.println(">>> Invalid choice!");
            }
        }
    }
}
