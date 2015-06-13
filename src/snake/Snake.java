package snake;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

import utility.Constants;
import utility.Constants.Direction;
/**
 * The snake. 
 * Uses singleton principle
 * @author Justin,Justin
 *
 */
public class Snake {

	private int snakeXPos;
	private int snakeYPos;
	private int snakeSpeed;
	private int bodyCount;
	private boolean isPaused, bigger;
	private ArrayList<Body> body;
	private Queue<Point> bodyPosition;
	private Direction snakeDirection;
	private static Snake snake = null;

	/**
	 * Contructs a new Snake
	 */
	private Snake() {
		snakeXPos = Constants.SNAKE_STARTING_POSX;
		snakeYPos = Constants.SNAKE_STARTING_POSY;
		snakeDirection = null;
		snakeSpeed = Constants.MOVE_SPEED;
		body = new ArrayList<Body>();
		body.add(new Body(snakeXPos, snakeYPos, 1));
		bodyPosition = new LinkedList<Point>();
		bodyCount = body.size();
		this.isPaused = false;
		this.bigger = false;
	}

	/**
	 * Returns the snake
	 * @return snake
	 */
	public static synchronized Snake getUniqueInstance() {
		if (snake == null)
			snake = new Snake();

		return snake;
	}

	/**
	 * Updates the snake's position
	 */
	public void update() {
		if (snakeDirection == Direction.NORTH)
			move(Direction.NORTH);
		else if (snakeDirection == Direction.SOUTH)
			move(Direction.SOUTH);
		else if (snakeDirection == Direction.EAST)
			move(Direction.EAST);
		else if (snakeDirection == Direction.WEST)
			move(Direction.WEST);

		//TODO: Refine the counter 
		for (Body i : body) {
			int bodyNumber = i.getBodyPartNumber();
			bodyNumber--;
			i.setBodyPartNumber(bodyNumber);
			if (i.getBodyPartNumber() == 0)
				i.setBodyPosition(snakeXPos, snakeYPos, body.size());
		}
		
	}

	/**
	 * moves the snake
	 * @param direction
	 */
	public void move(Direction direction) {
		switch (direction) {
		case NORTH:
			snakeYPos -= snakeSpeed;
			break;
		case SOUTH:
			snakeYPos += snakeSpeed;
			break;
		case EAST:
			snakeXPos += snakeSpeed;
			break;
		case WEST:
			snakeXPos -= snakeSpeed;
			break;
		default:
			break;
		}
	}

	/**
	 * Returns the snake's x-coordinate
	 * @return snakeXpos
	 */
	public int getSnakeX() {
		return snakeXPos;
	}

	/**
	 * Returns the snake's y-coordinate
	 * @return snakeYPos
	 */
	public int getSnakeY() {
		return snakeYPos;
	}

	/**
	 * Returns the snake's speed
	 * @return snakeSpeed
	 */
	public int getSpeed() {
		return snakeSpeed;
	}

	/**
	 * Sets the snake's x-coordinate
	 * @param snakeX
	 */
	public void setSnakeX(int snakeX) {
		this.snakeXPos = snakeX;
	}

	/**
	 * Sets the snake's y-coordinate
	 * @param snakeY
	 */
	public void setSnakeY(int snakeY) {
		this.snakeYPos = snakeY;
	}

	/**
	 * Sets the snake's speed
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.snakeSpeed = speed;
	}

	/**
	 * Sets the snake's direction
	 * @param d
	 */
	public void setDirection(Direction d) {
		this.snakeDirection = d;
	}

	/**
	 * Returns the snake's direction
	 * @return snakeDirection
	 */
	public Direction getDirection() {
		return this.snakeDirection;
	}

	/**
	 * Pauses/Unpauses the snake
	 */
	public void pause(){
		if(!isPaused){
			this.snakeSpeed = Constants.PAUSE;
		} else{
			this.snakeSpeed = Constants.MOVE_SPEED;
		}
		this.isPaused = !this.isPaused;
	}

	public ArrayList<Body> getBody() {
		return body;
	}

	public void setBody(ArrayList<Body> body) {
		this.body = body;
	}

	public Queue<Point> getBodyPosition() {
		return bodyPosition;
	}

	public void setBodyPosition(Queue<Point> bodyPosition) {
		this.bodyPosition = bodyPosition;
	}

	public boolean isBigger() {
		return bigger;
	}

	public void setBigger(boolean bigger) {
		this.bigger = bigger;
	}
}
