package ch.bbcag.DeLoreanLander.view;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.Xboxcontroller.XboxControllerListener;
import ch.bbcag.DeLoreanLander.actor.DeLoreanActor;
import ch.bbcag.DeLoreanLander.actor.LandingBaseActor;
import ch.bbcag.DeLoreanLander.util.TimeUtil;

public class DeLoreanView extends GameGrid {

	private static final long serialVersionUID = 1L;
	private static final int NR_HORIZONTAL_CELLS = 1800;
	private static final int NR_VERTICAL_CELLS = 1000;
	private static final int CELL_SIZE = 1;

	// Actors
	private DeLoreanActor deLorean = null;
	private Actor backgroundImage = null;
	private Actor firstLandingField = null;
	private Actor secondLandingField = null;
	private Actor thirdLandingField = null;
	private Actor welcome = new Actor("resources/sprites/welcome.png");
	private Actor buttonsToPlay = new Actor("resources/sprites/buttons_to_play.png");
	private Actor pressStart = new Actor("resources/sprites/press_start.png");
	private Actor pressBack = new Actor("resources/sprites/press_back.png");
	private Actor upOrDown = new Actor("resources/sprites/up_or_down.png");
	private Actor leftOrRight = new Actor("resources/sprites/left_or_right.png");
	private Actor hint = new Actor("resources/sprites/hint.png");

	public DeLoreanView() {
		super(NR_HORIZONTAL_CELLS, NR_VERTICAL_CELLS, CELL_SIZE, null, "resources/sprites/blueprint.png", false);
		setSimulationPeriod(50);

		// Adding the actors to the Grid
		addActor(getBackgroundImage(), new Location(960, 540));

		addActor(getDeLorean(), new Location(NR_HORIZONTAL_CELLS / 2, 100));
		removeActor(deLorean);
		addActor(getFirstLandingField(), new Location(275, 390));
		addActor(getSecondLandingField(), new Location(800, 970));
		addActor(getThirdLandingField(), new Location(1470, 770));

		addActor(welcome, new Location(860, 200)); // Welcome Text
		addActor(buttonsToPlay, new Location(650, 400));
		addActor(pressStart, new Location(930, 500));
		addActor(pressBack, new Location(790, 550));
		addActor(upOrDown, new Location(972, 650));
		addActor(leftOrRight, new Location(998, 700));
		addActor(hint, new Location(950, 900));

		new XboxControllerListener(deLorean, this);
		show();
	}

	public void gameStart() {
		TimeUtil.setStartTime(System.nanoTime());
		removeAllActors();
		addActor(getBackgroundImage(), new Location(960, 540));
		addActor(getDeLorean(), new Location(900, 100));
		getDeLorean().reset();
		addActor(getDeLorean().getThrust(), new Location(900, 140));
		addActor(getFirstLandingField(), new Location(275, 390));
		addActor(getSecondLandingField(), new Location(800, 970));
		addActor(getThirdLandingField(), new Location(1470, 770));

		getDeLorean().addCollisionActor(getFirstLandingField());
		getDeLorean().addCollisionActor(getSecondLandingField());
		getDeLorean().addCollisionActor(getThirdLandingField());

		refresh();
		doRun();
	}

	public Actor getBackgroundImage() {
		if (backgroundImage == null) {
			setBackgroundImage(new Actor("resources/sprites/backgroundImageWithClouds.png"));
		}
		return backgroundImage;
	}

	public void setBackgroundImage(Actor backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public static void main(final String[] args) {
		new DeLoreanView();
	}

	private DeLoreanActor getDeLorean() {
		if (deLorean == null) {
			setDeLorean(new DeLoreanActor());
		}
		return deLorean;
	}

	private void setDeLorean(DeLoreanActor deLorean) {
		this.deLorean = deLorean;
	}

	private Actor getSecondLandingField() {
		if (secondLandingField == null) {
			setSecondLandingField(new LandingBaseActor("resources/sprites/landing_path.png"));
		}
		return secondLandingField;
	}

	private void setSecondLandingField(Actor secondLandingField) {
		this.secondLandingField = secondLandingField;
	}

	private Actor getThirdLandingField() {
		if (thirdLandingField == null) {
			setThirdLandingField(new LandingBaseActor("resources/sprites/landing_path.png"));
		}
		return thirdLandingField;
	}

	private void setThirdLandingField(Actor thirdLandingField) {
		this.thirdLandingField = thirdLandingField;
	}

	private Actor getFirstLandingField() {
		if (firstLandingField == null) {
			setFirstLandingField(new LandingBaseActor("resources/sprites/landing_path.png"));
		}
		return firstLandingField;
	}

	private void setFirstLandingField(Actor firstLandingField) {
		this.firstLandingField = firstLandingField;
	}
}