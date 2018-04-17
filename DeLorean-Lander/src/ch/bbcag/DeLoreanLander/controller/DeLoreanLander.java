package ch.bbcag.DeLoreanLander.controller;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.util.HiResTimer;

public class DeLoreanLander extends Actor{
	private double startFuel= 1000;
	private final Actor lorean = new Actor("resources/sprites/lorean_car.png");
	private boolean isLanded = false;
	private final HiResTimer timer = new HiResTimer();
	private double positionX; 
	private double positionY;
	private double speedDown;
	private double speedUp;
	private double acceleration; // Beschleunigungvom DeLorean
	private boolean fuelExpired; // Kraftstoff abgelaufen
	private double remainFuel; // verbleibender Kraftstoff
//	private final Actor firstLandingField = new Actor("resources/sprites/landing_path.png");
//	private final Actor secondLandingField = new Actor("resources/sprites/landing_path.png");
//	private final Actor thirdLandingField = new Actor("resources/sprites/landing_path.png");
	
	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");
		}
	
	@Override
	public void reset() {
		final GameGrid gg = gameGrid;
		positionY = getLocationStart().x;
		positionY = getLocationStart().y;
		speedDown = 0;
	}

	public double getStartFuel() {
		return startFuel;
	}

	public void setStartFuel(double startFuel) {
		this.startFuel = startFuel;
	}

	public Actor getLorean() {
		return lorean;
	}

	public boolean isLanded() {
		return isLanded;
	}

	public void setLanded(boolean isLanded) {
		this.isLanded = isLanded;
	}

	public HiResTimer getTimer() {
		return timer;
	}

	public double getSpeedDown() {
		return speedDown;
	}

	public void setSpeedDown(double speedDown) {
		this.speedDown = speedDown;
	}

	public double getSpeedUp() {
		return speedUp;
	}

	public void setSpeedUp(double speedUp) {
		this.speedUp = speedUp;
	}

	public boolean isFuelExpired() {
		return fuelExpired;
	}

	public void setFuelExpired(boolean fuelExpired) {
		this.fuelExpired = fuelExpired;
	}

	public double getRemainFuel() {
		return remainFuel;
	}

	public void setRemainFuel(double remainFuel) {
		this.remainFuel = remainFuel;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	
}
