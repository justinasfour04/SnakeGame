package controllers;

import snake.Snake;
import utility.Constants;
import fruit.Fruit;

public class GameController {

	private int score; // TODO: Move to controller
	private boolean isEaten;
	private Fruit fruit;
	private Snake snake;
	private static GameController gameController = null;
	
	protected GameController() {
		score = 0;
		isEaten = false;
	}
	
	public static GameController getInstance() {
		if (gameController == null)
			gameController = new GameController();
		return gameController;
	}

	// TODO: Move to controller
	public boolean checkCollision() {
		if (snake.intersects(fruit))
			return true;
		return false;
	}

	// TODO: Move to controller
	public void incrementScore() {
		if (isEaten)
			setScore(getScore() + 1);
	}

	// TODO: Move to controller
	public int getScore() {
		return score;
	}

	// TODO: Move to controller
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
}
