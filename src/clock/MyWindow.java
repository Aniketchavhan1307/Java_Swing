package clock;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MyWindow extends JFrame
{
	private JLabel heading;
	private JLabel clockLabel;
	
	
	private Font font = new Font("", Font.BOLD, 35);
	
	public MyWindow()
	{
		super.setTitle("My clock");
		super.setSize(500,500);
		super.setLocation(300, 200);
		
		
		this.createGUI();  
		this.startClock();
		
		setVisible(true);	// we can directly call parent class member without using super keyword 
		
	}
	
	public void createGUI()
	{
		heading = new JLabel("My Clock");
		
		clockLabel = new JLabel("Clock");
		
		heading.setFont(font);
		clockLabel.setFont(font);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(heading);
		this.add(clockLabel);
		
	}
	
	
	public void startClock() 
	{
		// Anonymous Class
		
//		Timer time = new Timer(1000, new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				String dateTime = new Date().toString();
//				
//				clockLabel.setText(dateTime);
//			}
//		});
//		
//		time.start();
		
		
		// Lambda Expression
		
		Timer timer = new Timer(1000, (e)->{
									//			String date = new Date().toString(); 
											//	String date = new Date().toLocaleString(); 
						
									Date d = new Date();
									SimpleDateFormat sdf = new SimpleDateFormat(" hh : mm : ss a");
									  String date =sdf.format(d);
									  
												clockLabel.setText(date);
											});
		timer.start();
		
	}
	

}
