package ch.bbcag.DeLoreanLander.Xboxcontroller;

import javax.swing.JOptionPane;
import ch.aplu.xboxcontroller.*;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;

public class XboxControllerListener {

	private XboxController xc;

	public XboxControllerListener(DeLoreanLander deLoreanLander) {
		xc = new XboxController();

		if (!xc.isConnected()) {
			JOptionPane.showMessageDialog(null, "XBox Controller not connected.", "Fatal error",
					JOptionPane.ERROR_MESSAGE);
			xc.release();
			return;
		}

		xc.addXboxControllerListener(new XboxControllerAdap(deLoreanLander));
	}
}