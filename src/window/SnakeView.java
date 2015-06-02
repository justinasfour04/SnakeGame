package window;

import java.awt.Graphics;
import java.awt.Rectangle;

import snake.Snake;
import utility.Constants;

public class SnakeView {

	private Snake snake;
	private Rectangle snakeDisplay;
	
	public SnakeView(Snake snake){
		this.snake = snake;
		this.snakeDisplay = new Rectangle(snake.getSnakeX(),
											snake.getSnakeY(),
											Constants.SNAKE_SIZE,
											Constants.SNAKE_SIZE);
		
	}
	
	public void draw(Graphics g){
		
		g.setColor(Constants.SNAKE_COLOR);
		g.fillRect(snakeDisplay.x,
				snakeDisplay.y,
				Constants.SNAKE_SIZE,
				Constants.SNAKE_SIZE);
	
	}
	
	public void update(){
		this.snakeDisplay = new Rectangle(snake.getSnakeX(),snake.getSnakeY(), 
				Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
	}
}
