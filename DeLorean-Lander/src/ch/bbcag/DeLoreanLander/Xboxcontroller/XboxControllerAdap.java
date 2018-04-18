package ch.bbcag.DeLoreanLander.Xboxcontroller;

import ch.aplu.xboxcontroller.XboxControllerAdapter;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;

public class XboxControllerAdap extends XboxControllerAdapter {
	private DeLoreanLander deLoreanLander;

	public XboxControllerAdap(DeLoreanLander deLoreanLander) {
		super();

		this.deLoreanLander = deLoreanLander;
	}

	public void dpad(int direction, boolean pressed) {
		System.out.println("dpad: Direction " + direction + " pressed: " + pressed);

		if(pressed) {
			this.deLoreanLander.accelerate(direction);
		} else {
			this.deLoreanLander.stop();
		}
		
	}
	public void back(boolean pressed) {
		if(pressed) {
			System.exit(0);
		}
	}

	public void rightTrigger(double value) {
		System.out.println("rightTrigger value:" + value);
	}
}