package ch.bbcag.DeLoreanLander.actor;

import ch.aplu.jgamegrid.Actor;

public class FireworkActor extends Actor {

	public FireworkActor(String filename, int nbSprites) {
		super(filename, nbSprites);
	}

	@Override
	public void act() {
		showNextSprite();
		super.act();
	}
}