package window;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import snake.Snake;
import utility.Constants;

/**
 * Display class for snake
 * 
 * @author Justin
 *
 */
public class SnakeView {

	private Snake snake;
	private Rectangle snakeView;
	private ArrayList<Rectangle> snakeBody;

	/**
	 * Creates a new snake display
	 * 
	 * @param snake
	 */
	public SnakeView(Snake snake) {
		this.snake = snake;
		this.snakeView = new Rectangle(snake.getSnakeX(), snake.getSnakeY(),
				Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
		this.snakeBody = snake.getBody();
	}

	/**
	 * Draws the snake
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		for (int i = 0; i < snakeBody.size(); i++) {
			g.setColor(Constants.SNAKE_COLOR);
			g.fillRect(snakeView.x + Constants.SNAKE_SIZE * i, snakeView.y,
					Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
		}
	}

	/**
	 * updates the snakeView position
	 */
	public void update() {
		this.snakeView = new Rectangle(snake.getSnakeX(), snake.getSnakeY(),
				Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
	}

	/**
	 * Returns the snakeView Rectangle
	 * 
	 * @return snakeView
	 */
	public Rectangle getSnakeView() {
		return this.snakeView;
	}
}
