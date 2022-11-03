package bu;

public class CheckingAccount extends BankAccount{
	double insuffcientFundsFee;
	public CheckingAccount(String owner, double balance, double insufficientFundsFee) {
		super(owner, balance);
		this.insuffcientFundsFee=insufficientFundsFee;
		
	}
	public void processCheck(double checkAmount) {
		this.balance+=checkAmount;
	}
	public void withdraw(double withdraw){
		this.balance-=withdraw;
		if(this.balance<0) {
			this.balance-=insuffcientFundsFee;
		}
	}

}
