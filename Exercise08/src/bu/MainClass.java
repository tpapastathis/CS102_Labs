package bu;

public class MainClass {
	public static void main(String args[]) {
		towerOfHanoi(5, "A", "B", "C");
	}
	
	static void towerOfHanoi(int numOfDisks, String from, String to, String helper) {
		if(numOfDisks==0) {
			return;
		}

		towerOfHanoi(numOfDisks-1, from, helper, to);
		System.out.println("Move disk "+numOfDisks+" from "+from+" to "+to);
		towerOfHanoi(numOfDisks-1, helper, to, from);
	}

}
