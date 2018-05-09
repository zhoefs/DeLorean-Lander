package ch.bbcag.DeLoreanLander.controller;

import java.awt.Color;
import java.awt.Font;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import ch.aplu.jgamegrid.Location;
import ch.aplu.jgamegrid.TextActor;

public class DeLoreanLander extends Actor implements GGActorCollisionListener {
	private static final double MAX_ACCELERATION = 1.6;
	private static final int MAX_POWER_LEVELS = 8;

	// private Actor button1 = new Actor("resources/sprites/thrust.png");
	// private GGButton button2 = new
	// GGButton(resources/sprites/explosion_icon.png);

	private double velocity = 0d;
	private double acceleration = MAX_ACCELERATION; // Beschleunigung vom DeLorean
	private int powerLevel = 0;
	private Actor crashedCar = new Actor("resources/sprites/you_crashed.png");
	private Actor landedCar = new Actor("resources/sprites/you_won.png");
	private Actor firework = new Actor("resources/sprites/firework.gif");

	private int horizontalVelocity = 0; // -1: left, 0: stay, 1: right

	private double xPos = 900;
	private double yPos = 100;
	private double remainFuel = 2000.0d;
	private static final double FUEL_FACTOR = 0.5d;
	private boolean fuelExpired = false;

	private Actor thrust = null;

	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");
		addActorCollisionListener(this);
		thrust = new Actor("resources/sprites/thrust.png", 9);
	}

	@Override
	public int collide(Actor deLorean, Actor landingBase) {
		if (velocity <= 10) {
			gameGrid.doPause();
			gameGrid.removeAllActors();
			gameGrid.setBgImagePath(null);
			gameGrid.addActor(landedCar, new Location(860,200));
			gameGrid.addActor(firework, new Location(200,800));
//			gameGrid.addActor(new TextActor("Press START to Restart or BACK to Leave", Color.WHITE, Color.BLACK,
//					new Font(Font.SANS_SERIF, Font.BOLD, 24)), new Location(700, 700));
//			

			velocity = 0d;
			acceleration = MAX_ACCELERATION; // Beschleunigung vom DeLorean
			powerLevel = 0;

			horizontalVelocity = 0; // -1: left, 0: stay, 1: right

			xPos = 900;
			yPos = 100;
			remainFuel = 2000;
			fuelExpired = false;

		} else {
			deLorean.hide();
			final Actor explosion = new Actor("resources/sprites/explosion_icon.png");
			thrust.hide();
			gameGrid.addActor(explosion, new Location(deLorean.getX(), deLorean.getY() - 20));

			gameGrid.doPause();
			gameGrid.addActor(crashedCar, new Location(860,200));

//			gameGrid.addActor(
//					new TextActor("You crashed! Press START to Restart or BACK to Leave", Color.BLACK, Color.WHITE, new Font(Font.SANS_SERIF, Font.BOLD, 35)),
//					new Location(500, 200));

			velocity = 0d;
			acceleration = MAX_ACCELERATION; // Beschleunigung vom DeLorean
			powerLevel = 0;

			horizontalVelocity = 0; // -1: left, 0: stay, 1: right

			xPos = 900;
			yPos = 100;
			remainFuel = 2000;
			fuelExpired = false;

		}
		return 0;
	}

	public void act() {

		// vertical
		final double dt = 2 * gameGrid.getSimulationPeriod() / 800.0;

		String s;
		if (fuelExpired) {
			s = String.format("   Velocity = %10.2f m/s    Acceleration = %10.2f m/s    Fuel = %10.0f kg", velocity,
					acceleration, remainFuel);
		} else {
			s = String.format("   Velocity = %10.2f m/s    Acceleration = %10.2f m/s    Fuel = %10.0f kg", velocity,
					acceleration, remainFuel);
		}
		gameGrid.setTitle(s);
		velocity = velocity + acceleration * dt;
		yPos = yPos + velocity * dt;
		remainFuel = remainFuel - powerLevel * FUEL_FACTOR;

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

		if (remainFuel <= 0) {
			remainFuel = 0;
			powerLevel = 0;
			acceleration = MAX_ACCELERATION;
			fuelExpired = true;
			thrust.hide();
		}
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
			if (powerLevel < MAX_POWER_LEVELS) {
				acceleration -= accelerationFactor;
				powerLevel += 1;
				getThrust().show(powerLevel);
			}
		}

		// down
		if (dpadCode == 4) {
			if (powerLevel > 0) {
				acceleration += accelerationFactor;
				powerLevel -= 1;
				getThrust().show(powerLevel);
			}
		}
	}

	public Actor getThrust() {
		return thrust;
	}
}
