package model;

import java.awt.Point;
import java.util.Random;

import util.Constants;
import util.Constants.Direction;


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
		switch (currentDirection) {
			case NORTH:
				if (position.y < 0) {
					currentDirection = Direction.SOUTH;
				}
				break;
			case SOUTH:
				if (position.y + Constants.FRUIT_SIZE > Constants.GAME_SIZE.height) {
					currentDirection = Direction.NORTH;
				}
				break;
			case EAST:
				if (position.x + Constants.FRUIT_SIZE > Constants.GAME_SIZE.width) {
					currentDirection = Direction.WEST;
				}
				break;
			case WEST:
				if (position.x < 0) {
					currentDirection = Direction.EAST;
				}
				break;
			case NORTHEAST:
				if (position.y < 0) {
					currentDirection = Direction.SOUTHEAST;
				} else if (position.x + Constants.FRUIT_SIZE > Constants.GAME_SIZE.width) {
					currentDirection = Direction.NORTHWEST;
				}
				break;
			case NORTHWEST:
				if (position.y < 0) {
					currentDirection = Direction.SOUTHWEST;
				} else if (position.x < 0) {
					currentDirection = Direction.NORTHEAST;
				}	
				break;
			case SOUTHEAST:
				if (position.y + Constants.FRUIT_SIZE > Constants.GAME_SIZE.height) {
					currentDirection = Direction.NORTHEAST;
				} else if (position.x + Constants.FRUIT_SIZE > Constants.GAME_SIZE.width) {
					currentDirection = Direction.SOUTHWEST;
				}	
				break;
			case SOUTHWEST:
				if (position.y + Constants.FRUIT_SIZE > Constants.GAME_SIZE.height) {
					currentDirection = Direction.NORTHWEST;
				} else if (position.x < 0) {
					currentDirection = Direction.SOUTHEAST;
				}	
				break;
			default:
				break;
		}
		move(currentDirection);
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
		Point currentPosition = position;
		switch (direction) {
		case NORTH:
			position = new Point(currentPosition.x, currentPosition.y - currentSpeed);	
			break;
		case SOUTH:
			position = new Point(currentPosition.x, currentPosition.y + currentSpeed);	
			break;
		case EAST:
			position = new Point(currentPosition.x + currentSpeed, currentPosition.y);	
			break;
		case WEST:
			position = new Point(currentPosition.x - currentSpeed, currentPosition.y);	
			break;
		case NORTHEAST:
			position = new Point(currentPosition.x + currentSpeed, currentPosition.y - currentSpeed);	
			break;
		case NORTHWEST:
			position = new Point(currentPosition.x - currentSpeed, currentPosition.y - currentSpeed);	
			break;
		case SOUTHEAST:
			position = new Point(currentPosition.x + currentSpeed, currentPosition.y + currentSpeed);	
			break;
		case SOUTHWEST:
			position = new Point(currentPosition.x - currentSpeed, currentPosition.y + currentSpeed);	
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
