package ch.bbcag.DeLoreanLander.controller;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import ch.bbcag.DeLoreanLander.view.DeLoreanView;

public class DeLoreanLander extends Actor {

	private int positionX = 60;
	private int positionY = 8;
	private double speedDown = 1;
	private double acceleration; // Beschleunigung vom DeLorean
	private boolean fuelExpired; // Kraftstoff abgelaufen
	private double remainFuel; // verbleibender Kraftstoff
	private int direction = 0; // -1 left, 1, right, 0

	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");
	}

	public void act() {

		System.out.println("Position X: " + positionX + "     DS: " + direction);
		if (getX() >= 5 && getX() <= 175) {
			positionX += direction;
		}
		System.out.println("Position Y: " + positionY + "     DS: " + direction);
		if (getY() >= 95 && getY() <= 5) {
			positionY += direction;
		}

		positionY = (int) (positionY + speedDown);
		checkPositionOutOfGrid();

		this.setLocation(new Location(this.positionX, positionY));

		final GameGrid gg = gameGrid;
		String s;
		if (fuelExpired) {
			s = String.format(" Acceleration = %10.2f m/s^2      Fuel = %10.0f kg", acceleration, remainFuel);
		} else {
			s = String.format(" Acceleration = %10.2f m/s^2    	 Fuel = %10.0f kg", acceleration, remainFuel);
		}
		gg.setTitle(s);

		Actor actor = gameGrid.getOneActorAt(this.getLocation(), DeLoreanView.class);
		if (actor != null) {
		}
	}

	public void accelerate(int dpadCode) {
		if (dpadCode == 5 || dpadCode == 6 || dpadCode == 7) {
			if (getX() <= 5)
				direction = 0;
			else {
				direction = -1;
			}
			positionX = getX() + direction;
		}
		if (dpadCode == 1 || dpadCode == 2 || dpadCode == 3) {
			if (getX() >= 175)
				direction = 0;
			else {
				direction = 1;
			}
			positionX = getX() + direction;
		}
		if (dpadCode == 0) {
			if (getX() <= 5)
				direction = 1;
			else {
				direction = 0;
			}
		}
	}

	private void checkPositionOutOfGrid() {
		if (getY() >= 98)
			direction = 0;
		else {
			direction = 1;
		}
		positionY = getY() + direction;

		if (getY() <= 5)
			direction = -1;
		else {
			direction = 0;
		}
	}

	public void stop() {
		direction = 0;
	}
}