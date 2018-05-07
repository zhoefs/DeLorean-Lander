package ch.bbcag.DeLoreanLander.controller;

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

	private double xPos = 900;
	private double yPos = 100;
	private double remainFuel;
	private double fuelFactor = 0.5;

	private Actor thrust = null;

	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");
		addActorCollisionListener(this);
	}

	@Override
	public int collide(Actor deLorean, Actor landingBase) {
		final Actor explosion = new Actor("resources/sprites/explosion_icon.png");
		gameGrid.addActor(explosion, new Location(deLorean.getX(), deLorean.getY() - 20));
		deLorean.hide();
		setActEnabled(false);
		powerLevel = 0;
		return super.collide(deLorean, landingBase);
	}

	public void act() {

		// vertical
		final double dt = 2 * gameGrid.getSimulationPeriod() / 800.0;
		velocity = velocity + acceleration * dt;
		yPos = yPos + velocity * dt;

		if (yPos <= 50) {
			acceleration = MAX_ACCELERATION;
			powerLevel = 0;
			velocity = 0;
		}

		// horizontal
		xPos = xPos + horizontalVelocity;

		if (xPos <= 50 || xPos >= 1750) {
			horizontalVelocity = 0;
		}
		setLocation(new Location((int) xPos, (int) yPos));

		getThrust().setLocation(new Location((int) xPos, (int) yPos + 40));
		horizontalVelocity = 0;
		remainFuel = remainFuel - powerLevel * fuelFactor;
	}

	public void accelerate(int dpadCode) {

		final double accelerationFactor = 2 * MAX_ACCELERATION / MAX_POWER_LEVELS;

		// left
		if (dpadCode == 5 || dpadCode == 6 || dpadCode == 7) {
			horizontalVelocity = -30;
		}

		// right
		if (dpadCode == 1 || dpadCode == 2 || dpadCode == 3) {
			horizontalVelocity = 30;
		}

		// up
		if (dpadCode == 0) {
			if (powerLevel <= MAX_POWER_LEVELS) {
				acceleration -= accelerationFactor;
				powerLevel += 1;
				getThrust().show(powerLevel);
			}
		}

		// down
		if (dpadCode == 4) {
			if (powerLevel >= 0) {
				acceleration += accelerationFactor;
				powerLevel -= 1;
				getThrust().show(powerLevel);
			}
		}
	}

	private Actor getThrust() {
		if (thrust == null) {
			setThrust(new Actor("resources/sprites/thrust.png", 9));
		}
		return thrust;
	}

	private void setThrust(Actor thrust) {
		this.thrust = thrust;
		gameGrid.addActor(thrust, new Location((int) xPos, (int) yPos + 40));
	}
}