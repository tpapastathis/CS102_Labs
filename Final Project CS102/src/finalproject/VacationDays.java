package finalproject;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class VacationDays extends JFrame implements ActionListener{
	final int SIZE = 400;
	int daysAvailable;
	String name;
	static ArrayList<String> dates = new ArrayList<String>();
	
	public VacationDays(String nameInput, int daysInt){
		super(nameInput+" - Vacation Request");
		this.daysAvailable = daysInt;
		this.name = nameInput;
		this.dates = dates;
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		setSize(SIZE,SIZE/4);
		
		setLocationRelativeTo(null);
		toFront();
		requestFocus();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel welcome = new JLabel("Welcome "+nameInput+"! \nYou have "+this.daysAvailable+" vacation days remaining.");
		gbc.gridx = 0;
		gbc.gridy = 10;
		add(welcome, gbc);
		
		JButton days = new JButton("Request vacation date(s)");
		gbc.gridx = 0;
		gbc.gridy = -10;
		add(days, gbc);
		days.addActionListener(this);
		
		repaint();
		setVisible(true);
	}

	public static void main(String[] args) {
		VacationDays vacation = new VacationDays("test", 5);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.daysAvailable>0) {
			String date = JOptionPane.showInputDialog(rootPane, "Enter Date (MM/dd/yyyy)");
			try {
				if(date.charAt(4)=='/' && date.charAt(7)=='/') {
					date.replaceAll("/", "");
				}	
				if(!dates.contains(date)) {
					dates.add(date);
					System.out.println(dates);
					this.daysAvailable--;
					new VacationDays(this.name, this.daysAvailable);
					super.dispose();
					
				}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Invalid date format");
			}
		}
	}			
}


