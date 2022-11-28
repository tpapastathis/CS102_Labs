package finalproject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FirstWindow extends JFrame implements ActionListener{
	final int SIZE = 300;
	JLabel empMan = new JLabel("Are you an Employee or a Manager?");
	JButton employee = new JButton("Employee");
	JButton manager = new JButton("Manager");
	public FirstWindow() {
		super("Time Card");
		setLayout(new FlowLayout());
		setSize(SIZE,SIZE/3);
		add(empMan);
		add(employee);
		add(manager);
		setLocationRelativeTo(null);
		toFront();
		repaint();
		requestFocus();
		setVisible(true);
		empMan.setVisible(true);
		employee.setVisible(true);
		employee.addActionListener(this);
		manager.setVisible(true);
		manager.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	public static void main(String[] args) {
		FirstWindow primary = new FirstWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==employee) {
			employee.setEnabled(false);
			manager.setEnabled(false);
			
			super.dispose();
			EmployeeWindow employee = new EmployeeWindow();
		}
		else if(e.getSource()==manager) {
			manager.setEnabled(false);
			employee.setEnabled(false);
			
			super.dispose();
			EnterManagerCode.ManagerCode();
		}
	}
}
