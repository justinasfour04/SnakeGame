package snake;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import utility.Constants;
import utility.Constants.Direction;
import fruit.Fruit;

public class Snake {

	private int currentXPos;
	private int currentYPos;

	private int currentSpeed;
	
	private boolean isPaused;
	
	private ArrayList<Rectangle> body;

	private Direction currentDirection;

	private static Snake snake = null;

	private Snake() {
		currentXPos = Constants.SNAKE_STARTING_POSX;
		currentYPos = Constants.SNAKE_STARTING_POSY;
		currentDirection = null;
		currentSpeed = Constants.MOVE_SPEED;
		body = new ArrayList<Rectangle>();
		body.add(new Rectangle(currentXPos, currentYPos, Constants.SNAKE_SIZE, Constants.SNAKE_SIZE));
		this.isPaused = false;
	}

	public static synchronized Snake getUniqueInstance() {
		if (snake == null)
			snake = new Snake();

		return snake;
	}

	// Need to figure out a way to get the update not to stop moving my snake
	// around
	// Right now what is happening is because of the keyReleased it stops all
	// movement because it can't enter if statement
	// Need to fix if statement
	public void update() {
		if (currentDirection == Direction.NORTH)
			move(Direction.NORTH);
		else if (currentDirection == Direction.SOUTH)
			move(Direction.SOUTH);
		else if (currentDirection == Direction.EAST)
			move(Direction.EAST);
		else if (currentDirection == Direction.WEST)
			move(Direction.WEST);
		
//		if(currentDirection != null){
//			System.out.println("current direction: " + currentDirection.toString());
//		}
//		System.out.println("current speeed: " + currentSpeed);
		Iterator<Rectangle> bodyIterator = body.iterator();
		while (bodyIterator.hasNext())
			bodyIterator.next().setLocation(currentXPos, currentYPos);
	}

	public void move(Direction direction) {
		switch (direction) {
		case NORTH:
			currentYPos -= currentSpeed;		
			break;
		case SOUTH:
			currentYPos += currentSpeed;
			break;
		case EAST:
			currentXPos += currentSpeed;
			break;
		case WEST:
			currentXPos -= currentSpeed;
			break;
		}
	}

	public boolean intersects(Fruit fruit) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getSnakeX() {
		return currentXPos;
	}

	public int getSnakeY() {
		return currentYPos;
	}

	public int getSpeed() {
		return currentSpeed;
	}

	public void setSnakeX(int snakeX) {
		this.currentXPos = snakeX;
	}

	public void setSnakeY(int snakeY) {
		this.currentYPos = snakeY;
	}

	public void setSpeed(int speed) {
		this.currentSpeed = speed;
	}

	public void setDirection(Direction d) {
		this.currentDirection = d;
	}

	public Direction getDirection() {
		return this.currentDirection;
	}
	
	public void pause(){
		if(!isPaused){
			this.currentSpeed = Constants.PAUSE;
		} else{
			this.currentSpeed = Constants.MOVE_SPEED;
		}
		this.isPaused = !this.isPaused;
	}
}
