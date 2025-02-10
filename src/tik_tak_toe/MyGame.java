package tik_tak_toe;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyGame extends JFrame
{
	
	JLabel heading;
	Font font = new Font(null);
	
	public MyGame() 
	{
		setTitle("My Tic Tac Toe Game");
		setSize(850,850);
		
		ImageIcon icon = new ImageIcon("src\\img\\xo.jpg");
		
		setIconImage(icon.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createGUI();
		
		setVisible(true);
	}
	
	
	private void createGUI()
	{
		this.setLayout(new BorderLayout());
		
	}
	 
} 
