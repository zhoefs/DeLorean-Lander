package ch.bbcag.DeLoreanLander.view;

import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;

public class DeLoreanView extends GameGrid{

	private static final long serialVersionUID = 1L;
	
	public DeLoreanView() {
		super(1700, 100, 1, null, "resources/sprites/lander_background.gif", false);
		setSimulationPeriod(50);
		final DeLoreanLander lander = new DeLoreanLander();
//		addActor(lander, new Location(330, 100));
//		addKeyListener(lander);
		show();
		GameGrid.delay(3000);
		doRun();
	}
	public static void main(final String[] args) {
		new DeLoreanView();
	}
}
