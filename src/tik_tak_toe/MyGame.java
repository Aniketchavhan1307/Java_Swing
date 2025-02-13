package tik_tak_toe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyGame extends JFrame
{
	
	JLabel heading, clock;
	JPanel mainPanel;
	
	JButton [] jbutton = new JButton[9];
	
	Font font = new Font("", Font.BOLD, 40);
	
	
	public MyGame() 
	{
		setTitle("My Tic Tac Toe Game");
		setSize(550,550);
		setLocation(200, 200);
		
		ImageIcon icon = new ImageIcon("src\\img\\xo.jpg");
		
		setIconImage(icon.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createGUI();
		
		setVisible(true);
	}
	
	
	private void createGUI()
	{
		this.getContentPane().setBackground(Color.decode("#2196f3"));
		
		this.setLayout(new BorderLayout());
		
		
		// north heading...
		
		heading = new JLabel("Tic Tac Toe");
		heading.setFont(font);
		
		
//		heading.setIcon(new ImageIcon("src/img/xo.jpg"));
//		
//		heading.setHorizontalTextPosition(SwingConstants.CENTER);
		
		heading.setForeground(Color.WHITE);
		
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.add(heading,BorderLayout.NORTH );
		
		
		// creating object of jLabel for clock
		
		clock = new JLabel("Clock");
		
		clock.setForeground(Color.WHITE);
		clock.setFont(font);
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.add(clock, BorderLayout.SOUTH);
		
		
		// calculate time using thread...
		Thread t = new Thread() {
			public void run()
			{
				try {
					
					while(true)
					{
						String datetime = new Date().toLocaleString();
						
						clock.setText(datetime);
						
						Thread.sleep(1000);
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
		};
		t.start();
		
		
		
		// panel section
		
		mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridLayout(3,3));
		
		for (int i = 1; i <= jbutton.length; i++) 
		{
			
			JButton btn = new JButton();
			
			btn.setBackground(Color.decode("#90caf9"));
			
			btn.setIcon(new ImageIcon("src/img/o.png"));
			btn.setFont(font);
			
			mainPanel.add(btn);
			
			jbutton[i-1] = btn;
		}
		
		this.add(mainPanel,  BorderLayout.CENTER);
		
	}
	 
} 
