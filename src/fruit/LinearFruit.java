package fruit;

import java.awt.Color;
import java.util.Random;

import utility.Constants;
import utility.Constants.Direction;

public class LinearFruit extends Fruit{
	
	private int directionID; //True = up and down, False = left and right
	private boolean isPaused;
	private Direction currentDirection;
	
	public LinearFruit(){
		super();
		this.value = Constants.LINEAR_FRUIT_VALUE;
		this.currentSpeed = Constants.LINEAR_FRUIT_SPEED;
		this.defaultSpeed = Constants.LINEAR_FRUIT_SPEED;
		this.color = Constants.LINEAR_FRUIT_COLOR;
		Random r = new Random();
		this.directionID = r.nextInt(4); //randomly choose horizontal or vertical type
		this.isPaused = false;
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
	public void update(){
		move(this.currentDirection);
	}
	
	private void move(Direction direction) {
		switch (direction) {
		case NORTH:
			this.fruitYPos -= currentSpeed;		
			break;
		case SOUTH:
			this.fruitYPos += currentSpeed;
			break;
		case EAST:
			this.fruitXPos += currentSpeed;
			break;
		case WEST:
			this.fruitXPos -= currentSpeed;
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
