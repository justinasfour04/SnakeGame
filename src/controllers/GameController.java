package controllers;

import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import snake.Body;
import snake.Snake;
import utility.Constants;
import utility.Constants.Direction;
import window.FruitGroupView;
import window.FruitView;
import window.SnakeView;
import fruit.Fruit;
import fruit.FruitGenerator;
/**
 * 	Controller for Snake game.
 *	Keeps track of important elements.
 *	Uses Singleton principle
 * @author Justin, Justin
 * 
 *	
 */
public class GameController{

	private FruitGenerator fruitGenerator;
	private Snake snake;
	private SnakeView snakeView;
	private static GameController gameController = null;	
	private boolean isStarted;
	private int score; 
	
	/**
	 * Constructor
	 * @param Snake snake
	 * @param FruitGenerator fruitGenerator
	 */
	private GameController(Snake snake, FruitGenerator fruitGenerator) {
		score = 0;
		this.snake = snake;
		this.fruitGenerator = fruitGenerator;
		this.isStarted = false;
	}
	
	/**
	 * Returns the GameController.
	 * Should only be used after the controller has been created
	 * @return GameController gameController
	 */
	public static synchronized GameController getUniqueInstance() {
		return gameController;
	}
	
	/**
	 * Returns the GameController or creates a new instance if need be
	 * @param Snake snake
	 * @param FruitGenerator fruitGenerator
	 * @return GameController gameController
	 */
	public static synchronized GameController getUniqueInstance(Snake snake, FruitGenerator fruitGenerator) {
		if (gameController == null)
			gameController = new GameController(snake, fruitGenerator);
		return gameController;
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
	
	/**
	 * Checks for collision between the snake,fruit, and walls
	 * @param snake
	 * @param fruitGen
	 * @param snakeView
	 * @param fruitGroupView
	 */
	public void applyRules(Snake snake, FruitGenerator fruitGen, SnakeView snakeView, FruitGroupView fruitGroupView){

		checkFruitCollision(snakeView, fruitGroupView);
		setGameBoundaries(snake, fruitGen);
		
	}
	
	/**
	 * Checks for collision between the snake and fruits
	 * @param snakeView
	 * @param fruitGroupView
	 */
	private void checkFruitCollision(SnakeView snakeView, FruitGroupView fruitGroupView) {
		for(int i = 0; i < fruitGroupView.getFruitViews().size(); i++){ 
			FruitView fruitView = fruitGroupView.getFruitViews().get(i); //get the fruit display rectangle of each existing fruit
			if (snakeView.getSnakeView().intersects(fruitView.getFruitDisplay())){ //check to see if the snake display rectangle intersects the fruits'
				if(!fruitView.getFruit().isEaten()){
					fruitView.getFruit().setEaten(true);
					this.score += fruitView.getFruit().getValue();
					for(int j=0; j<fruitView.getFruit().getValue()+3; j++){
						snake.getBody().add(new Body(snake.getSnakeX(), snake.getSnakeY(), snake.getBody().size()));
					}
					fruitGenerator.removeFruit(fruitView.getFruit());//remove the fruit from the list of fruits in game, as well as the display
					fruitGroupView.getFruitViews().remove(fruitView);
					
				}
			}
		}
	}
	
	/**
	 * Checks to make sure neither snake nor fruits go through walls.
	 * Bounces fruits if applicable
	 * @param snake
	 * @param fruitGen
	 */
	private void setGameBoundaries(Snake snake, FruitGenerator fruitGen) {
		
		//make sure snake doesn't go through the walls
		if (snake.getSnakeX() <= Constants.MIN_BOUNDARY_X) {
			snake.setSnakeX(Constants.MIN_BOUNDARY_X + Constants.SNAKE_SIZE);
		} else if (snake.getSnakeY() <= Constants.MIN_BOUNDARY_Y) {
			snake.setSnakeY(Constants.MIN_BOUNDARY_Y + Constants.SNAKE_SIZE);
		} else if (snake.getSnakeX() >= Constants.MAX_BOUNDARY_X) {
			snake.setSnakeX(Constants.MAX_BOUNDARY_X - Constants.SNAKE_SIZE);
		} else if (snake.getSnakeY() >= Constants.MAX_BOUNDARY_Y) {
			snake.setSnakeY(Constants.MAX_BOUNDARY_Y - Constants.SNAKE_SIZE);
		}
		//make sure fruit bounces off walls
		for(Fruit f : fruitGen.getFruitList()){
			if (f.getFruitX() <= Constants.MIN_BOUNDARY_X) { //fruit hitting left side of window
				f.setFruitX(Constants.MIN_BOUNDARY_X + Constants.FRUIT_SIZE);
				switch(f.getDirection()){
				case WEST: 
					f.setDirection(Direction.EAST);
					break;
				case NORTHWEST:
					f.setDirection(Direction.NORTHEAST);
					break;
				case SOUTHWEST:
					f.setDirection(Direction.SOUTHEAST);
					break;
				default:
					f.setDirection(Direction.EAST);
					break;
				}
			} else if (f.getFruitY() <= Constants.MIN_BOUNDARY_Y) {//fruit hitting bottom of window
				f.setFruitY(Constants.MIN_BOUNDARY_Y + Constants.FRUIT_SIZE);
				switch(f.getDirection()){
				case SOUTH: 
					f.setDirection(Direction.NORTH);
					break;
				case SOUTHWEST:
					f.setDirection(Direction.NORTHWEST);
					break;
				case SOUTHEAST:
					f.setDirection(Direction.NORTHEAST);
					break;
				default:
					f.setDirection(Direction.NORTH);
					break;
				} 
			} else if (f.getFruitX() >= Constants.MAX_BOUNDARY_X) { //fruit hitting right side of window
				f.setFruitX(Constants.MAX_BOUNDARY_X - Constants.FRUIT_SIZE);
				switch(f.getDirection()){
				case EAST: 
					f.setDirection(Direction.WEST);
					break;
				case NORTHEAST:
					f.setDirection(Direction.SOUTHEAST);
					break;
				case SOUTHEAST:
					f.setDirection(Direction.SOUTHWEST);
					break;
				default:
					f.setDirection(Direction.WEST);
					break;
				} 
			} else if (f.getFruitY() >= Constants.MAX_BOUNDARY_Y) { // fruit hitting top of window
				
				f.setFruitY(Constants.MAX_BOUNDARY_Y - Constants.FRUIT_SIZE);
				switch(f.getDirection()){
				case NORTH: 
					f.setDirection(Direction.SOUTH);
					break;
				case NORTHWEST:
					f.setDirection(Direction.SOUTHWEST);
					break;
				case NORTHEAST:
					f.setDirection(Direction.SOUTHEAST);
					break;
				default:
					f.setDirection(Direction.SOUTH);
					break;
				}
			} 	
			else if (f.getFruitX() <= Constants.MIN_BOUNDARY_X && f.getFruitY() <= Constants.MIN_BOUNDARY_Y) { //fruit hitting bottom left corner
				f.setFruitX(Constants.MIN_BOUNDARY_X + 1);
				f.setFruitY(Constants.MIN_BOUNDARY_Y + 1);
				f.setDirection(Direction.NORTHEAST);
			} else if (f.getFruitX() <= Constants.MIN_BOUNDARY_X && f.getFruitY() >= Constants.MAX_BOUNDARY_Y) {//fruit hitting top left corner
				f.setFruitX(Constants.MIN_BOUNDARY_X + 1);
				f.setFruitY(Constants.MAX_BOUNDARY_Y - 1);
				f.setDirection(Direction.SOUTHEAST);
			} else if (f.getFruitX() >= Constants.MAX_BOUNDARY_X && f.getFruitY() >= Constants.MAX_BOUNDARY_Y) { //fruit hitting top right corner
				f.setFruitX(Constants.MAX_BOUNDARY_X - 1);
				f.setFruitY(Constants.MAX_BOUNDARY_Y - 1);
				f.setDirection(Direction.SOUTHWEST);
			} else if (f.getFruitX() >= Constants.MAX_BOUNDARY_X && f.getFruitY() <= Constants.MIN_BOUNDARY_Y) { //fruit hitting bottom right corner
				f.setFruitX(Constants.MAX_BOUNDARY_X - 1);
				f.setFruitY(Constants.MIN_BOUNDARY_Y + 1);
				f.setDirection(Direction.NORTHWEST);
			}
		}
	}
	
	/**
	 * Pauses the game
	 */
	public void pause(){
		this.snake.pause();
		this.fruitGenerator.pause();
	}
}
