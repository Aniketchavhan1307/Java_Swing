package tik_tak_toe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyGame extends JFrame implements ActionListener
{
	
	JLabel heading, clock;
	JPanel mainPanel;
	
	JButton [] jbutton = new JButton[9];
	
	// game instance variable
	
	int gameChances[]  = {2,2,2,2,2,2,2,2,2};
	int activePlayer = 0;
	
	int winner[][] = {
						{0,1,2},
						{3,4,5},
						{6,7,8},
						{0,3,6},
						{1,4,7},
						{2,5,7},
						{0,4,8},
						{2,4,6},
			
					};
	
	
	int winnerPlayer = 2;
	
	boolean gameOver = false;
	
	Font font = new Font("", Font.BOLD, 40);
	
	
	public MyGame() 
	{
		setTitle("My Tic Tac Toe Game");
		setSize(600,600);
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
			
		//	btn.setIcon(new ImageIcon("src/img/o.png"));
			
			btn.setFont(font);
			
			mainPanel.add(btn);
			
			jbutton[i-1] = btn;
			btn.addActionListener(this);
			btn.setName(String.valueOf(i-1));
			
		}
		
		this.add(mainPanel,  BorderLayout.CENTER);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton  currentButton =(JButton) e.getSource();
		
		String nameStr = currentButton.getName();
		
		int name = Integer.parseInt(nameStr.trim());
		
	
		if (gameOver) 
		{
		JOptionPane.showMessageDialog(this, "Game Over " );
			return;
		}
		
		
		if(gameChances[name]==2 )
		{
			if (activePlayer == 1)
			{
				currentButton.setIcon(new ImageIcon("src/img/x.png"));
				
				gameChances[name] = activePlayer;
				activePlayer = 0;
			}
			else
			{
				currentButton.setIcon(new ImageIcon("src/img/o.png"));
				
				gameChances[name] = activePlayer;
				activePlayer = 1;
			}
			
			// finding winner...
			
			for (int temp[] : winner) 
			{
				if((gameChances[temp[0]]==gameChances[temp[1]]) &&
						(gameChances[temp[1]]==gameChances[temp[2]]) &&
						gameChances[temp[2]] != 2)
				{
					winnerPlayer = gameChances[temp[0]];
					
					gameOver = true;
					
					
					JOptionPane.showMessageDialog(null, "Player "+ winnerPlayer + " has won the game" );
					int i = JOptionPane.showConfirmDialog(this, "Do you want to play more ?? " );
					
					if(i==0)
					{
						this.setVisible(false);
						new MyGame();
						
					}
					else if(i == 1)
					{
						System.exit(34234);
					}
					else
					{
						System.exit(123);
					}
					
					break;
				}
			}
			
			// draw logic
			
			int count = 0;
			for(int x : gameChances)
			{
				if(x == 2)
				{
					count++;
					break;
				}
			}
			
			if(count ==0 && gameOver == false)
			{
				JOptionPane.showMessageDialog(this, "Match draw");
				
				int i = JOptionPane.showConfirmDialog(this, "Do you want to play more ?? " );
				
				if(i==0)
				{
					this.setVisible(false);
					new MyGame();
					
				}
				else if(i == 1)
				{
					System.exit(34234);
				}
				else
				{
					System.exit(123);
				}
			}
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(this, "position already occupied");
			
			
		}
		
		
		
		
	}
	 
} 
