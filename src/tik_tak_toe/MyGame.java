package tik_tak_toe;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyGame extends JFrame
{
	
	public MyGame() 
	{
		setTitle("My Tic Tac Toe Game");
		setSize(850,850);
		
		ImageIcon icon = new ImageIcon("src\\img\\xo.jpg");
		
		setIconImage(icon.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	
	 
} 
