package ch.bbcag.DeLoreanLander.Xboxcontroller;

import javax.swing.JOptionPane;

import ch.aplu.xboxcontroller.XboxController;
import ch.bbcag.DeLoreanLander.actor.DeLoreanActor;
import ch.bbcag.DeLoreanLander.view.DeLoreanView;

public class XboxControllerListener {

	public XboxControllerListener(DeLoreanActor deLoreanLander, DeLoreanView deLoreanView) {
		final XboxController XBOX_CONTROLLER = new XboxController();

		if (!XBOX_CONTROLLER.isConnected()) {
			JOptionPane.showMessageDialog(null, "XBox Controller not connected.", "Fatal error",
					JOptionPane.ERROR_MESSAGE);
			XBOX_CONTROLLER.release();
			return;
		}
		XBOX_CONTROLLER.addXboxControllerListener(new XboxControllerAdap(deLoreanLander, deLoreanView));
	}
}