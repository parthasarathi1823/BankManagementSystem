public class Account {

	private String name;
	private final String pan;
	private double balance;
	private String phone;
	private final String accountType;
	private boolean isActive;

	public Account(String name, String pan, String phone) {
		this.name = name;
		this.pan = pan;
		this.balance = 1000.0;
		this.phone = phone;
		this.accountType = "savings";
		this.isActive = true;
	}

	public boolean deposit(double amount) {
		if (amount <= 0) {
			return false;
		}
		balance += amount;
		return true;
	}

	public boolean withdraw(double amount) {
		if (amount <= 0 || amount > balance) {
			return false;
		}
		balance -= amount;
		return true;
	}

	public void display() {
		System.out.println("====== Account Details ======");
		System.out.println("Account Holder name : " + name);
		System.out.println("PAN No              : " + pan);
		System.out.println("Balance             : " + String.format("%.2f", balance));
		System.out.println("Phone               : " + phone);
		System.out.println("Account Type        : " + accountType);
		System.out.println("Activity Status     : " + (isActive ? "Active" : "Inactive"));
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public boolean isActive() {
		return isActive;
	}

	public double getBalance() {
		return balance;
	}

	public String getPan() {
		return pan;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setActive(boolean status) {
		this.isActive = status;
	}
}
