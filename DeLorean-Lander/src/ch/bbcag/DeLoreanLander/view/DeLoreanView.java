package ch.bbcag.DeLoreanLander.view;

import java.awt.Point;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGCheckButton;
import ch.aplu.jgamegrid.GGCheckButtonListener;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.Xboxcontroller.XboxControllerListener;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;
import ch.bbcag.DeLoreanLander.controller.LandingBaseActor;

public class DeLoreanView extends GameGrid implements GGCheckButtonListener {

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


	public DeLoreanView() {
		super(NR_HORIZONTAL_CELLS, NR_VERTICAL_CELLS, CELL_SIZE, null,
				"resources/sprites/Blueprint.png", false);
		setSimulationPeriod(50);

		// Adding the actors to the Grid
		addActor(getBackgroundImage(),new Location(960, 540));
		addActor(getLorean(), new Location(900, 100));
		addActor(getLorean().getThrust(), new Location(900, 140));
		addActor(getFirstLandingField(), new Location(275, 390));
		addActor(getSecondLandingField(), new Location(800, 965));
		addActor(getThirdLandingField(), new Location(1470, 770));
		
		new XboxControllerListener(lorean, this);
		show();
	}

	public void buttonChecked(GGCheckButton arg0, boolean arg1) {
		System.out.print("new Location(" + arg0.getLocation().x + "," + arg0.getLocation().y + "), ");
	}

	public void gameStart() {
		removeAllActors();

		setBgImagePath("resources/sprites/Blueprint.png");

		addActor(getBackgroundImage(),new Location(960, 540));
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