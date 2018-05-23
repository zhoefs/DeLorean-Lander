package ch.bbcag.DeLoreanLander.Xboxcontroller;

import ch.aplu.xboxcontroller.XboxControllerAdapter;
import ch.bbcag.DeLoreanLander.actor.DeLoreanActor;
import ch.bbcag.DeLoreanLander.view.DeLoreanView;

public class XboxControllerAdap extends XboxControllerAdapter {
	private DeLoreanActor deLoreanActor;
	private DeLoreanView deLoreanView;
	private boolean onHold = false;

	public XboxControllerAdap(DeLoreanActor deLoreanActor, DeLoreanView deLoreanView) {
		super();
		this.deLoreanActor = deLoreanActor;
		this.deLoreanView = deLoreanView;
	}

	public void dpad(int direction, boolean pressed) {
		if (pressed) {
			if (!onHold) {
				onHold = true;
				this.deLoreanActor.accelerate(direction);
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
}