package window;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

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
public class SnakeView extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704202002187224342L;
	private Snake snake;
	private Rectangle snakeView;
	private BufferedImage snakeHeadSheet;
	private BufferedImage snakeHeadImg;
	private BufferedImage snakeBodySheet;
	private BufferedImage snakeBodyImg;
	/**
	 * Creates a new snake display
	 * 
	 * @param snake
	 */
	public SnakeView(Snake snake) {
		this.snake = snake;
		this.snakeHeadSheet = null;
		this.snakeView = new Rectangle(snake.getSnakeX(), snake.getSnakeY(),
				Constants.SNAKE_SIZE, Constants.SNAKE_SIZE);
	}

	/**
	 * Draws the snake
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		try {
			snakeHeadSheet = ImageIO.read(new File(Constants.SNAKE_HEAD_SHEET));
			snakeBodySheet = ImageIO.read(new File(Constants.SNAKE_BODY_SHEET));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (snake.getDirection() == Direction.NORTH){
			snakeHeadImg = snakeHeadSheet.getSubimage(150,0,150,150);
			g.drawImage(snakeHeadImg, snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE, null);
			for (int i = 1; i < snake.getBody().size(); i++) {
				snakeBodyImg = snakeBodySheet.getSubimage(79,0,129,79);
				g.drawImage(snakeBodyImg, snake.getBody().get(i).getSnakeBodyPosX(), snake.getBody().get(i).getSnakeBodyPosY(), Constants.SNAKE_SIZE, 25, null);
			}
		} else if (snake.getDirection() == Direction.SOUTH){
			snakeHeadImg = snakeHeadSheet.getSubimage(150,150,150,150);
			g.drawImage(snakeHeadImg, snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE, null);
			for (int i = 1; i < snake.getBody().size(); i++) {
				snakeBodyImg = snakeBodySheet.getSubimage(79,179,129,79);
				g.drawImage(snakeBodyImg, snake.getBody().get(i).getSnakeBodyPosX(), snake.getBody().get(i).getSnakeBodyPosY(), Constants.SNAKE_SIZE, 25, null);
			}
		} else if (snake.getDirection() == Direction.EAST){
			snakeHeadImg = snakeHeadSheet.getSubimage(0,150,150,150);
			g.drawImage(snakeHeadImg, snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE, null);
			for (int i = 1; i < snake.getBody().size(); i++) {
				snakeBodyImg = snakeBodySheet.getSubimage(0,129,79,129);
				g.drawImage(snakeBodyImg, snake.getBody().get(i).getSnakeBodyPosX(), snake.getBody().get(i).getSnakeBodyPosY(), 25, Constants.SNAKE_SIZE, null);
			}
		} else if (snake.getDirection() == Direction.WEST){
			snakeHeadImg = snakeHeadSheet.getSubimage(0,0,150,150);
			g.drawImage(snakeHeadImg, snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE, null);
			for (int i = 1; i < snake.getBody().size(); i++) {
				snakeBodyImg = snakeBodySheet.getSubimage(0,0,79,129);
				g.drawImage(snakeBodyImg, snake.getBody().get(i).getSnakeBodyPosX(), snake.getBody().get(i).getSnakeBodyPosY(), 25, Constants.SNAKE_SIZE, null);
			}
		} else {
			snakeHeadImg = snakeHeadSheet.getSubimage(0,150,150,150);
			g.drawImage(snakeHeadImg, snake.getSnakeX(), snake.getSnakeY(), Constants.SNAKE_SIZE, Constants.SNAKE_SIZE, null);
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
