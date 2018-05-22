package ch.bbcag.DeLoreanLander.view;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.Xboxcontroller.XboxControllerListener;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;
import ch.bbcag.DeLoreanLander.controller.LandingBaseActor;

public class DeLoreanView extends GameGrid {

	private static final long serialVersionUID = 1L;
	private static final int NR_HORIZONTAL_CELLS = 1800;
	private static final int NR_VERTICAL_CELLS = 1000;
	private static final int CELL_SIZE = 1;

	// Actors
	private DeLoreanLander lorean = null;
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
	
	public DeLoreanView() {
		super(NR_HORIZONTAL_CELLS, NR_VERTICAL_CELLS, CELL_SIZE, null, "resources/sprites/blueprint.png", false);
		setSimulationPeriod(50);

		// Adding the actors to the Grid
		addActor(getBackgroundImage(), new Location(960, 540));
		
		addActor(welcome, new Location(860, 200)); // Welcome Text
		addActor(buttonsToPlay, new Location(650, 350));
		addActor(pressStart, new Location(830, 450));
		addActor(pressBack, new Location(690, 500));
		addActor(upOrDown, new Location(872, 600));
		addActor(leftOrRight, new Location(898, 650));
		
		
		addActor(getLorean(), new Location(900, 100));
		removeActor(lorean);
		addActor(getFirstLandingField(), new Location(275, 390));
		addActor(getSecondLandingField(), new Location(800, 965));
		addActor(getThirdLandingField(), new Location(1470, 770));

		new XboxControllerListener(lorean, this);
		show();
	}

	public void gameStart() {
		removeAllActors();

		setBgImagePath("resources/sprites/blueprint.png");

		addActor(getBackgroundImage(), new Location(960, 540));
		addActor(getLorean(), new Location(900, 100));
		addActor(getLorean().getThrust(), new Location(900, 140));
		addActor(getFirstLandingField(), new Location(275, 390));
		addActor(getSecondLandingField(), new Location(800, 965));
		addActor(getThirdLandingField(), new Location(1470, 770));

		getLorean().addCollisionActor(getFirstLandingField());
		getLorean().addCollisionActor(getSecondLandingField());
		getLorean().addCollisionActor(getThirdLandingField());

		refresh();
		doRun();
	}

	public Actor getBackgroundImage() {
		if (backgroundImage == null) {
			setBackgroundImage(new Actor("resources/sprites/backgroundImage.png"));
		}
		return backgroundImage;
	}

	public void setBackgroundImage(Actor backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public static void main(final String[] args) {
		new DeLoreanView();
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