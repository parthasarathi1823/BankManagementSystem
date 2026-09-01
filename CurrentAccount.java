class CurrentAccount extends Account{

	private static final double OVERDRAFT_LIMIT = 5000.0;
	private static final String ACCOUNT_TYPE = "Current Account";

	public CurrentAccount(String name, String pan, String phone){
		super(name, pan, phone);
		this.balance = 0.0;
	}

	@Override
	public boolean withdraw(double amount){

		if(amount<=0){
			System.out.println("Invalid Amount!");
			return false;
		} 
		if((balance-amount)<-OVERDRAFT_LIMIT){
			System.out.println("Overdraft Limit Exceeded!");
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
		return 0.0; //current account do not earn intrest
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Account Type          : " + ACCOUNT_TYPE);
		System.out.println("Overdraft Limit       : " + String.format("%.2f", OVERDRAFT_LIMIT));
		System.out.println("Calculated Interest   : " + String.format("%.2f", calculateIntrest()));
	}

}