import java.util.Scanner;

public class CustomerInterface {

    public static void customerInterface(Bank bank, Scanner scan) {

        while (true) {

            System.out.println();
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║             CUSTOMER PANEL               ║");
            System.out.println("╠══════════════════════════════════════════╣");
            System.out.println("║  1. Create Account                       ║");
            System.out.println("║  2. Deposit                              ║");
            System.out.println("║  3. Withdraw                             ║");
            System.out.println("║  4. Transfer                             ║");
            System.out.println("║  5. Display Account                      ║");
            System.out.println("║  6. Exit                                 ║");
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
                    System.out.println();
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.println("║              Create Account                ║");
                    System.out.println("╠════════════════════════════════════════════╣");
                    System.out.println("║  Name  : letters and spaces only           ║");
                    System.out.println("║  PAN   : format AAAAA9999A                 ║");
                    System.out.println("║  Phone : 10 digits, starting with 6-9      ║");
                    System.out.println("╚════════════════════════════════════════════╝");
                    System.out.println();

                    System.out.print("Enter account holder name: ");
                    String name = scan.nextLine().trim();

                    System.out.print("Enter PAN number: ");
                    String pan = scan.nextLine().trim().toUpperCase();

                    System.out.print("Enter phone number: ");
                    String phone = scan.nextLine().trim();

                    if (name.isEmpty() || pan.isEmpty() || phone.isEmpty()) {
                        System.out.println(">>> Name, PAN and phone cannot be empty!");
                        System.out.println(">>> Account creation cancelled.");
                        break;
                    }

                    bank.createAccount(name, phone, pan);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    if (!scan.hasNextInt()) {
                        System.out.println(">>> Invalid account number!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    int depositAccNo = scan.nextInt();

                    System.out.print("Enter amount to deposit: ");
                    if (!scan.hasNextDouble()) {
                        System.out.println(">>> Invalid amount!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    double depositAmount = scan.nextDouble();
                    scan.nextLine();

                    bank.deposit(depositAccNo, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    if (!scan.hasNextInt()) {
                        System.out.println(">>> Invalid account number!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    int withdrawAccNo = scan.nextInt();

                    System.out.print("Enter amount to withdraw: ");
                    if (!scan.hasNextDouble()) {
                        System.out.println(">>> Invalid amount!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    double withdrawAmount = scan.nextDouble();
                    scan.nextLine();

                    System.out.print("Enter PAN: ");
                    String withdrawPan = scan.nextLine().trim().toUpperCase();

                    bank.withdraw(withdrawAccNo, withdrawAmount, withdrawPan);
                    break;

                case 4:
                    System.out.print("Enter sender account number: ");
                    if (!scan.hasNextInt()) {
                        System.out.println(">>> Invalid account number!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    int senderAccNo = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter sender PAN: ");
                    String senderPan = scan.nextLine().trim().toUpperCase();

                    System.out.print("Enter receiver account number: ");
                    if (!scan.hasNextInt()) {
                        System.out.println(">>> Invalid account number!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    int receiverAccNo = scan.nextInt();

                    System.out.print("Enter amount to transfer: ");
                    if (!scan.hasNextDouble()) {
                        System.out.println(">>> Invalid amount!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    double transferAmount = scan.nextDouble();
                    scan.nextLine();

                    bank.transfer(
                        senderAccNo,
                        senderPan,
                        receiverAccNo,
                        transferAmount
                    );
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    if (!scan.hasNextInt()) {
                        System.out.println(">>> Invalid account number!");
                        BankInterface.discardToken(scan);
                        break;
                    }
                    int displayAccNo = scan.nextInt();
                    scan.nextLine();

                    bank.display(displayAccNo);
                    break;

                case 6:
                    System.out.println(">>> Returning to main menu!");
                    return;

                default:
                    System.out.println(">>> Invalid choice!");
            }
        }
    }
}
