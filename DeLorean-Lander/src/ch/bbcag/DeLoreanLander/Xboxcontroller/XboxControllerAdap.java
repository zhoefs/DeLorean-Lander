package ch.bbcag.DeLoreanLander.Xboxcontroller;

import ch.aplu.xboxcontroller.XboxControllerAdapter;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;
import ch.bbcag.DeLoreanLander.view.DeLoreanView;

public class XboxControllerAdap extends XboxControllerAdapter {
	private DeLoreanLander deLoreanLander;
	private DeLoreanView deLoreanView;
	
	private boolean onHold = false;

	public XboxControllerAdap(DeLoreanLander deLoreanLander, DeLoreanView deLoreanView) {
		super();
		this.deLoreanLander = deLoreanLander;
		this.deLoreanView = deLoreanView;
	}

	public void dpad(int direction, boolean pressed) {
		if (pressed) {
			if(!onHold) {
				onHold = true;
				this.deLoreanLander.accelerate(direction);
			}
		} else {
			onHold = false;
		}
	}

	public void back(boolean pressed) {
		if (pressed) {
			System.exit(0);
		}
	}

	public void start(boolean pressed) {
		if (pressed) {
			deLoreanView.gameStart();
		}
	}

	public void rightTrigger(double value) {
		System.out.println("rightTrigger value:" + value);
	}
}