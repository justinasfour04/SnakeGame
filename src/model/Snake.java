package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayDeque;

import javax.swing.JComponent;

import util.Constants;
import util.Constants.Direction;

public class Snake {
	
	private static final long serialVersionUID = 1L;
	private ArrayDeque<Point> body;
	private Direction direction;
	private boolean isPaused;
	private int speed;

	private static volatile Snake snake = null;
	

	/**
	 * Contructs a new Snake
	 */
	private Snake() {
		body = new ArrayDeque<Point>();
		for (int i = 0; i < 4; i++) {
			body.push(new Point(Constants.SNAKE_STARTING_POSX + i * Constants.BODY_SIZE, Constants.SNAKE_STARTING_POSY));			
		}
		direction = Direction.NONE;
		speed = Constants.MOVE_SPEED;
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
		if (snake.direction != Direction.NONE) {
			move();
		}
	}
	
	/**
	 * Function to move the snake
	 */
	public void move() {
		Point head = snake.body.peek();
		Point newBodyPart = null;
		switch (snake.direction) {
		case NORTH:
			newBodyPart = new Point(head.x, head.y - snake.speed);
			break;
		case SOUTH:
			newBodyPart = new Point(head.x, head.y + snake.speed);
			break;
		case EAST:
			newBodyPart = new Point(head.x + snake.speed, head.y);
			break;
		case WEST:
			newBodyPart = new Point(head.x - snake.speed, head.y);
			break;
		default:
			break;
		}
		snake.body.push(newBodyPart);
		snake.body.removeLast();
	}
	
	/**
	 * Pauses/Unpauses the snake
	 */
	public void pause(){
		if(!snake.isPaused){
			snake.speed = Constants.PAUSE;
		} else{
			snake.speed = Constants.MOVE_SPEED;
		}
		snake.isPaused = !snake.isPaused;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN);
		for (Point b : snake.body)
		{
			g.fillRect(b.x, b.y, Constants.BODY_SIZE, Constants.BODY_SIZE);
		}
		g.setColor(Color.BLACK);
	}
	
	public static void reset() {
		snake = new Snake();
	}

	public ArrayDeque<Point> getBody() {
		return body;
	}

	public void setBody(ArrayDeque<Point> body) {
		this.body = body;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
