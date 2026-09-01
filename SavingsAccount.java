class SavingsAccount extends Account{

	private static final double MIN_BALANCE = 1000.0;
	private static final double INTREST_RATE = 4.0;
	private static final String ACCOUNT_TYPE = "Savings Account";

	SavingsAccount(String name, String pan, String phone) {
		super(name, pan, phone);
		this.balance = MIN_BALANCE;
	}

	@Override
	public boolean withdraw(double amount){

		if(amount<=0){
			System.out.println("Invalid Amount!");
			return false;
		}
		if((balance-amount)< MIN_BALANCE){
			System.out.println("Minimum Balance need to be maintained!");
			return false;
		}
		balance -= amount;
		return true;
	}

	@Override
	public String getAccountType(){
		return ACCOUNT_TYPE;
	}
	
	@Override
	public double calculateIntrest(){
		return balance * (INTREST_RATE / 100.0);
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Account Type          : " + ACCOUNT_TYPE);
		System.out.println("Minimum Balance       : " + String.format("%.2f", MIN_BALANCE));
		System.out.println("Interest Rate         : " + INTREST_RATE + "%");
		System.out.println("Calculated Interest   : " + String.format("%.2f", calculateIntrest()));
	}
}
