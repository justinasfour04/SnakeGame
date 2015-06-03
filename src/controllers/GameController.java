package controllers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import snake.Snake;
import utility.Constants;
import utility.Constants.Direction;
import fruit.Fruit;

public class GameController {

	
	private static final long serialVersionUID = 7337231778649216423L;
	private int score; 
	private boolean isEaten;
	private Fruit fruit;
	private Snake snake;
	private Image image;
	private Graphics second;
	private static GameController gameController = null;
	private boolean isPaused;
	
	protected GameController(Snake snake, Fruit fruit) {
		score = 0;
		isEaten = false;
		this.isPaused = false;
		this.snake = snake;
		this.fruit = fruit;
	}

	public static synchronized GameController getUniqueInstance() {
		return gameController;
	}

	public static synchronized GameController getUniqueInstance(Snake snake, Fruit fruit) {
		if (gameController == null)
			gameController = new GameController(snake, fruit);
		return gameController;
	}
	
	public boolean checkCollision(Fruit fruit) {
		if (snake.intersects(fruit))
			return true;
		return false;
	}

	
	public void incrementScore() {
		if (isEaten)
			setScore(getScore() + 1);
	}

	
	public int getScore() {
		return score;
	}

	
	public void setScore(int score) {
		this.score = score;
	}

	public void setGameBoundaries(Snake snake) {
		// need to fix boundary conditions for better collision detection later
		// the corners of the screen don't stop snake from going out of screen
		if (snake.getSnakeX() <= Constants.MIN_BOUNDARY_X) {
			snake.setSnakeX(Constants.MIN_BOUNDARY_X + Constants.SNAKE_SIZE);
		} else if (snake.getSnakeY() <= Constants.MIN_BOUNDARY_Y) {
			snake.setSnakeY(Constants.MIN_BOUNDARY_Y + Constants.SNAKE_SIZE);
		} else if (snake.getSnakeX() >= Constants.MAX_BOUNDARY_X) {
			snake.setSnakeX(Constants.MAX_BOUNDARY_X - Constants.SNAKE_SIZE);
		} else if (snake.getSnakeY() >= Constants.MAX_BOUNDARY_Y) {
			snake.setSnakeY(Constants.MAX_BOUNDARY_Y - Constants.SNAKE_SIZE);
		} else if (snake.getSnakeX() <= Constants.MIN_BOUNDARY_X && snake.getSnakeY() <= Constants.MIN_BOUNDARY_Y) {
			snake.setSnakeX(Constants.MIN_BOUNDARY_X + 1);
			snake.setSnakeY(Constants.MIN_BOUNDARY_Y + 1);
		} else if (snake.getSnakeX() <= Constants.MIN_BOUNDARY_X && snake.getSnakeY() >= Constants.MAX_BOUNDARY_Y) {
			snake.setSnakeX(Constants.MIN_BOUNDARY_X + 1);
			snake.setSnakeY(Constants.MAX_BOUNDARY_Y - 1);
		} else if (snake.getSnakeX() >= Constants.MAX_BOUNDARY_X && snake.getSnakeY() >= Constants.MAX_BOUNDARY_Y) {
			snake.setSnakeX(Constants.MAX_BOUNDARY_X - 1);
			snake.setSnakeY(Constants.MAX_BOUNDARY_Y - 1);
		} else if (snake.getSnakeX() >= Constants.MAX_BOUNDARY_X && snake.getSnakeY() <= Constants.MIN_BOUNDARY_Y) {
			snake.setSnakeX(Constants.MAX_BOUNDARY_X - 1);
			snake.setSnakeY(Constants.MIN_BOUNDARY_Y + 1);
		}
	}
	
	public void pause(){
		this.snake.pause();
		this.fruit.pause();
	}

}
