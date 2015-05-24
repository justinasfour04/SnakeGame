package snake;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.ListIterator;

import utility.Constants;
import utility.Constants.Direction;
import fruit.Fruit;

public class Snake {

	private int currentXPos;
	private int currentYPos;

	private int currentSpeed;

	private ArrayList<Rectangle> body;

	private Direction currentDirection;

	private static Snake snake = null;

	private Snake() {
		currentXPos = Constants.SNAKE_STARTING_POSX;
		currentYPos = Constants.SNAKE_STARTING_POSY;

		currentSpeed = Constants.START_SPEED;
		body = new ArrayList<Rectangle>();
		body.add(new Rectangle(currentXPos, currentYPos, Constants.SNAKE_SIZE, Constants.SNAKE_SIZE));
	}

	public static Snake getInstance() {
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
		if (currentDirection == Direction.UP)
			if (currentDirection == Direction.DOWN)
				move(Direction.UP);
		else if (currentDirection == Direction.DOWN)
			move(Direction.DOWN);
		else if (currentDirection == Direction.RIGHT)
			move(Direction.RIGHT);
		else
			move(Direction.LEFT);
		
//		ListIterator bodyIterator = (ListIterator) body.iterator();
//		while (bodyIterator.hasNext())
//			((Rectangle) bodyIterator.next()).setLocation(currentXPos, currentYPos);
	}

	public void move(Direction direction) {
		switch (direction) {
		case UP:
			currentYPos -= Constants.MOVE_SPEED;
			break;
		case DOWN:
			currentYPos += Constants.MOVE_SPEED;
			break;
		case RIGHT:
			currentXPos += Constants.MOVE_SPEED;
			break;
		case LEFT:
			currentXPos -= Constants.MOVE_SPEED;
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
}
