import java.util.LinkedHashMap;
import java.util.Map;

class Bank {

	private final Map<Integer, Account> accounts;
	private static int accountIndex = 1001;

	public Bank() {
		accounts = new LinkedHashMap<>();
	}

	public void createAccount(String name, String phone, String pan, int acc_code) {
		if (!validateName(name)) {
			System.out.println(">>> Invalid name! Use letters and spaces only.");
			System.out.println(">>> Account creation cancelled.");
			return;
		}
		if (!validatePhone(phone)) {
			System.out.println(">>> Invalid phone! Enter a 10-digit number starting with 6-9.");
			System.out.println(">>> Account creation cancelled.");
			return;
		}
		if (!validatePan(pan)) {
			System.out.println(">>> Invalid PAN! Format must be AAAAA9999A.");
			System.out.println(">>> Account creation cancelled.");
			return;
		}
		if (acc_code != 1 && acc_code != 2) {
			System.out.println(">>> Invalid account type! Please enter 1 or 2.");
			System.out.println(">>> Account creation cancelled.");
			return;
		}

		int accountNumber = accountIndex++;
		Account acc;

		if (acc_code == 1) {
			acc = new SavingsAccount(name, pan, phone);
		} else {
			acc = new CurrentAccount(name, pan, phone);
		}
		accounts.put(accountNumber, acc);

		System.out.println();
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║       Account Successfully Created!        ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║  Generated Account number : " + String.format("%-12s", accountNumber) + "║");
		System.out.println("║  Account Type               : " + String.format("%-12s", acc.getAccountType()) + "║");
		System.out.println("╚════════════════════════════════════════════╝");
	}

	public void deposit(int accountNo, double amount) {
		if (amount <= 0.0) {
			System.out.println("Please check the entered amount");
			return;
		}

		Account acc = accounts.get(accountNo);
		if (acc == null) {
			System.out.println("Account Not Found! Recheck the Account number");
			return;
		}

		if (!acc.isActive()) {
			System.out.println("Your Account is currently Inactive");
			return;
		}

		if (acc.deposit(amount)) {
			System.out.printf("Deposit of %.2f is Successful!%n", amount);
		} else {
			System.out.println("Deposit failed! Please check the entered amount");
		}
	}

	public void withdraw(int accountNo, double amount, String userPan) {
		if (amount <= 0) {
			System.out.println("Please check the entered amount");
			return;
		}

		Account acc = accounts.get(accountNo);
		if (acc == null) {
			System.out.println("Account Not Found! Recheck the Account number");
			return;
		}

		if (!acc.isActive()) {
			System.out.println("Your Account is currently Inactive!");
			return;
		}

		if (!userPan.equalsIgnoreCase(acc.getPan())) {
			System.out.println("Invalid PAN!");
			return;
		}


		if (acc.withdraw(amount)) {
			System.out.printf("Withdrawal of %.2f is Successful!%n", amount);
		}
	}

	public void transfer(int senderAccNo, String senderPan, int receiverAccNo, double amount) {
		if (amount <= 0) {
			System.out.println("Please check the amount!");
			return;
		}

		if (senderAccNo == receiverAccNo) {
			System.out.println("Sender and receiver accounts cannot be the same!");
			return;
		}

		Account sender = accounts.get(senderAccNo);
		if (sender == null) {
			System.out.println("Sender Account Not Found! Recheck the Account number");
			return;
		}

		Account receiver = accounts.get(receiverAccNo);
		if (receiver == null) {
			System.out.println("Receiver Account Not Found! Recheck the Account number");
			return;
		}

		if (!sender.isActive() || !receiver.isActive()) {
			System.out.println("One or Both Accounts are currently Inactive!");
			return;
		}

		if (!senderPan.equalsIgnoreCase(sender.getPan())) {
			System.out.println("Invalid PAN!");
			return;
		}


		if (sender.withdraw(amount)) {
			receiver.deposit(amount);
			System.out.printf("Transfer of %.2f is Successful!%n", amount);
		}
	}

	public void display(int accountNo) {
		Account acc = accounts.get(accountNo);
		if (acc == null) {
			System.out.println("Account Not Found! Recheck the Account number");
			return;
		}
		System.out.println("Account No           : " + accountNo);
		acc.display();
	}

	public void displayAllAccounts() {
		if (accounts.isEmpty()) {
			System.out.println("No Accounts Found");
			return;
		}

		for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
			Account acc = entry.getValue();
			System.out.println("------------------------------");
			System.out.println("Account No           : " + entry.getKey());
			System.out.println("Account Holder name  : " + acc.getName());
			System.out.println("Phone                : " + acc.getPhone());
			System.out.println("Status               : " + (acc.isActive() ? "Active" : "Inactive"));
			System.out.println("Account Type         : " + acc.getAccountType());
			System.out.println("------------------------------");
		}
	}

	public boolean validateName(String name) {
		return name != null && !name.trim().isEmpty() && name.trim().matches("[a-zA-Z ]+");
	}

	public boolean validatePhone(String phone) {
		return phone != null && phone.matches("[6-9][0-9]{9}");
	}

	public boolean validatePan(String pan) {
		return pan != null && pan.toUpperCase().matches("[A-Z]{5}[0-9]{4}[A-Z]");
	}

	public void modifyAccountDetails(int accountNo, String name, String phone) {
		Account acc = accounts.get(accountNo);
		if (acc == null) {
			System.out.println("Account Not Found! Recheck the Account number");
			return;
		}

		if ("-".equals(name) && "-".equals(phone)) {
			System.out.println("No changes requested.");
			return;
		}

		boolean updated = false;

		if (!"-".equals(name)) {
			if (validateName(name)) {
				acc.setName(name.trim());
				updated = true;
			} else {
				System.out.println("Invalid name! Name was not updated.");
			}
		}

		if (!"-".equals(phone)) {
			if (validatePhone(phone)) {
				acc.setPhone(phone);
				updated = true;
			} else {
				System.out.println("Invalid phone! Phone was not updated.");
			}
		}

		if (updated) {
			System.out.println("Profile Updated!");
			acc.display();
		} else {
			System.out.println("No changes were applied.");
		}
	}

	public void changeActivity(int accountNo) {
		Account acc = accounts.get(accountNo);
		if (acc == null) {
			System.out.println("Account Not Found! Recheck the Account number");
			return;
		}

		acc.setActive(!acc.isActive());
		System.out.println("Account Activity status changed!");
		System.out.println("Account Status: " + (acc.isActive() ? "Active" : "Inactive"));
	}
}
