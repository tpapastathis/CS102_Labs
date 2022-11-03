package bu;

public class MainClass {

	public static void main(String[] args) {
		SavingsAccount joe = new SavingsAccount("Joe", 100, 1);
		CheckingAccount emily = new CheckingAccount("Emily", 200, 10);
		
		emily.deposit(50);
		joe.withdraw(25);
		
		emily.processCheck(50);
		emily.withdraw(100);
		joe.deposit(100);
		
		SavingsAccount sam = new SavingsAccount("Sam", 250, 0.5);
		joe.depositMonthlyInterest();
		sam.depositMonthlyInterest();
		
		emily.withdraw(500);
		joe.withdraw(500);
		
		joe.display();
		emily.display();
		sam.display();
	}

}
