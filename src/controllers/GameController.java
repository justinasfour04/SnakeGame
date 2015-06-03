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

public class GameController  implements KeyListener, ActionListener{

	
	private static final long serialVersionUID = 7337231778649216423L;
	private int score; 
	private boolean isEaten;
	private Fruit fruit;
	private Snake snake;
	private Image image;
	private Graphics second;
	private static GameController gameController = null;
	private boolean isPaused;
	
	protected GameController() {
		score = 0;
		isEaten = false;
		this.isPaused = false;
	}

	public static synchronized GameController getUniqueInstance() {
		if (gameController == null)
			gameController = new GameController();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP && snake.getDirection() != Direction.DOWN) {
			snake.setDirection(Direction.UP);
		} else if (key == KeyEvent.VK_DOWN && snake.getDirection() != Direction.UP) {
			snake.setDirection(Direction.DOWN);
		} else if (key == KeyEvent.VK_RIGHT && snake.getDirection() != Direction.LEFT) {
			snake.setDirection(Direction.RIGHT);
		} else if (key == KeyEvent.VK_LEFT && snake.getDirection() != Direction.RIGHT) {
			snake.setDirection(Direction.LEFT);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
