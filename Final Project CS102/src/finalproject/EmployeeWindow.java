package finalproject;
import java.awt.*;
import javax.swing.*;
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
public class EmployeeWindow extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int SIZE = 133;
	ArrayList<String> punchInName = new ArrayList<String>();
	ArrayList<String> punchInTime = new ArrayList<String>();
	public static ArrayList<Shift> shiftList = new ArrayList<Shift>();
	
	JLabel welcome = new JLabel("Welcome!");
	JButton vacation = new JButton("Request Vacation Days");
	JButton punchOut = new JButton("Punch out");
	JButton punchIn = new JButton("Punch in");
	JButton submit = new JButton("Submit!");
	JTextField name = new JTextField("Enter first and last name");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
    String dateString1, dateString2;
    int nameIndex;
    
	public EmployeeWindow() {
		super("Employee Mode");
		loadShift();
		setLayout(new FlowLayout());
		setSize(SIZE*3,SIZE);
		add(welcome);
		add(name);
		add(vacation);
		add(punchIn);
		add(punchOut);
		add(submit);
		
		
		welcome.setVisible(true);
		vacation.setVisible(true);
		vacation.addActionListener(this);
		punchOut.setVisible(true);
		punchOut.addActionListener(this);
		punchIn.setVisible(true);
		punchIn.addActionListener(this);
		submit.setVisible(true);
		submit.addActionListener(this);
		name.setVisible(true);
		
		setLocationRelativeTo(null);
		toFront();
		repaint();
		requestFocus();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String textEntry = name.getText();
		if(e.getSource()==punchIn) {
			if(!punchOut.isEnabled()) {
				punchOut.setEnabled(true);	
			}
			punchIn.setEnabled(false);
		}
		else if(e.getSource()==punchOut) {
			if(!punchIn.isEnabled()) {
				punchIn.setEnabled(true);
			}
			punchOut.setEnabled(false);
		}
		else if(e.getSource()==submit) {
			if(!punchIn.isEnabled()) {
				if(!punchInName.contains(textEntry) && !textEntry.equals("Enter first and last name")) {
					LocalDateTime startTime = LocalDateTime.now(); 
					dateString1 = formatter.format(startTime).toString();
					punchInName.add(textEntry);
					punchInTime.add(dateString1);
					
					System.out.println(punchInName);
					System.out.println(punchInTime);
				}
			}
			if(!punchOut.isEnabled()) {
				if(!textEntry.equals("Enter first and last name")){
					LocalDateTime endTime = LocalDateTime.now();
					dateString2 = formatter.format(endTime).toString();
					try {
						nameIndex = punchInName.indexOf(textEntry);
					}
					catch(Exception ie){
						System.out.println("Invalid index");
					}
					System.out.println(nameIndex);
					if(nameIndex!=-1) {
						shiftList.add(new Shift(punchInName.get(nameIndex), punchInTime.get(nameIndex), dateString2));
						System.out.println(shiftList);
					}
				}
			}
			if(!textEntry.equals("Enter first and last name")) {
				SubmissionComplete submitted = new SubmissionComplete();
				saveShift();
			}
		}
		else if(e.getSource()==vacation) {
			//close window and call vacation days request method
			VacationDays vacation = new VacationDays(textEntry, 5);
			//setVisible(false);
			System.out.println("vacation"); 
		}
		
	}
	public static void main(String args[]) {
		EmployeeWindow test = new EmployeeWindow();
	}
	public static void saveShift() {
		try {
			FileOutputStream fileOutput = new FileOutputStream(new File("shiftData.txt"));
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			
			objectOutput.writeObject(shiftList);
			
			fileOutput.close();
			objectOutput.close();
			
			FileOutputStream fileOutput2 = new FileOutputStream(new File("shiftIds.txt"));
			fileOutput2.write(Shift.id);
			
			fileOutput2.close();
			
		}
		catch(IOException e) {
			System.out.println("IOException");
		}
	}
	public static void loadShift() {
		try {
			FileInputStream fileInput = new FileInputStream("shiftData.txt");
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			FileInputStream fileInput2 = new FileInputStream("shiftIds.txt");
			
			shiftList = (ArrayList) objectInput.readObject();
			
			fileInput.close();
			objectInput.close();
			
			Shift.id = (int) fileInput2.read();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch(IOException ie) {
			System.out.println("IOException");
		}
		catch(ClassNotFoundException ce) {
			System.out.println("Class not found");
		}
		
	}
}
