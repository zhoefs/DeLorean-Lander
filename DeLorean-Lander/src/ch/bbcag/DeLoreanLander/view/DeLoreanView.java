package ch.bbcag.DeLoreanLander.view;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.Xboxcontroller.XboxControllerListener;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;

public class DeLoreanView extends GameGrid {

	private static final long serialVersionUID = 1L;
	private XboxControllerListener controller = null;

	// Actors
	private DeLoreanLander lorean = null;
	private Actor firstLandingField = null;
	private Actor secondLandingField = null;
	private Actor thirdLandingField = null;

	public DeLoreanView() {
		super(1800, 1000, 1, null, "resources/sprites/western_background.png", false);
		setSimulationPeriod(50);

		addActor(getLorean(), new Location(900, 100));
		addActor(getLorean().getThrust(), new Location(900, 140));
		addActor(getFirstLandingField(), new Location(300, 400));
		addActor(getSecondLandingField(), new Location(800, 950));
		addActor(getThirdLandingField(), new Location(1470, 770));

		setController(new XboxControllerListener(lorean, this));
		show();
	}

	public void gameStart() {
		removeAllActors();
		setBgImagePath("resources/sprites/western_background.png");

		addActor(getLorean(), new Location(900, 100));
		addActor(getLorean().getThrust(), new Location(900, 140));
		addActor(getFirstLandingField(), new Location(300, 400));
		addActor(getSecondLandingField(), new Location(800, 950));
		addActor(getThirdLandingField(), new Location(1470, 770));

		getLorean().addCollisionActor(getFirstLandingField());
		getLorean().addCollisionActor(getSecondLandingField());
		getLorean().addCollisionActor(getThirdLandingField());

		refresh();
		doRun();
	}

	public static void main(final String[] args) {
		new DeLoreanView();
	}

	private void setController(XboxControllerListener controller) {
		this.controller = controller;
	}

	private DeLoreanLander getLorean() {
		if (lorean == null) {
			setLorean(new DeLoreanLander());
		}
		return lorean;
	}

	private void setLorean(DeLoreanLander lorean) {
		this.lorean = lorean;
	}

	private Actor getSecondLandingField() {
		if (secondLandingField == null) {
			setSecondLandingField(new Actor("resources/sprites/landing_path.png"));
		}
		return secondLandingField;
	}

	private void setSecondLandingField(Actor secondLandingField) {
		this.secondLandingField = secondLandingField;
	}

	private Actor getThirdLandingField() {
		if (thirdLandingField == null) {
			setThirdLandingField(new Actor("resources/sprites/landing_path.png"));
		}
		return thirdLandingField;
	}

	private void setThirdLandingField(Actor thirdLandingField) {
		this.thirdLandingField = thirdLandingField;
	}

	private Actor getFirstLandingField() {
		if (firstLandingField == null) {
			setFirstLandingField(new Actor("resources/sprites/landing_path.png"));
		}
		return firstLandingField;
	}

	private void setFirstLandingField(Actor firstLandingField) {
		this.firstLandingField = firstLandingField;
	}
}