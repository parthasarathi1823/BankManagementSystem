import java.util.Scanner;

public class BankInterface {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {

            System.out.println("\n========== BANK MANAGEMENT SYSTEM ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Display Account");
            System.out.println("6. Exit");
            System.out.println("============================================");

            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = scan.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = scan.nextLine();

                    bank.createAccount(name, phone);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccNo = scan.nextInt();

                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scan.nextDouble();

                    bank.deposite(depositAccNo, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawalAccNo = scan.nextInt();

                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scan.nextDouble();

                    bank.withdrawal(withdrawalAccNo, withdrawalAmount);
                    break;

                case 4:
                    System.out.print("Enter sender account number: ");
                    int senderAccNo = scan.nextInt();

                    System.out.print("Enter receiver account number: ");
                    int receiverAccNo = scan.nextInt();

                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scan.nextDouble();

                    bank.transfer(
                        senderAccNo,
                        receiverAccNo,
                        transferAmount
                    );
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    int displayAccNo = scan.nextInt();

                    bank.display(displayAccNo);
                    break;

                case 6:
                    System.out.println("Thank you for using the Bank Management System!");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}