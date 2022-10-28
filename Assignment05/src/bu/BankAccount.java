package bu;

public class BankAccount {
	String owner;
	double balance;
	public BankAccount(String owner, double balance) {
		this.owner=owner;
		this.balance=balance;
	}
	public void display() {
		System.out.println("Owner: "+this.owner);
		System.out.println("Balance: "+this.balance);
	}
	public void deposit(double deposit) {
		this.balance+=deposit;
	}
	public void withdraw(double withdraw) {
		this.balance-=withdraw;
	}
	
	

}
