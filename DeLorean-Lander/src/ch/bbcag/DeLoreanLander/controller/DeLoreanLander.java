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
	private double fuelFactor = 0.5;
	
	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");
		}
	
	@Override
	public void reset() {
		final GameGrid gg = gameGrid;
		positionY = getLocationStart().x;
		positionY = getLocationStart().y;
		speedDown = 0;
		remainFuel = startFuel;
		fuelExpired = false;
	}
}