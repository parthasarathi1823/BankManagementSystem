public class Account 
{
	private String name;
	private double balance;
	private String phone;
	private String accountType;
	private boolean is_active;
	
	// constructor : name, phone number is passed
	public Account(String name,String phone){
		
		this.name = name;
		this.balance = 1000.0;
		this.phone = phone;
		this.accountType = "savings";
		
		this.is_active = true;
	}

	public void deposite(double amount){
		
		if(amount>0){
			balance+=amount;
	
		}

	}

	public void withdrawal(double amount){

		if(amount>0 && balance>=amount){
			balance-=amount;
		
		}
	}
	
	public void display(){

		System.out.println("====== Account Details ======");
		System.out.println("Account Holder name : " +name);
		System.out.println("Balance             : " +balance);
		System.out.println("Phone               : " +phone);
		System.out.println("Account Type        : " +accountType);
		System.out.println("Activity Status     : " +is_active);
	}
	
	public boolean getIs_active(){
		return is_active;
	}

	public double getBalance(){
		return balance;
	}
	
}
