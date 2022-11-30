package finalproject;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;  
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class ManagerWindow extends JFrame implements ActionListener{
	final int SIZE = 300;
	JLabel manMode = new JLabel("Manager Mode");
	JButton enterAudit = new JButton("Enter Shift Audit Mode");
	JButton overrideShift = new JButton("Override Employee Shift");
	JButton vacayDays = new JButton("Offer Vacation Days");
	
	public ManagerWindow() {
		super("Manager Mode");
		setSize(SIZE,SIZE);
		setLayout(new GridLayout(0,1));
		
		add(manMode);
		
		add(enterAudit);
		enterAudit.addActionListener(this);
		
		add(overrideShift);
		overrideShift.addActionListener(this);
		
		add(vacayDays);
		vacayDays.addActionListener(this);
		
		setLocationRelativeTo(null);
		toFront();
		repaint();
		requestFocus();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==enterAudit) {
			EnterAudit enterAudit = new EnterAudit();
		}
		else if(e.getSource()==overrideShift) {
			//enter override mode
		}
		else if(e.getSource()==vacayDays) {
			//enter vacation days offer mode
		}
		
	}
	public static void main(String[] args) {
		ManagerWindow test = new ManagerWindow();
	}

}

class EnterAudit extends JFrame implements ActionListener{
	JLabel label = new JLabel("Enter Employee Name");
	JTextField empName = new JTextField("Employee Name");
	JTextField dateSpan = new JTextField("Enter Month (MM)");
	JButton submitAudit = new JButton("Submit");
	String empNameString, monthEntered;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	ArrayList<LocalDateTime> ldt = new ArrayList<LocalDateTime>();
	protected EnterAudit() {
		super("Audit Mode");
		setSize(200,300);
		setLayout(new GridLayout(0,1));
		
		label.setBorder(border);
		add(label);
		
		add(empName);
		empName.setSize(5,5);
		
		add(dateSpan);
		dateSpan.setSize(5,5);
		
		
		add(submitAudit);
		submitAudit.addActionListener(this);
		
		setLocationRelativeTo(null);
		toFront();
		repaint();
		requestFocus();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitAudit) {
			ArrayList<Shift> matches = new ArrayList<Shift>();
			EmployeeWindow.loadShift();
			empNameString = empName.getText(); 
			monthEntered = dateSpan.getText();
			for(int i = 0; i < EmployeeWindow.shiftList.size(); i++) {
				try {
					if(EmployeeWindow.shiftList.get(i).name.equals(empNameString) 
							&& EmployeeWindow.shiftList.get(i).endTime.substring(0,2).equals(monthEntered)) {
						matches.add(EmployeeWindow.shiftList.get(i));
						
					}
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			if(!matches.isEmpty())
				auditTime(matches);
			else 
				JOptionPane.showMessageDialog(null, "Invalid Information Entered or No Shifts Found");
		}
	}
	public static void auditTime(ArrayList<Shift> match) {
		ArrayList<String> tempStartTimes = new ArrayList<String>();
		ArrayList<String> tempEndTimes = new ArrayList<String>();
		ArrayList<LocalDateTime> tempStartLDT = new ArrayList<LocalDateTime>();
		ArrayList<LocalDateTime> tempEndLDT = new ArrayList<LocalDateTime>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
		for(int i = 0; i < match.size(); i++) {
			tempStartTimes.add(match.get(i).startTime.toString());
			tempEndTimes.add(match.get(i).endTime.toString());
			
			
			///////////////////// FIX
			//tempStartLDT.add(LocalDateTime.parse(tempStartTimes.get(i), formatter));
			//tempEndLDT.add(LocalDateTime.parse(tempEndTimes.get(i), formatter));
		}
		System.out.println("Start Times: "+tempStartTimes);
		System.out.println("End Times: "+tempEndTimes);
		
		System.out.println(tempStartLDT);
		System.out.println(tempEndLDT);
		
	}
}
