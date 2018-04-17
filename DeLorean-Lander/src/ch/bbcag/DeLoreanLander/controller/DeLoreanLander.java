package ch.bbcag.DeLoreanLander.controller;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.util.HiResTimer;

public class DeLoreanLander {
	private double startFuel= 1000;
	private final Actor lorean = new Actor("sprites/lorean_car.gif");
	private boolean isLanded = false;
	private final HiResTimer timer = new HiResTimer();
	private double speedDown;
	private double speedUp;
	private boolean fuelExpired;
	
	public DeLoreanLander() {
		}
}
