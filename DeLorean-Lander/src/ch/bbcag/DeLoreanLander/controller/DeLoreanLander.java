package ch.bbcag.DeLoreanLander.controller;

import java.awt.event.KeyEvent;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import ch.aplu.jgamegrid.Location;

public class DeLoreanLander extends Actor implements GGActorCollisionListener {
	private static final double MAX_ACCELERATION = 1.6;
	private static final int MAX_POWER_LEVELS = 8;

	private double velocity = 0d;
	private double acceleration = MAX_ACCELERATION; // Beschleunigung vom DeLorean
	private int powerLevel = 0;

	private int horizontalVelocity = 0; // -1: left, 0: stay, 1: right

	private double xPos = 90;
	private double yPos = 10;
	private double remainFuel;
	private double fuelFactor = 0.5;
	private final Actor thrust = new Actor("resources/sprites/thrust.png", 9);

	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");
		addActorCollisionListener(this);
	}

	@Override
	public int collide(Actor deLorean, Actor landingBase) {
		final Actor explosion = new Actor("resources/sprites/explosion_icon.png");
		gameGrid.addActor(explosion, new Location(deLorean.getX(), deLorean.getY() - 2));
		deLorean.hide();
		setActEnabled(false);
		powerLevel = 0;
		return super.collide(deLorean, landingBase);
	}

	public void act() {

		// vertical
		final double dt = 2 * gameGrid.getSimulationPeriod() / 1000.0; // Time scaled: * 2
		velocity = velocity + acceleration * dt;
		yPos = yPos + velocity * dt;

		if (yPos <= 5) {
			acceleration = MAX_ACCELERATION;
			powerLevel = 0;
			velocity = 0;
		}
		

		// horizontal
		xPos = xPos + horizontalVelocity;

		if (xPos <= 5 || xPos >= 175) {
			horizontalVelocity = 0;
		}

		setLocation(new Location((int) xPos, (int) yPos));
		thrust.setLocation(new Location((int) xPos, (int) yPos));
		horizontalVelocity = 0;
		remainFuel = remainFuel - powerLevel * fuelFactor;
	}

	public void accelerate(int dpadCode) {
		final double accelerationFactor = 2 * MAX_ACCELERATION / MAX_POWER_LEVELS;

		if (dpadCode == 5 || dpadCode == 6 || dpadCode == 7) {
			horizontalVelocity = -3;
		}

		if (dpadCode == 1 || dpadCode == 2 || dpadCode == 3) {
			horizontalVelocity = 3;
		}

		// up
		if (dpadCode == 0) {
			if (powerLevel <= MAX_POWER_LEVELS) {
				acceleration -= accelerationFactor;
				powerLevel += 1; // Beschleunigung um 1 erhöht
			}
			if (acceleration == MAX_ACCELERATION) {
				setThrust(0);

			} else {
				setThrust(powerLevel);
			}
		}

		// down
		if (dpadCode == 4) {
			if (powerLevel >= 0) {
				acceleration += accelerationFactor;
				powerLevel -= 1; // Beschleunigung um 1 gesenkt
			}
		}
	}
	

	private void setThrust(int i) {
		if (i < 0) {
			i = 0;
		}
		if (i > 8) {
			i = 8;
		}
		thrust.show(i);
	}
}