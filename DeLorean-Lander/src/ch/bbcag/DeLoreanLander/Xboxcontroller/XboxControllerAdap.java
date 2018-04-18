package ch.bbcag.DeLoreanLander.Xboxcontroller;

import ch.aplu.xboxcontroller.XboxControllerAdapter;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;
import ch.bbcag.DeLoreanLander.view.DeLoreanView;

public class XboxControllerAdap extends XboxControllerAdapter {
	private DeLoreanLander deLoreanLander;
	private DeLoreanView deLoreanView;

	public XboxControllerAdap(DeLoreanLander deLoreanLander, DeLoreanView deLoreanView) {
		super();

		this.deLoreanLander = deLoreanLander;
		this.deLoreanView = deLoreanView;
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
	
	public void start(boolean pressed) {
		if(pressed) {
			deLoreanView.gameStart();
		}
	}

	public void rightTrigger(double value) {
		System.out.println("rightTrigger value:" + value);
	}
}