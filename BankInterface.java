import java.util.Scanner;

public class BankInterface {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== BANK MANAGEMENT SYSTEM ==========");
            System.out.println("Select the User Panel>");
            System.out.println("1. Admin Panel");
            System.out.println("2. Customer Panel");
            System.out.println("3. Exit Platform");
            System.out.println("============================================");

            System.out.print("Enter your choice: ");
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scan.next();
                continue;
            }
            int choice = scan.nextInt();

            switch (choice) {

                case 1:
                    AdminInterface.adminInterface(bank, scan);
                    break;

                case 2:
                    CustomerInterface.customerInterface(bank, scan);
                    break;

                case 3:
                    System.out.println("Thank you for using the Bank Management System!");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
