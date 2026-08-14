import java.util.Map;
import java.util.HashMap;

class Bank	
{
	Map<Integer,Account> accounts;
	static int acc_idx = 1001;

	public Bank() {

		accounts = new HashMap<>();
	}
		
	public void createAccount(String name,String phone){
		
		int accountNumber = acc_idx++;
		Account acc = new Account(name, phone);
		accounts.put(accountNumber, acc);
		System.out.println("Account Sucessfully Created!\n Generated Account number : " +accountNumber);
	}

	public void deposite(int acc_no, double amount){
		if (accounts.containsKey(acc_no)){
			
			Account acc = accounts.get(acc_no);

			if(acc.getIs_active()){

				acc.deposite(amount);
				System.out.printf("Deposite of %.2f is Sucessful!\n", amount);
			
			}else{
				System.out.println("Your Account is currently Inactive!");
			}
		}	
		else {

			System.out.println("Account Not Found! Recheck the Account number");
							
		}
	}

	public void withdrawal(int acc_no, double amount){
		
		if (accounts.containsKey(acc_no)){
			Account acc = accounts.get(acc_no);

			if (acc.getIs_active()){

				acc.withdrawal(amount);
				System.out.printf("Withdrawal of %.2f is Sucessful!\n", amount);
			}
			else {
				System.out.println("Your Account is currently Inactive!");
			}
		}
		else{

			System.out.println("Account Not Found! Recheck the Account number");
		}

	}
	
	public void transfer(int acc_no1, int acc_no2, double amount){

		if(accounts.containsKey(acc_no1) && accounts.containsKey(acc_no2)){

			Account acc1 = accounts.get(acc_no1);
			Account acc2 = accounts.get(acc_no2);

			if (acc1.getIs_active() && acc2.getIs_active()){

				if (acc1.getBalance() >= amount){
					acc1.withdrawal(amount);
					acc2.deposite(amount);
				
					System.out.printf("Transfer of %.2f is Sucessful!\n",amount);
				}
				else{
					System.out.println("Insufficient Amount!");
				}
			}
			else {
				
				System.out.println("One or Both Accounts are currently Inactive!");
			}
		}
		else{

			System.out.println("One or Both Accounts Not Found! Recheck the Account number");
		
		}
	}

	public void display(int acc_no){
		
		if(accounts.containsKey(acc_no)){

			Account acc = accounts.get(acc_no);
			acc.display();
		}
		else{
			System.out.println("Account Not Found! Recheck the Account number");
		}	
	}

}
