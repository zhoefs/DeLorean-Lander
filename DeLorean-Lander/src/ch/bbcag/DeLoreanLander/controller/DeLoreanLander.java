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
	private double acceleration; // Beschleunigung vom DeLorean
	private boolean fuelExpired; // Kraftstoff abgelaufen
	private double remainFuel; // verbleibender Kraftstoff
	private double fuelFactor = 0.5;
	private int ds = 0;
	private double positionDown;
	private double thrustLevel;
	private double positionEast;

	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");
	}

	public void act() {
		System.out.println("Position X: " + positionX + "     DS: " + ds);
		if (getX() >= 5 && getX() <= 175) {
			positionX += ds;
		}

		this.setLocation(new Location(this.positionX, positionY));

		final GameGrid gg = gameGrid;
		final double vdisp = (int) (100 * positionDown) / 100.0;
		String s;
		if (fuelExpired) {
			s = String.format(" Acceleration = %10.2f m/s^2      Fuel = %10.0f kg", acceleration, remainFuel);
		} else {
			s = String.format(" Acceleration = %10.2f m/s^2    	 Fuel = %10.0f kg", acceleration, remainFuel);
		}
		gg.setTitle(s);

		final double dt = 2 * gg.getSimulationPeriod() / 1000.0;
		speedDown = positionDown + acceleration * dt;
		positionDown = positionDown + positionDown * dt;
		remainFuel = remainFuel - thrustLevel * fuelFactor;

	}

	public void accelerate(int dpadCode) {
		if (dpadCode == 5 || dpadCode == 6 || dpadCode == 7) {
			if (getX() <= 5)
				ds = 0;
			else {
				ds = -1;
			}
			positionX = getX() + ds;
		}
		if (dpadCode == 1 || dpadCode == 2 || dpadCode == 3) {
			if (getX() >= 175)
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