package finalproject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EmployeeWindow extends JFrame implements ActionListener{
	final int SIZE = 200;
	private boolean punchInBool = false;
	private boolean punchOutBool = false;
	
	
	JLabel welcome = new JLabel("Welcome!");
	JLabel space = new JLabel();
	JButton punchOut = new JButton("Punch out");
	JButton punchIn = new JButton("Punch in");
	JButton submit = new JButton("Submit!");
	
	JTextField name = new JTextField("Enter first and last name");
	public EmployeeWindow() {
		super("Employee Mode");
		setLayout(new FlowLayout());
		setSize(SIZE,SIZE);
		add(welcome);
		add(space);
		add(name);
		add(punchIn);
		add(punchOut);
		add(submit);
		
		
		welcome.setVisible(true);
		space.setVisible(true);
		punchOut.setVisible(true);
		punchOut.addActionListener(this);
		punchIn.setVisible(true);
		punchIn.addActionListener(this);
		submit.setVisible(true);
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
		if(e.getSource()==punchIn) {
			punchInBool=false;
			punchOutBool=false;
			if(!punchOut.isEnabled()) {
				punchOut.setEnabled(true);
				punchInBool=true;
				System.out.println(punchInBool);	
			}
			punchIn.setEnabled(false);
			
		}
		else if(e.getSource()==punchOut) {
			punchInBool = false;
			punchOutBool = false;
			if(!punchIn.isEnabled()) {
				punchIn.setEnabled(true);
				punchOutBool=true;
				System.out.println(punchInBool);
			}
			punchOut.setEnabled(false);
		}
		else if(e.getSource()==submit) {
			//if punchIn call punchIn method
			//if punchOut call punchOut method
			
			SubmissionComplete submitted = new SubmissionComplete();
			
			
		}
		
	}
	public static void main(String args[]) {
		EmployeeWindow test = new EmployeeWindow();
	}
}
