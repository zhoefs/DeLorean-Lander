package ch.bbcag.DeLoreanLander.view;

import com.sun.prism.paint.Color;

import ch.aplu.jgamegrid.GGKeyListener;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.controller.DeLoreanLander;

public class DeLoreanView extends GameGrid {

	private static final long serialVersionUID = 1L;

	public DeLoreanView() {
		super(1700, 1000, 1,null,"resources/sprites/western_background.png", false);
		setSimulationPeriod(50);
		final DeLoreanLander lorean = new DeLoreanLander();
		addActor(lorean, new Location(330, 100));
		addKeyListener(lorean);
		show();
		GameGrid.delay(3000);
		doRun(); 
	}

	public static void main(final String[] args) {
		new DeLoreanView();
	}
}
