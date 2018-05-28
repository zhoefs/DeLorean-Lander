package ch.bbcag.DeLoreanLander.Xboxcontroller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ch.bbcag.DeLoreanLander.actor.DeLoreanActor;
import ch.bbcag.DeLoreanLander.view.DeLoreanView;

public class KeyControllerAdapter implements KeyListener {

	private DeLoreanActor deLoreanActor;
	private DeLoreanView deLoreanView;

	public KeyControllerAdapter(DeLoreanActor deLoreanActor, DeLoreanView deLoreanView) {
		this.deLoreanActor = deLoreanActor;
		this.deLoreanView = deLoreanView;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			deLoreanActor.accelerate(0);
			break;
		case KeyEvent.VK_DOWN:
			deLoreanActor.accelerate(4);
			break;
		case KeyEvent.VK_LEFT:
			deLoreanActor.accelerate(7);
			break;
		case KeyEvent.VK_RIGHT:
			deLoreanActor.accelerate(2);
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_ENTER:
			this.deLoreanView.gameStart();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}