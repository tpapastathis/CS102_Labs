package finalproject;

import javax.swing.JOptionPane;

public class EnterManagerCode {
private static int correctCode = 1234;
	public static void ManagerCode(){
		String input = JOptionPane.showInputDialog(null, "Enter Manager Code (Integers Only):");
		int inputInt = 0;
		if(input!=null) {
			try {
				inputInt = Integer.parseInt(input);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Entry Was Not An Integer");
			}
			if(inputInt==correctCode) {
				ManagerWindow window = new ManagerWindow();
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid Manager Code");
				ManagerCode();
			}
		}
	}
	public static void main(String[] args){
		ManagerCode();
	}
}
