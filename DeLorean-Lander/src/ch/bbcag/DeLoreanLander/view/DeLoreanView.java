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
		super(1800, 1000, 1, null, "resources/sprites/western_background.png", false);
		setSimulationPeriod(50);

		final DeLoreanLander lorean = new DeLoreanLander();
		final Actor firstLandingField = new Actor("resources/sprites/landing_path.png");
		final Actor secondLandingField = new Actor("resources/sprites/landing_path.png");
		final Actor thirdLandingField = new Actor("resources/sprites/landing_path.png");

		addActor(lorean, new Location(900, 100));
		addActor(firstLandingField, new Location(300, 400));
		addActor(secondLandingField, new Location(800, 950));
		addActor(thirdLandingField, new Location(1470, 770));

		lorean.addCollisionActor(firstLandingField);
		lorean.addCollisionActor(secondLandingField);
		lorean.addCollisionActor(thirdLandingField);

		setController(new XboxControllerListener(lorean, this));
		show();
	}

	public void gameStart() {
		doRun();
	}

	public static void main(final String[] args) {
		new DeLoreanView();
	}

	private void setController(XboxControllerListener controller) {
		this.controller = controller;
	}
}