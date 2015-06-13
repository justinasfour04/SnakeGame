package window;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import snake.Body;
import snake.Snake;
import utility.Constants;
import utility.Constants.Direction;

/**
 * Display class for snake
 * 
 * @author Justin
 *
 */
public class SnakeView {

	private Snake snake;
	private Rectangle snakeView;
	private BufferedImage snakeHead_up, snakeHead_down, snakeHead_right, snakeHead_left;

	/**
	 * Creates a new snake display
	 * 
	 * @param snake
	 */
	public SnakeView(Snake snake) {
		this.snake = snake;
		try {
			snakeHead_up = ImageIO.read(new File("C:/Users/Justin/Documents/GitHub/SnakeGame/src/window/head_up.png"));
			snakeHead_down = ImageIO.read(new File("C:/Users/Justin/Documents/GitHub/SnakeGame/src/window/head_down.png"));
			snakeHead_left = ImageIO.read(new File("C:/Users/Justin/Documents/GitHub/SnakeGame/src/window/head_left.png"));
			snakeHead_right = ImageIO.read(new File("C:/Users/Justin/Documents/GitHub/SnakeGame/src/window/head_right.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		this.snakeView = new Rectangle(snake.getSnakeX(), snake.getSnakeY(),
				Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
	}

	/**
	 * Draws the snake
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		//		g.setColor(Constants.SNAKE_COLOR);
		//		g.drawRect(snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
		//		g.fillRect(snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
		for (int i = 0; i < snake.getBody().size(); i++) {
			g.setColor(Constants.SNAKE_COLOR);
			g.drawRect(snake.getBody().get(i).getSnakeBodyPosX(), snake.getBody().get(i).getSnakeBodyPosY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
			g.fillRect(snake.getBody().get(i).getSnakeBodyPosX(), snake.getBody().get(i).getSnakeBodyPosY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
		}
		if (snake.getDirection() == Direction.NORTH)
			g.drawImage(snakeHead_up, snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE, null);
		else if (snake.getDirection() == Direction.SOUTH)
			g.drawImage(snakeHead_down, snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE, null);
		else if (snake.getDirection() == Direction.EAST)
			g.drawImage(snakeHead_right, snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE, null);
		else if (snake.getDirection() == Direction.WEST)
			g.drawImage(snakeHead_left, snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE, null);

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
