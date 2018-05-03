package ch.bbcag.DeLoreanLander.controller;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import ch.aplu.jgamegrid.Location;

public class DeLoreanLander extends Actor implements GGActorCollisionListener {

	private int positionX = 60;
	private int positionY = 8;
	private double speedDown = 1;
	public void setSpeedDown(double speedDown) {
		this.speedDown = speedDown;
	}

	private double acceleration; // Beschleunigung vom DeLorean
	private boolean fuelExpired; // Kraftstoff abgelaufen
	private double remainFuel; // verbleibender Kraftstoff
	private int direction = 0; // -1 left, 1 right, 0 stay
	private int fallSpeed = 5;

	public DeLoreanLander() {
		super("resources/sprites/lorean_car.png");
		addActorCollisionListener(this);
	}

	@Override
	public int collide(Actor deLorean, Actor landingBase) {
		((DeLoreanLander) deLorean).setSpeedDown(0);
		final Actor explosion = new Actor("resources/sprites/explosion_icon.png");
		gameGrid.addActor(explosion, new Location(deLorean.getX(), deLorean.getY() - 2));
		deLorean.hide();
		return super.collide(deLorean, landingBase);
	}

	public void act() {

		// new horizontal location
		if (getX() >= 5 && getX() <= 175) {
			positionX += direction;
		}

		// new vertical location - DeLorean falls down
		setSlowDown(fallSpeed);
		positionY = (int) (positionY + speedDown);

		checkPositionOutOfGrid();

		this.setLocation(new Location(this.positionX, positionY));

	}

	public void accelerate(int dpadCode) {
		if (dpadCode == 5 || dpadCode == 6 || dpadCode == 7) {
			if (getX() <= 5) {
				direction = 0;
			} else {
				direction = -1;
			}
			positionX = getX() + direction;
		}
		if (dpadCode == 1 || dpadCode == 2 || dpadCode == 3) {
			if (getX() >= 175) {
				direction = 0;
			} else {
				direction = 1;
			}
			positionX = getX() + direction;
		}
		
		if (dpadCode == 0) {
			
			// down
			if(speedDown > 0) {
				if(fallSpeed != 10) {
					fallSpeed++;
				}
				
				if(fallSpeed == 10) {
					speedDown = 0;
				}
				
			}
			
			// stay
			else if (speedDown == 0) {
				speedDown = -1;
			}
			
			// up
			else {
				if(fallSpeed >= 5) {
					fallSpeed--;
				}
			}
		}
	}

	public void accelerateUp(int dpadCode) {
		if (dpadCode == 0) {
			positionY = (int) (getY() - direction - speedDown);
			System.out.println("Schnelligkeit: " + speedDown);
			speedDown = speedDown - 0.1;
		}
	}

	private void checkPositionOutOfGrid() {
		if (getY() >= 98) {
		}
	}

	public void stop() {
		direction = 0;
	}
}