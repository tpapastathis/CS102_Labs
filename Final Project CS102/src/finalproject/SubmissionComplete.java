package finalproject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SubmissionComplete extends JFrame implements ActionListener{
	final int SIZE = 200;
	JLabel submitted = new JLabel("Submission Complete!");
	JButton exit = new JButton("Exit");

	public SubmissionComplete() {
		super("Submitted");
		setLayout(new FlowLayout());
		setSize(SIZE,SIZE/2);
		add(submitted);
		add(exit);
		submitted.setVisible(true);
		exit.setVisible(true);
		exit.addActionListener(this);
		setLocationRelativeTo(null);
		toFront();
		repaint();
		requestFocus();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		SubmissionComplete submission = new SubmissionComplete();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
