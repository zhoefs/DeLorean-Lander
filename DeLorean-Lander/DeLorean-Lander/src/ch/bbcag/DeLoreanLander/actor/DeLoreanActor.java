package ch.bbcag.DeLoreanLander.actor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import ch.aplu.jgamegrid.Location;
import ch.aplu.jgamegrid.TextActor;
import ch.bbcag.DeLoreanLander.util.TimeUtil;

public class DeLoreanActor extends Actor implements GGActorCollisionListener {

	private static final double MAX_ACCELERATION = 1.6;
	private static final int MAX_POWER_LEVELS = 8;
	private static final double FUEL_FACTOR = 0.5d;
	private static final int DELOREAN_SPRITE_SIZE = 100;

	private static double acceleration_time;

	// Actors
	private Actor crashedCar = new Actor("resources/sprites/you_crashed.png");
	private Actor landedCar = new Actor("resources/sprites/you_won.png");
	private Actor restart = new Actor("resources/sprites/restart.png");
	private FireworkActor firework = new FireworkActor("resources/sprites/firework.jpg", 46);
	private Actor thrust = null;

	private double acceleration = MAX_ACCELERATION; // Acceleration from DeLorean
	private int horizontalVelocity = 0; // -30: left, 0: stay, 30: right
	private double velocity = 0d;
	private int powerLevel = 0;
	private int xPos = 900;
	private int yPos = 100;
	private double remainFuel = 1000.0d;
	private boolean fuelExpired = false;

	public DeLoreanActor() {
		super("resources/sprites/lorean_car.png");
		addActorCollisionListener(this);
		thrust = new Actor("resources/sprites/thrust.png", 9);
		DeLoreanActor.acceleration_time = 2 * gameGrid.getSimulationPeriod() / 800;
	}

	public void reset() {
		velocity = 0d;
		acceleration = MAX_ACCELERATION;
		powerLevel = 0;
		horizontalVelocity = 0;

		xPos = 900;
		yPos = 100;
		remainFuel = 1000;
		fuelExpired = false;
	}

	@Override
	public int collide(Actor deLorean, Actor actor) {
		gameGrid.doPause();

		if (actor instanceof LandingBaseActor && velocity <= 10) {
			long endTime = System.nanoTime();
			long passedTime = endTime - TimeUtil.getStartTime();
			passedTime = passedTime / 1000000000;
			thrust.hide();
			gameGrid.removeAllActors();
			gameGrid.setBgImagePath(null);
			gameGrid.setTitle(null);
			gameGrid.addActor(landedCar, new Location(860, 200)); // Text, if the player wins
			gameGrid.addActor(firework, new Location(900, 800));
			gameGrid.addActor(new TextActor("Press START to Restart or BACK to Leave", Color.WHITE, Color.BLACK,
					new Font(Font.SANS_SERIF, Font.BOLD, 24)), new Location(700, 400));
			int score = (int) (remainFuel * 5 + passedTime * 50);

			// TODO comment
			if (score <= 0) {
				score = 100;
			}
			gameGrid.getBg().drawText("You've reached " + score + " " + "Points", new Point(780, 500));
			gameGrid.doRun();
			reset();
		} else {
			deLorean.hide();
			final Actor explosion = new Actor("resources/sprites/explosion_icon.png");
			thrust.hide();
			gameGrid.addActor(explosion, new Location(deLorean.getX(), deLorean.getY() - 20));
			gameGrid.addActor(crashedCar, new Location(860, 200)); // Text, if the player loses
			gameGrid.addActor(restart, new Location(870, 350));
			reset();
		}
		return 0;
	}

	public void act() {

		Location deLoreanFront = new Location(((int) xPos + DELOREAN_SPRITE_SIZE / 2 - 1), (int) yPos);
		Location deLoreanBack = new Location(((int) xPos - (DELOREAN_SPRITE_SIZE / 2 - 1)), (int) yPos);

		if (gameGrid.getBg().getColor(deLoreanFront).equals(Color.RED)
				|| gameGrid.getBg().getColor(deLoreanBack).equals(Color.RED)) {
			collide(this, new Actor());
		}

		// vertical
		String s;
		if (fuelExpired) {
			s = String.format("   Velocity = %10.2f m/s    Acceleration = %10.2f m/s    Fuel = %10.0f kg", velocity,
					acceleration, remainFuel);
		} else {
			s = String.format("   Velocity = %10.2f m/s    Acceleration = %10.2f m/s    Fuel = %10.0f kg", velocity,
					acceleration, remainFuel);
		}
		gameGrid.setTitle(s);
		velocity = velocity + acceleration * acceleration_time;
		yPos = (int) (yPos + velocity * acceleration_time);
		remainFuel = remainFuel - powerLevel * FUEL_FACTOR;

		if (yPos <= 50) {
			velocity = 0d;
			acceleration = MAX_ACCELERATION;
			powerLevel = 0;
			horizontalVelocity = 0;
			getThrust().show(0);
		}

		// horizontal
		xPos = xPos + horizontalVelocity;

		setLocation(new Location(xPos, yPos));

		getThrust().setLocation(new Location(xPos, yPos + 40));
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
			horizontalVelocity -= 30;
		}

		// right
		if (dpadCode == 1 || dpadCode == 2 || dpadCode == 3) {
			horizontalVelocity += 30;
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
