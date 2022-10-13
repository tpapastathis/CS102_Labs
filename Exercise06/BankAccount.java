package bu;

public class BankAccount {
	
	String owner;
	double balance;
	
	BankAccount(String owner, double balance){
		this.owner = owner;
		this.balance = balance;
	}
	
	void deposit(double amount) {
		this.balance+=amount;
	}
	
	void withdraw(double amount) {
		
		this.balance-=amount;
		
		if(this.balance<0) {
			System.out.println("Account is overdraft!");
		}
	}
	
	void display() {
		System.out.println("====================================");
		System.out.println("Owner: "+owner);
		System.out.println("Balance: "+balance);
		System.out.println("====================================");
	}

}
