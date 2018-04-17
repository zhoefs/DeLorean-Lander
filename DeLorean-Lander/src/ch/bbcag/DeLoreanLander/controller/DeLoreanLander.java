package ch.bbcag.DeLoreanLander.controller;

import java.awt.event.KeyEvent;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGKeyListener;
import ch.aplu.util.HiResTimer;

public class DeLoreanLander extends Actor implements GGKeyListener {
	private double startFuel= 1000;
	private final Actor lorean = new Actor("resources/sprites/lorean_car.png");
	private boolean isLanded = false;
	private final HiResTimer timer = new HiResTimer();
	private double speedDown;
	private double speedUp;
	private boolean fuelExpired; // Kraftstoff abgelaufen
	private double remainFuel; // verbleibender Kraftstoff
//	private final Actor firstLandingField = new Actor("sprites/");
//	private final Actor secondLandingField = new Actor("sprites/");
//	private final Actor thirdLandingField = new Actor("sprites/");
	
	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");
		
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

	@Override
	public boolean keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
