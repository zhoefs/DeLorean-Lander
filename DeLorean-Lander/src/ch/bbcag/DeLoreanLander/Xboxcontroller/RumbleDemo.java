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
	        "XBox Controller not connected.",
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
	  }

	public static void main(String[] args) {
		new RumbleDemo();
	}
}