package ch.bbcag.DeLoreanLander.view;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.Xboxcontroller.XboxControllerListener;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;

public class DeLoreanView extends GameGrid {

	private static final long serialVersionUID = 1L;
	private XboxControllerListener controller = null;

	public DeLoreanView() {
		super(180, 100, 10, java.awt.Color.RED, "resources/sprites/western_background.png", false);
		setSimulationPeriod(50);
		final DeLoreanLander lorean = new DeLoreanLander();
		final Actor firstLandingField = new Actor("resources/sprites/landing_path.png");
		final Actor secondLandingField = new Actor("resources/sprites/landing_path.png");
		final Actor thirdLandingField = new Actor("resources/sprites/landing_path.png");
		addActor(lorean, new Location(65, 10));
		addActor(firstLandingField, new Location(30, 40));
		addActor(secondLandingField, new Location(80, 95));
		addActor(thirdLandingField, new Location(147, 77));

		this.controller = new XboxControllerListener(lorean, this);

		show();
	}

	public void gameStart() {
		doRun();
	}

	public static void main(final String[] args) {
		new DeLoreanView();
	}
}
