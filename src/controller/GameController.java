package controller;

import java.awt.Point;

import model.Fruit;
import model.FruitFactory;
import model.Snake;
import util.Constants;
import util.Constants.Direction;
/**
 * 	Controller for Snake game.
 *	Keeps track of important elements.
 *	Uses Singleton principle
 * @author Justin, Justin
 * 
 *	
 */
public class GameController{

	private Snake snake;
	private FruitFactory fruit;
	private static GameController gameController = null;	
	private boolean isStarted, gameOver;
	private int score;
	
	/**
	 * Constructor
	 * @param Snake snake
	 * @param FruitFactory fruitGenerator
	 */
	private GameController() {
		score = 0;
		this.snake = Snake.getUniqueInstance();
		this.fruit = FruitFactory.getUniqueInstance();
		this.isStarted = false;
		this.gameOver = false;
	}
	
	/**
	 * Returns the GameController or creates a new instance if need be
	 * @return GameController gameController
	 */
	public static synchronized GameController getUniqueInstance() {
		if (gameController == null)
			gameController = new GameController();
		return gameController;
	}
	
	/**
	 * Pauses the game
	 */
	public void pause() {
		this.snake.pause();
		this.fruit.pause();
	}
	
	/**
	 * Returns current score
	 * @return int score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Returns true if game has been started
	 * @return boolean isStarted
	 */
	public boolean isStarted(){
		return this.isStarted;
	}
	
	/**
	 * Sets isStarted to true
	 */
	public void setIsStarted(){
		this.isStarted = true;
	}
	
	public void fruitEaten() {
		Point head = snake.getBody().peek();
		Point growth = null;
		Fruit toRemove = null;
		boolean fruitEaten = false;
		for (Fruit f : fruit.getFruitList()) {
			// Check rectangle intersections
			if ((f.getPosition().x <= (head.x + Constants.BODY_SIZE) && f.getPosition().x + Constants.FRUIT_SIZE >= head.x) 
					&& (f.getPosition().y <= (head.y + + Constants.BODY_SIZE) && f.getPosition().y + Constants.FRUIT_SIZE >= head.y)) {
				score++;
				switch (snake.getDirection()) {
				case NORTH:
					growth = new Point(head.x, head.y - snake.getSpeed());
					break;
				case SOUTH:
					growth = new Point(head.x, head.y + snake.getSpeed());
					break;
				case EAST:
					growth = new Point(head.x + snake.getSpeed(), head.y);
					break;
				case WEST:
					growth = new Point(head.x - snake.getSpeed(), head.y);
					break;
				default:
					break;
				}
				toRemove = f;
				fruitEaten = true;
			}
		}
		
		if (fruitEaten) {
			snake.getBody().push(growth);
			fruit.removeFruit(toRemove);
		}
	}
	
	public void isWallHit() {
		Point head = snake.getBody().peek();
		int gameWidth = Constants.GAME_SIZE.width;
		int gameHeight = Constants.GAME_SIZE.height;
		if (head.x < 0 || head.x + Constants.BODY_SIZE > gameWidth || head.y < 0 || head.y + Constants.BODY_SIZE > gameHeight) {
			gameOver = true;
			Snake.reset();
			FruitFactory.reset();
			gameController = new GameController();
		}
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}
