package clock;

import javax.swing.JFrame;

public class MyWindow extends JFrame
{
	public MyWindow()
	{
		super.setTitle("My clock");
		super.setSize(400,400);
		super.setLocation(300, 50);
		
		
		setVisible(true);	// we can directly call parent class member without using super keyword 
		
	}

}
