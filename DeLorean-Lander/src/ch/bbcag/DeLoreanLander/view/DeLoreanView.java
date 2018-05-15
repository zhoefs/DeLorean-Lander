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

	// Red Pixels Actors
	private Actor checkpoint_1 = null;
	private Actor checkpoint_2 = null;
	private Actor checkpoint_3 = null;
	private Actor checkpoint_4 = null;
	private Actor checkpoint_5 = null;
	private Actor checkpoint_6 = null;
	private Actor checkpoint_7 = null;
	private Actor checkpoint_8 = null;
	private Actor checkpoint_9 = null;
	private Actor checkpoint_10 = null;
	private Actor checkpoint_11 = null;
	private Actor checkpoint_12 = null;
	private Actor checkpoint_13 = null;
	private Actor checkpoint_14 = null;
	private Actor checkpoint_15 = null;
	private Actor checkpoint_16 = null;
	private Actor checkpoint_17 = null;
	private Actor checkpoint_18 = null;
	private Actor checkpoint_19 = null;
	private Actor checkpoint_20 = null;
	private Actor checkpoint_21 = null;

	public DeLoreanView() {
		super(NR_HORIZONTAL_CELLS, NR_VERTICAL_CELLS, CELL_SIZE, null,
				"resources/sprites/western_background_redline_checkpoints.png", false);
		setSimulationPeriod(50);

		// Adding the actors to the Grid
		addActor(getLorean(), new Location(900, 100));
		addActor(getLorean().getThrust(), new Location(900, 140));
		addActor(getFirstLandingField(), new Location(275, 385));
		addActor(getSecondLandingField(), new Location(800, 950));
		addActor(getThirdLandingField(), new Location(1470, 770));
		addActor(getCheckpoint_1(), new Location(93, 99));
		addActor(getCheckpoint_2(), new Location(162, 310));
		addActor(getCheckpoint_3(), new Location(172, 152));
		addActor(getCheckpoint_4(), new Location(273, 399));
		addActor(getCheckpoint_5(), new Location(363, 415));
		addActor(getCheckpoint_6(), new Location(399, 437));
		addActor(getCheckpoint_7(), new Location(416, 550));
		addActor(getCheckpoint_8(), new Location(431, 468));
		addActor(getCheckpoint_9(), new Location(509, 770));
		addActor(getCheckpoint_10(), new Location(602, 903));
		addActor(getCheckpoint_11(), new Location(748, 976));
		addActor(getCheckpoint_12(), new Location(1077, 854));
		addActor(getCheckpoint_13(), new Location(1215, 250));
		addActor(getCheckpoint_14(), new Location(1216, 655));
		addActor(getCheckpoint_15(), new Location(1227, 560));
		addActor(getCheckpoint_16(), new Location(1263, 58));
		addActor(getCheckpoint_17(), new Location(1304, 20));
		addActor(getCheckpoint_18(), new Location(1320, 702));
		addActor(getCheckpoint_19(), new Location(1467, 567));
		addActor(getCheckpoint_20(), new Location(1508, 798));
		addActor(getCheckpoint_21(), new Location(1580, 725));

		setController(new XboxControllerListener(lorean, this));
		show();
	}

	private void showCellNumbers() {
		for (int i = 0; i < 1800; i++) {
			for (int j = 0; j < 1000; j++) {
				if (Color.RED.equals(getBg().getColor(new Point(i, j)))) {
					System.out.println(getBg().getColor(new Point(i, j)) + ": " + i + "," + j);
				}
			}
		}
	}

	public void buttonChecked(GGCheckButton arg0, boolean arg1) {
		System.out.print("new Location(" + arg0.getLocation().x + "," + arg0.getLocation().y + "), ");
	}

	public void gameStart() {
		removeAllActors();

		setBgImagePath("resources/sprites/western_background_redline_checkpoints.png");
		showCellNumbers();

		addActor(getLorean(), new Location(900, 100));
		addActor(getLorean().getThrust(), new Location(900, 140));
		addActor(getFirstLandingField(), new Location(275, 385));
		addActor(getSecondLandingField(), new Location(800, 950));
		addActor(getThirdLandingField(), new Location(1470, 770));
		addActor(getCheckpoint_1(), new Location(93, 99));
		addActor(getCheckpoint_2(), new Location(162, 310));
		addActor(getCheckpoint_3(), new Location(172, 152));
		addActor(getCheckpoint_4(), new Location(273, 399));
		addActor(getCheckpoint_5(), new Location(363, 415));
		addActor(getCheckpoint_6(), new Location(399, 437));
		addActor(getCheckpoint_7(), new Location(416, 550));
		addActor(getCheckpoint_8(), new Location(431, 468));
		addActor(getCheckpoint_9(), new Location(509, 770));
		addActor(getCheckpoint_10(), new Location(602, 903));
		addActor(getCheckpoint_11(), new Location(748, 976));
		addActor(getCheckpoint_12(), new Location(1077, 854));
		addActor(getCheckpoint_13(), new Location(1215, 250));
		addActor(getCheckpoint_14(), new Location(1216, 655));
		addActor(getCheckpoint_15(), new Location(1227, 560));
		addActor(getCheckpoint_16(), new Location(1263, 58));
		addActor(getCheckpoint_17(), new Location(1304, 20));
		addActor(getCheckpoint_18(), new Location(1320, 702));
		addActor(getCheckpoint_19(), new Location(1467, 567));
		addActor(getCheckpoint_20(), new Location(1508, 798));
		addActor(getCheckpoint_21(), new Location(1580, 725));

		getLorean().addCollisionActor(getFirstLandingField());
		getLorean().addCollisionActor(getSecondLandingField());
		getLorean().addCollisionActor(getThirdLandingField());
		getLorean().addCollisionActor(getCheckpoint_1());
		getLorean().addCollisionActor(getCheckpoint_2());
		getLorean().addCollisionActor(getCheckpoint_3());
		getLorean().addCollisionActor(getCheckpoint_4());
		getLorean().addCollisionActor(getCheckpoint_5());
		getLorean().addCollisionActor(getCheckpoint_6());
		getLorean().addCollisionActor(getCheckpoint_7());
		getLorean().addCollisionActor(getCheckpoint_8());
		getLorean().addCollisionActor(getCheckpoint_9());
		getLorean().addCollisionActor(getCheckpoint_10());
		getLorean().addCollisionActor(getCheckpoint_11());
		getLorean().addCollisionActor(getCheckpoint_12());
		getLorean().addCollisionActor(getCheckpoint_13());
		getLorean().addCollisionActor(getCheckpoint_14());
		getLorean().addCollisionActor(getCheckpoint_15());
		getLorean().addCollisionActor(getCheckpoint_16());
		getLorean().addCollisionActor(getCheckpoint_17());
		getLorean().addCollisionActor(getCheckpoint_18());
		getLorean().addCollisionActor(getCheckpoint_19());
		getLorean().addCollisionActor(getCheckpoint_20());
		getLorean().addCollisionActor(getCheckpoint_21());

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

	private Actor getCheckpoint_1() {
		if (checkpoint_1 == null) {
			setCheckpoint_1(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_1;
	}

	private void setCheckpoint_1(Actor checkpoint_1) {
		this.checkpoint_1 = checkpoint_1;
	}

	private Actor getCheckpoint_2() {
		if (checkpoint_2 == null) {
			setCheckpoint_2(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_2;
	}

	private void setCheckpoint_2(Actor checkpoint_2) {
		this.checkpoint_2 = checkpoint_2;
	}

	private Actor getCheckpoint_3() {
		if (checkpoint_3 == null) {
			setCheckpoint_3(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_3;
	}

	private void setCheckpoint_3(Actor checkpoint_3) {
		this.checkpoint_3 = checkpoint_3;
	}

	private Actor getCheckpoint_4() {
		if (checkpoint_4 == null) {
			setCheckpoint_4(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_4;
	}

	private void setCheckpoint_4(Actor checkpoint_4) {
		this.checkpoint_4 = checkpoint_4;
	}

	private Actor getCheckpoint_5() {
		if (checkpoint_5 == null) {
			setCheckpoint_5(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_5;
	}

	private void setCheckpoint_5(Actor checkpoint_5) {
		this.checkpoint_5 = checkpoint_5;
	}

	private Actor getCheckpoint_6() {
		if (checkpoint_6 == null) {
			setCheckpoint_6(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_6;
	}

	private void setCheckpoint_6(Actor checkpoint_6) {
		this.checkpoint_6 = checkpoint_6;
	}

	private Actor getCheckpoint_7() {
		if (checkpoint_7 == null) {
			setCheckpoint_7(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_7;
	}

	private void setCheckpoint_7(Actor checkpoint_7) {
		this.checkpoint_7 = checkpoint_7;
	}

	private Actor getCheckpoint_8() {
		if (checkpoint_8 == null) {
			setCheckpoint_8(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_8;
	}

	private void setCheckpoint_8(Actor checkpoint_8) {
		this.checkpoint_8 = checkpoint_8;
	}

	private Actor getCheckpoint_9() {
		if (checkpoint_9 == null) {
			setCheckpoint_9(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_9;
	}

	private void setCheckpoint_9(Actor checkpoint_9) {
		this.checkpoint_9 = checkpoint_9;
	}

	private Actor getCheckpoint_10() {
		if (checkpoint_10 == null) {
			setCheckpoint_10(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_10;
	}

	private void setCheckpoint_10(Actor checkpoint_10) {
		this.checkpoint_10 = checkpoint_10;
	}

	private Actor getCheckpoint_11() {
		if (checkpoint_11 == null) {
			setCheckpoint_11(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_11;
	}

	private void setCheckpoint_11(Actor checkpoint_11) {
		this.checkpoint_11 = checkpoint_11;
	}

	private Actor getCheckpoint_12() {
		if (checkpoint_12 == null) {
			setCheckpoint_12(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_12;
	}

	private void setCheckpoint_12(Actor checkpoint_12) {
		this.checkpoint_12 = checkpoint_12;
	}

	private Actor getCheckpoint_13() {
		if (checkpoint_13 == null) {
			setCheckpoint_13(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_13;
	}

	private void setCheckpoint_13(Actor checkpoint_13) {
		this.checkpoint_13 = checkpoint_13;
	}

	private Actor getCheckpoint_14() {
		if (checkpoint_14 == null) {
			setCheckpoint_14(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_14;
	}

	private void setCheckpoint_14(Actor checkpoint_14) {
		this.checkpoint_14 = checkpoint_14;
	}

	private Actor getCheckpoint_15() {
		if (checkpoint_15 == null) {
			setCheckpoint_15(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_15;
	}

	private void setCheckpoint_15(Actor checkpoint_15) {
		this.checkpoint_15 = checkpoint_15;
	}

	private Actor getCheckpoint_16() {
		if (checkpoint_16 == null) {
			setCheckpoint_16(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_16;
	}

	private void setCheckpoint_16(Actor checkpoint_16) {
		this.checkpoint_16 = checkpoint_16;
	}

	private Actor getCheckpoint_17() {
		if (checkpoint_17 == null) {
			setCheckpoint_17(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_17;
	}

	private void setCheckpoint_17(Actor checkpoint_17) {
		this.checkpoint_17 = checkpoint_17;
	}

	private Actor getCheckpoint_18() {
		if (checkpoint_18 == null) {
			setCheckpoint_18(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_18;
	}

	private void setCheckpoint_18(Actor checkpoint_18) {
		this.checkpoint_18 = checkpoint_18;
	}

	private Actor getCheckpoint_19() {
		if (checkpoint_19 == null) {
			setCheckpoint_19(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_19;
	}

	private void setCheckpoint_19(Actor checkpoint_19) {
		this.checkpoint_19 = checkpoint_19;
	}

	private Actor getCheckpoint_20() {
		if (checkpoint_20 == null) {
			setCheckpoint_20(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_20;
	}

	private void setCheckpoint_20(Actor checkpoint_20) {
		this.checkpoint_20 = checkpoint_20;
	}

	private Actor getCheckpoint_21() {
		if (checkpoint_21 == null) {
			setCheckpoint_21(new Actor("resources/sprites/red_pixel.png"));
		}
		return checkpoint_21;
	}

	private void setCheckpoint_21(Actor checkpoint_21) {
		this.checkpoint_21 = checkpoint_21;
	}
}