package ch.bbcag.DeLoreanLander.view;

import java.awt.Color;
import java.awt.Point;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGCheckButton;
import ch.aplu.jgamegrid.GGCheckButtonListener;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.Xboxcontroller.XboxControllerListener;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;

public class DeLoreanView extends GameGrid implements GGCheckButtonListener {

	private static final long serialVersionUID = 1L;
	private static final int NR_HORIZONTAL_CELLS = 1800;
	private static final int NR_VERTICAL_CELLS = 1000;
	private static final int CELL_SIZE = 1;
	private XboxControllerListener controller = null;

	// Actors
	private DeLoreanLander lorean = null;
	private Actor firstLandingField = null;
	private Actor secondLandingField = null;
	private Actor thirdLandingField = null;

	public DeLoreanView() {
		super(NR_HORIZONTAL_CELLS, NR_VERTICAL_CELLS, CELL_SIZE, null, "resources/sprites/western_background_redline.png", false);
		setSimulationPeriod(50);

		addActor(getLorean(), new Location(900, 100));
		addActor(getLorean().getThrust(), new Location(900, 140));
		addActor(getFirstLandingField(), new Location(275, 385));
		addActor(getSecondLandingField(), new Location(800, 950));
		addActor(getThirdLandingField(), new Location(1470, 770));

		setController(new XboxControllerListener(lorean, this));
		show();
	}

	private void showCellNumbers() {
		for (int i = 0; i < 500; i++) {
			for (int j = 0; j < 200; j++) {
				if(Color.RED.equals(getBg().getColor(new Point(i,j)))) {
					System.out.println(getBg().getColor(new Point(i,j)) + ": " + i + "," + j);
				}
			}
		}
	}
	/**
	 * Used in debug mode only. It writes all selected locations to the console to
	 * use them in {@link LocationsSaloonBackground}.
	 */
	public void buttonChecked(GGCheckButton arg0, boolean arg1) {
		System.out.print("new Location(" + arg0.getLocation().x + "," + arg0.getLocation().y + "), ");
	}

	public void gameStart() {
		removeAllActors();
 		
		setBgImagePath("resources/sprites/western_background_redline.png");
		showCellNumbers();

//		addActor(getLorean(), new Location(900, 100));
//		addActor(getLorean().getThrust(), new Location(900, 140));
//		addActor(getFirstLandingField(), new Location(275, 385));
//		addActor(getSecondLandingField(), new Location(800, 950));
//		addActor(getThirdLandingField(), new Location(1470, 770));
//
//		getLorean().addCollisionActor(getFirstLandingField());
//		getLorean().addCollisionActor(getSecondLandingField());
//		getLorean().addCollisionActor(getThirdLandingField());

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