package ch.bbcag.DeLoreanLander.Xboxcontroller;

import ch.aplu.xboxcontroller.*;
import javax.swing.JOptionPane;

public class RumbleDemo {
	private XboxController xc;
	private int leftVibrate = 0;
	private int rightVibrate = 0;

	static boolean is64bit()
	{
	  return System.getProperty("sun.arch.data.model").equals("64");
	}
	
	public RumbleDemo()
	  { 
	    xc = new XboxController();
	    
	    if (!xc.isConnected())
	    {
	      JOptionPane.showMessageDialog(null, 
	        "Xbox controller not connected.",
	        "Fatal error", 
	        JOptionPane.ERROR_MESSAGE);
	      xc.release();
	      return;
	    }
	    	
	    xc.addXboxControllerListener(new XboxControllerAdapter()
	    {
	      public void leftTrigger(double value)
	      {
	        leftVibrate = (int)(65535 * value * value);
	        xc.vibrate(leftVibrate, rightVibrate);
	      }
	      public void rightTrigger(double value)
	      {
	        rightVibrate = (int)(65535 * value * value);
	        xc.vibrate(leftVibrate, rightVibrate);
	      }
	    });
	    
	    JOptionPane.showMessageDialog(null, 
	      "Xbox controller connected.\n" + 
	      "Press left or right trigger, Ok to quit.",
	        "RumbleDemo V1.0 (www.aplu.ch)", 
	        JOptionPane.PLAIN_MESSAGE);
	    
	    xc.release();
	    System.exit(0);
	  }

	public static void main(String[] args) {
		new RumbleDemo();
	}
}