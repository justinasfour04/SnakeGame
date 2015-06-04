package window;

import java.awt.Graphics;
import java.awt.Rectangle;

import snake.Snake;
import utility.Constants;
/**
 * Display class for snake
 * @author Justin
 *
 */
public class SnakeView {

	private Snake snake;
	private Rectangle snakeView;
	
	/**
	 * Creates a new snake display
	 * @param snake
	 */
	public SnakeView(Snake snake){
		this.snake = snake;
		this.snakeView = new Rectangle(snake.getSnakeX(),
											snake.getSnakeY(),
											Constants.SNAKE_SIZE,
											Constants.SNAKE_SIZE);
		
	}
	
	/**
	 * Draws the snake
	 * @param g
	 */
	public void draw(Graphics g){
		
		g.setColor(Constants.SNAKE_COLOR);
		g.fillRect(snakeView.x,
				snakeView.y,
				Constants.SNAKE_SIZE,
				Constants.SNAKE_SIZE);
	
	}
	
	/**
	 * updates the snakeView position
	 */
	public void update(){
		this.snakeView = new Rectangle(snake.getSnakeX(),snake.getSnakeY(), 
				Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
	}
	/**
	 * Returns the snakeView Rectangle
	 * @return snakeView
	 */
	public Rectangle getSnakeView(){
		return this.snakeView;
	}
}
