package form_java_swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class WindowA extends JFrame
{
	private JLabel heading;
	
	private JPanel mainPanel;
	private JLabel nameLablel , passwordLabel;
	private JTextField nameTextField;
	private JPasswordField passwordField;
	
	private JButton button1, button2;
	
	Font font = new Font("", Font.BOLD, 30);
	

	//constructor
	public WindowA()
	{
		super.setTitle("My first Form...");
		setLocation(400,200);
		setSize(500,500);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // after closing the window it will shot-down the running project...............
		
		this.createGUI();
		
		setVisible(true);
	}
	
	
	// GUI
	public void createGUI()
	{
		// this method create our GUI
		this.setLayout(new BorderLayout());
		
		heading = new JLabel("My first Form");
		heading.setFont(font);
		
		heading.setHorizontalAlignment(JLabel.CENTER);		// to align center
		
		this.add(heading, BorderLayout.NORTH);
		
		
		// working with JPanel
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3,2));
		
		nameLablel = new JLabel("Enter Your Name: ");
		nameLablel.setFont(font);
		
		passwordLabel = new JLabel("Enter your password : ");
		passwordLabel.setFont(font);
		
		nameTextField = new JTextField();
		nameTextField.setFont(font);
		
		passwordField = new JPasswordField();
		passwordField.setFont(font);
		
		button1 = new JButton("Submit");
		button1.setFont(font);
		
		button2 = new JButton("Reset");
		button2.setFont(font);
		
		mainPanel.add(nameLablel);
		mainPanel.add(nameTextField);
		
		mainPanel.add(passwordLabel);
		mainPanel.add(passwordField);
		mainPanel.add(button1);
		mainPanel.add(button2);
		
		
		this.add(mainPanel, BorderLayout.CENTER);
	}
}
