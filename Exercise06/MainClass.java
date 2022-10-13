package bu;

public class MainClass {

	public static void main(String[] args) {
		
		BankAccount sabaAccount = new BankAccount("Saba Jamalian", 200);
		//sabaAccount.owner = "Saba Jamalian";
		//sabaAccount.balance = 200;
		
		sabaAccount.display();
		
		sabaAccount.deposit(500);
		sabaAccount.withdraw(200);
		sabaAccount.deposit(300);
		sabaAccount.withdraw(1000);
		
		sabaAccount.display();
		
		
		BankAccount coleAccount = new BankAccount("Cole Edwards", 1000000);
		//coleAccount.owner = "Cole Edwards";
		//coleAccount.balance = 1000000;
		
		coleAccount.display();
	}

}
