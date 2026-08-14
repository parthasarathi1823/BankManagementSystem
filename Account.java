public class Account 
{
	private String name;
	private String pan;
	private double balance;
	private String phone;
	private String accountType;
	private boolean is_active;
	
	// constructor : name, phone number is passed
	public Account(String name,String pan,String phone){
		
		this.name = name;
		this.pan = pan;
		this.balance = 1000.0;
		this.phone = phone;
		this.accountType = "savings";
		this.is_active = true;
	}

	public void deposite(double amount){
		
			balance+=amount;

	}

	public void withdrawal(double amount){

				balance-=amount;

	}
	
	public void display(){

		System.out.println("====== Account Details ======");
		System.out.println("Account Holder name : " +name);
		System.out.println("Pan no              : " +pan);
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
	
	public String getPan(){
		return pan;
	}
}
