package ch.bbcag.DeLoreanLander.controller;

import ch.aplu.jgamegrid.*;
import ch.aplu.util.HiResTimer;

public class DeLoreanLander extends Actor {
	private double startFuel = 1000;
	private final Actor lorean = new Actor("resources/sprites/lorean_car.png");
	private boolean isLanded = false;
	private final HiResTimer timer = new HiResTimer();
	private int positionX = 60;
	private int positionY = 10;
	private double speedDown;
	private double speedUp;
	private double acceleration; // Beschleunigungvom DeLorean
	private boolean fuelExpired; // Kraftstoff abgelaufen
	private double remainFuel; // verbleibender Kraftstoff
	private double fuelFactor = 0.5;
	private int ds = 0;

	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");	
	}

	/*
	 * @Override public void reset() { final GameGrid gg = gameGrid; positionY =
	 * getLocationStart().x; positionY = getLocationStart().y; speedDown = 0;
	 * remainFuel = startFuel; fuelExpired = false; }
	 */

	public void act() {		
		System.out.println("Position X: " + positionX + "     DS: " + ds);
		positionX += ds;
		
		this.setLocation(new Location(this.positionX, positionY));
	}

	public void accelerate(int dpadCode) {
		
		if (dpadCode == 5||dpadCode == 6||dpadCode == 7) {
			if (getX() == 5)
				ds = 0;
			else {
				ds = -1;
			}
			positionX = getX() + ds;
		}
		if (dpadCode == 1||dpadCode == 2||dpadCode == 3) {
			if (getX() == 175)
				ds = 0;
			else {
				ds = 1;
			}
			positionX = getX() + ds;
		}
	}

	public void stop() {
		ds = 0;
	}
}