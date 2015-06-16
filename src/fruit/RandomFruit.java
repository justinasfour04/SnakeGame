package fruit;

import java.util.Random;

import utility.Constants;
import utility.Constants.Direction;

/**
 * A Fruit that can move in 2 dimensions 
 * @author Justin
 *
 */
public class RandomFruit extends Fruit{
	
	private int speed;
	private boolean isPaused;
	private Direction currentDirection;
	/**
	 * Creates a new RandomFruit
	 */
	public RandomFruit(){
		super();
		
		this.value = Constants.RANDOM_FRUIT_VALUE;
		this.currentSpeed = Constants.RANDOM_FRUIT_SPEED;
		this.defaultSpeed = Constants.RANDOM_FRUIT_SPEED;
		this.color = Constants.RANDOM_FRUIT_COLOR;
		this.isPaused = false;
		this.fruitImage = Constants.LINEAR_FRUIT_IMAGE; //TODO: Create new fruit sprite
		
		Random r = new Random();
		int directionID = r.nextInt(8); //randomly choose a starting direction
		switch (directionID) {
		case 0:
			this.currentDirection = Direction.NORTH;		
			break;
		case 1:
			this.currentDirection = Direction.SOUTH;		
			break;
		case 2:
			this.currentDirection = Direction.WEST;		
			break;
		case 3:
			this.currentDirection = Direction.EAST;		
			break;
		case 4:
			this.currentDirection = Direction.NORTHEAST;		
			break;
		case 5:
			this.currentDirection = Direction.SOUTHEAST;		
			break;
		case 6:
			this.currentDirection = Direction.SOUTHWEST;		
			break;
		case 7:
			this.currentDirection = Direction.NORTHWEST;		
			break;
		}
	}
	
	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void update() {
		move(this.currentDirection);
	}

	@Override
	public void setDirection(Direction d) {
		this.currentDirection = d;
		
	}
	
	/**
	 * Moves the fruit depending on its direction
	 * @param direction
	 */
	private void move(Direction direction) {
		switch (direction) {
		case NORTH:
			this.fruitYPos += currentSpeed;		
			break;
		case SOUTH:
			this.fruitYPos -= currentSpeed;
			break;
		case EAST:
			this.fruitXPos += currentSpeed;
			break;
		case WEST:
			this.fruitXPos -= currentSpeed;
			break;
		case NORTHEAST:
			this.fruitXPos += currentSpeed;
			this.fruitYPos += currentSpeed;
			break;
		case NORTHWEST:
			this.fruitXPos -= currentSpeed;
			this.fruitYPos += currentSpeed;
			break;
		case SOUTHEAST:
			this.fruitXPos += currentSpeed;
			this.fruitYPos -= currentSpeed;
			break;
		case SOUTHWEST:
			this.fruitXPos -= currentSpeed;
			this.fruitYPos -= currentSpeed;
			break;
		case NONE:
			break;
		default:
			break;		
		}
	}

	@Override
	public Direction getDirection() {
		return this.currentDirection;
	}
}
