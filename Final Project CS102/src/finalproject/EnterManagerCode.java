package finalproject;

import javax.swing.JOptionPane;

public class EnterManagerCode {

	public static void ManagerCode(){
		String input = JOptionPane.showInputDialog(null, "Enter Manager Code (Integers Only):");
		int inputInt = 0;
		if(input!=null) {
			try {
				inputInt = Integer.parseInt(input);
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			if(inputInt==8942) {
				System.out.println(true);
				//call manager JFrame class
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
