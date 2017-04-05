package model;

import java.awt.Point;
import java.util.Random;

import util.Constants;
import util.Constants.Direction;

/**
 * A kind of fruit that only moves in one dimension
 * 
 * @author Justin
 *
 */
public class LinearFruit extends Fruit {

	private int directionID;
	private Direction currentDirection;

	/**
	 * Constructs a new LinearFruit, randomly choosing which direction it moves
	 * in
	 */
	public LinearFruit() {
		super();

		this.value = Constants.LINEAR_FRUIT_VALUE;
		this.currentSpeed = Constants.LINEAR_FRUIT_SPEED;
		this.defaultSpeed = Constants.LINEAR_FRUIT_SPEED;
		this.color = Constants.LINEAR_FRUIT_COLOR;
		this.isPaused = false;
		this.fruitImage = Constants.LINEAR_FRUIT_IMAGE;

		Random r = new Random();
		this.directionID = r.nextInt(4); // randomly choose a starting direction
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
		}
	}

	@Override
	public int getSpeed() {
		return this.currentSpeed;
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
			default:
				break;
		}
		
		move(currentDirection);
	}

	/**
	 * Moves the fruit depending on its direction
	 * 
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
		default:
			break;
		}
	}

	@Override
	public void setDirection(Direction d) {
		this.currentDirection = d;
	}

	@Override
	public Direction getDirection() {
		return this.currentDirection;
	}

}
