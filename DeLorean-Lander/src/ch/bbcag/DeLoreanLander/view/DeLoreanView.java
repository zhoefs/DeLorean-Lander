package ch.bbcag.DeLoreanLander.view;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;

public class DeLoreanView extends GameGrid {

	private static final long serialVersionUID = 1L;

	public DeLoreanView() {
		super(1700, 1000, 1,null,"resources/sprites/western_background.png", false);
		setSimulationPeriod(50);
		final DeLoreanLander lorean = new DeLoreanLander();
		final Actor firstLandingField = new Actor("resources/sprites/landing_path.png");
		final Actor secondLandingField = new Actor("resources/sprites/landing_path.png");
		final Actor thirdLandingField = new Actor("resources/sprites/landing_path.png");
		addActor(lorean, new Location(670, 100));
		addActor(firstLandingField,new Location(400,410));
		addActor(secondLandingField,new Location(700,910));
		addActor(thirdLandingField,new Location(1480,780));
		show();
		GameGrid.delay(3000); // Verzögerung
		doRun(); 
	}

	public static void main(final String[] args) {
		new DeLoreanView();
	}
}
