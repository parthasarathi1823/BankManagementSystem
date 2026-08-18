import java.util.Map;
import java.util.HashMap;
class Bank
{
	Map<Integer,Account> accounts;
	static int acc_idx = 1001;

	public Bank() {

		accounts = new HashMap<>();
	}

	public void createAccount(String name,String phone, String pan){

		int accountNumber = acc_idx++;
		Account acc = new Account(name, phone, pan);
		accounts.put(accountNumber, acc);
		System.out.println("Account Sucessfully Created!\n Generated Account number : " +accountNumber);
	}

	public void deposite(int acc_no, double amount){

		if(amount <= 0.0){
			System.out.println("Please check the entered amount");
			return;
		}
		if(!accounts.containsKey(acc_no)){
			System.out.println("Account Not Found! Recheck the Account number");
			return;
		}
		Account acc = accounts.get(acc_no);

		if(!acc.getIs_active()){
			System.out.println("Your Account is currently Inactive");
			return;
		}
		acc.deposite(amount);
		System.out.printf("Deposite of %.2f is Successful!\n", amount);

	}

	public void withdrawal(int acc_no, double amount, String usr_pan) {

		if (amount <= 0) {
			System.out.println("Please check the entered amount");
			return;
		}

		if (!accounts.containsKey(acc_no)) {
			System.out.println("Account Not Found! Recheck the Account number");
			return;
		}

		Account acc = accounts.get(acc_no);

		if (!acc.getIs_active()) {
			System.out.println("Your Account is currently Inactive!");
			return;
		}

		if (!usr_pan.equals(acc.getPan())) {
			System.out.println("Invalid PAN!");
			return;
		}

		if (amount > acc.getBalance()) {
			System.out.println("Insufficient Balance!");
			return;
		}

		acc.withdrawal(amount);
		System.out.printf("Withdrawal of %.2f is Successful!\n", amount);
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

		if (!accounts.containsKey(senderAccNo)) {
			System.out.println("Sender Account Not Found! Recheck the Account number");
			return;
		}

		if (!accounts.containsKey(receiverAccNo)) {
			System.out.println("Receiver Account Not Found! Recheck the Account number");
			return;
		}

		Account sender = accounts.get(senderAccNo);
		Account receiver = accounts.get(receiverAccNo);

		if (!sender.getIs_active() || !receiver.getIs_active()) {
			System.out.println("One or Both Accounts are currently Inactive!");
			return;
		}

		if (!senderPan.equals(sender.getPan())) {
			System.out.println("Invalid PAN!");
			return;
		}

		if (sender.getBalance() < amount) {
			System.out.println("Insufficient Balance!");
			return;
		}

		sender.withdrawal(amount);
		receiver.deposite(amount);

		System.out.printf("Transfer of %.2f is Successful!\n", amount);
	}

	public void display(int acc_no){

		if(!accounts.containsKey(acc_no)){

			System.out.println("Account Not Found! Recheck the Account number");
            return;
		}
		Account acc = accounts.get(acc_no);
		acc.display();

	}

    public void displayAllAccounts(){
        if(accounts.isEmpty()){

            System.out.println("No Accounts Found");
            return;
        }

        for(Map.Entry<Integer,Account> entry : accounts.entrySet()){

         	Account acc = entry.getValue();
            System.out.println("------------------------------");
            System.out.println("Account No           : " + entry.getKey());
            System.out.println("Account Holder name  : " + acc.getName());
            System.out.println("Phone                : " + acc.getPhone());
            System.out.println("------------------------------");

        }
    }






}
