package bu;

public class TowerOfHanoi {
	public static int ops = 0;
	public static void main(String args[]) {
		towerOfHanoi(6, "A", "B", "C", "D");
		System.out.println("Total operations: "+ops);
	}
	
	static void towerOfHanoi(int numOfDisks, String from, String to, String helper1, String helper2) {
		if(numOfDisks==0) 
			return;
		if(numOfDisks==1) {
			System.out.println("Move disk "+numOfDisks+" from "+from+" to "+to);
			ops++;
			return;
		}
		towerOfHanoi(numOfDisks-2, from, helper1, helper2, to);
		System.out.println("Move disk "+(numOfDisks-1)+" from "+from+" to "+helper2);
		ops++;
		System.out.println("Move disk "+numOfDisks+" from "+from+" to "+to);
		ops++;
		System.out.println("Move disk "+(numOfDisks-1)+" from "+helper2+" to "+to);
		ops++;
		towerOfHanoi(numOfDisks-2, helper1, to, from, helper2);
	}

}
