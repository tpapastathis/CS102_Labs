package finalproject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;  
import java.util.ArrayList;
import java.time.LocalDateTime; 
public class EmployeeWindow extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int SIZE = 133;
	ArrayList<String> punchInName = new ArrayList<String>();
	ArrayList<String> punchInTime = new ArrayList<String>();
	ArrayList<Shift> shiftList = new ArrayList<Shift>();
	
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
			}
			
		}
		else if(e.getSource()==vacation) {
			//close window and call vacation days request method
			System.out.println("vacation"); 
		}
		
	}
	public static void main(String args[]) {
		EmployeeWindow test = new EmployeeWindow();
	}
}
