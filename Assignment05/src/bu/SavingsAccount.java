package bu;

public class SavingsAccount extends BankAccount{
	double annualInterestRate;
	double monthlyRate;
	public SavingsAccount(String owner, double balance, double annualInterestRate) {
		super(owner, balance);
		this.annualInterestRate=annualInterestRate;
	}
	public void depositMonthlyInterest() {
		this.monthlyRate=annualInterestRate/12.0;
		this.balance=balance+(balance*monthlyRate);
	}
	public void withdraw(int withdraw) {
		this.balance-=withdraw;
		if(this.balance<0) {
			this.balance+=withdraw;
			System.out.println("Error: Balance cannot be a negative number");
		}
	}
	
}

