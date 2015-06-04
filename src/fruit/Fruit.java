package fruit;

import java.awt.Color;
import java.util.Random;

import utility.Constants;
import utility.Constants.Direction;

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
	protected int fruitXPos, fruitYPos;
	protected Color color;
	
	/**
	 * Fruit Constructor
	 */
	public Fruit() {
		r1 = new Random();
		this.fruitXPos = r1.nextInt(799); //randomly generate a starting x-coordinate
		this.fruitYPos = r1.nextInt(479); //randomly generate a starting y-coordinate
		this.eaten = false;
	}
	
	/**
	 * Get the fruit's x-coordinate
	 * @return fruitXPos
	 */
	public int getFruitX() {
		return fruitXPos;
	}
	
	/**
	 * Get the fruit's y-coordinate
	 * @return fruitYPos
	 */
	public int getFruitY() {
		return fruitYPos;
	}
	
	/**
	 * Set the fruit's x-coordinate
	 * @param fruitX
	 */
	public void setFruitX(int fruitX) {
		this.fruitXPos = fruitX;
	}
	
	/**
	 * Set the fruit's y-coordinate
	 * @param fruitY
	 */
	public void setFruitY(int fruitY) {
		this.fruitYPos = fruitY;
	}
	
	/**
	 * returns true if the fruit has been eaten
	 * @return
	 */
	public boolean isEaten() {
		return eaten;
	}
	
	/**
	 * Set if the fruit has been eaten
	 * @param eaten
	 */
	public void setEaten(boolean eaten) {
		this.eaten = eaten;
	}
	
	/**
	 * Get the color of the fruit
	 * @return
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Pause/Unpause the fruit
	 */
	public void pause(){
		if(!isPaused){
			this.currentSpeed = Constants.PAUSE;
		} else{
			this.currentSpeed = this.defaultSpeed;
		}
		this.isPaused = !this.isPaused;
	}
	
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
}
