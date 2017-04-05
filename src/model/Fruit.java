package model;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import util.Constants;
import util.Constants.Direction;

/**
 * Basic Fruit object
 * @author Justin, Justin
 *
 */
public abstract class Fruit {

	protected Random r1;
	protected boolean eaten;
	protected boolean isPaused;
	protected int value;
	protected int defaultSpeed;
	protected int currentSpeed;
	protected Point position;
	protected Color color;
	protected String fruitImage;
	
	/**
	 * update the fruit's values
	 */
	public abstract void update();
	
	/**
	 * Get the current speed of the fruit
	 * @return speed
	 */
	public abstract int getSpeed();
	
	/**
	 * set the direction of the fruit
	 * @param direction
	 */
	public abstract void setDirection(Direction direction);
	
	/**
	 * Get the current direction of the fruit
	 * @return direction
	 */
	public abstract Direction getDirection();
	
	
	/**
	 * Fruit Constructor
	 */
	public Fruit() {
		r1 = new Random();
		position = new Point(r1.nextInt(Constants.GAME_PANEL_WIDTH), r1.nextInt(Constants.GAME_PANEL_HEIGHT));
		this.eaten = false;
	}
	
	/**
	 * Pause/Unpause the fruit
	 */
	public void pause() {
		if (!isPaused) {
			this.currentSpeed = Constants.PAUSE;
		} else {
			this.currentSpeed = this.defaultSpeed;
		}
		this.isPaused = !this.isPaused;
	}

	public Random getR1() {
		return r1;
	}

	public void setR1(Random r1) {
		this.r1 = r1;
	}

	public boolean isEaten() {
		return eaten;
	}

	public void setEaten(boolean eaten) {
		this.eaten = eaten;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDefaultSpeed() {
		return defaultSpeed;
	}

	public void setDefaultSpeed(int defaultSpeed) {
		this.defaultSpeed = defaultSpeed;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getFruitImage() {
		return fruitImage;
	}

	public void setFruitImage(String fruitImage) {
		this.fruitImage = fruitImage;
	}
}
