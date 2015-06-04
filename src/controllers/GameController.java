package controllers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import snake.Snake;
import utility.Constants;
import utility.Constants.Direction;
import fruit.Fruit;
import fruit.FruitGenerator;

public class GameController{

	
	private static final long serialVersionUID = 7337231778649216423L;
	private int score; 
	private boolean isEaten;
	//private Fruit fruit;
	private FruitGenerator fruitGen;
	private Snake snake;
	private Image image;
	private Graphics second;
	private static GameController gameController = null;
	private boolean isPaused;
	private int gameTime;
	private Timer gameTimer;
	
//	protected GameController(Snake snake, Fruit fruit) {
//		score = 0;
//		isEaten = false;
//		this.isPaused = false;
//		this.snake = snake;
//		this.fruit = fruit;
//		this.gameTime = 0;
//		gameTimer = new Timer();
//		gameTimer.schedule(new TimerTask() { 
//		   @Override  
//		   public void run() {
//		       if(!isPaused){
//		    	   gameTime++;
//		       }
//		   }
//		},  1000);
//	}
	
	protected GameController(Snake snake, FruitGenerator fruitGen) {
		score = 0;
		isEaten = false;
		this.isPaused = false;
		this.snake = snake;
		this.fruitGen = fruitGen;
		this.gameTime = 0;
		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() { 
		   @Override  
		   public void run() {
		       if(!isPaused){
		    	   gameTime++;
		       }
		   }
		},  1000);
	}

	public static synchronized GameController getUniqueInstance() {
		return gameController;
	}

//	public static synchronized GameController getUniqueInstance(Snake snake, Fruit fruit) {
//		if (gameController == null)
//			gameController = new GameController(snake, fruit);
//		return gameController;
//	}
	
	public static synchronized GameController getUniqueInstance(Snake snake, FruitGenerator fruitGen) {
		if (gameController == null)
			gameController = new GameController(snake, fruitGen);
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

//	public void setGameBoundaries(Snake snake, Fruit fruit) {
//		
//		if (snake.getSnakeX() <= Constants.MIN_BOUNDARY_X) {
//			snake.setSnakeX(Constants.MIN_BOUNDARY_X + Constants.SNAKE_SIZE);
//		} else if (snake.getSnakeY() <= Constants.MIN_BOUNDARY_Y) {
//			snake.setSnakeY(Constants.MIN_BOUNDARY_Y + Constants.SNAKE_SIZE);
//		} else if (snake.getSnakeX() >= Constants.MAX_BOUNDARY_X) {
//			snake.setSnakeX(Constants.MAX_BOUNDARY_X - Constants.SNAKE_SIZE);
//		} else if (snake.getSnakeY() >= Constants.MAX_BOUNDARY_Y) {
//			snake.setSnakeY(Constants.MAX_BOUNDARY_Y - Constants.SNAKE_SIZE);
//		} else if (snake.getSnakeX() <= Constants.MIN_BOUNDARY_X && snake.getSnakeY() <= Constants.MIN_BOUNDARY_Y) {
//			snake.setSnakeX(Constants.MIN_BOUNDARY_X + 1);
//			snake.setSnakeY(Constants.MIN_BOUNDARY_Y + 1);
//		} else if (snake.getSnakeX() <= Constants.MIN_BOUNDARY_X && snake.getSnakeY() >= Constants.MAX_BOUNDARY_Y) {
//			snake.setSnakeX(Constants.MIN_BOUNDARY_X + 1);
//			snake.setSnakeY(Constants.MAX_BOUNDARY_Y - 1);
//		} else if (snake.getSnakeX() >= Constants.MAX_BOUNDARY_X && snake.getSnakeY() >= Constants.MAX_BOUNDARY_Y) {
//			snake.setSnakeX(Constants.MAX_BOUNDARY_X - 1);
//			snake.setSnakeY(Constants.MAX_BOUNDARY_Y - 1);
//		} else if (snake.getSnakeX() >= Constants.MAX_BOUNDARY_X && snake.getSnakeY() <= Constants.MIN_BOUNDARY_Y) {
//			snake.setSnakeX(Constants.MAX_BOUNDARY_X - 1);
//			snake.setSnakeY(Constants.MIN_BOUNDARY_Y + 1);
//		}
//		
//		if (fruit.getFruitX() <= Constants.MIN_BOUNDARY_X) {
//			fruit.setFruitX(Constants.MIN_BOUNDARY_X + Constants.FRUIT_SIZE);
//			switch(fruit.getDirection()){
//			case WEST: 
//				fruit.setDirection(Direction.EAST);
//				break;
//			case NORTHWEST:
//				fruit.setDirection(Direction.NORTHEAST);
//				break;
//			case SOUTHWEST:
//				fruit.setDirection(Direction.SOUTHEAST);
//				break;
//			}
//			
//		} else if (fruit.getFruitY() <= Constants.MIN_BOUNDARY_Y) {
//			fruit.setFruitY(Constants.MIN_BOUNDARY_Y + Constants.FRUIT_SIZE);
//			switch(fruit.getDirection()){
//			case SOUTH: 
//				fruit.setDirection(Direction.NORTH);
//				break;
//			case SOUTHWEST:
//				fruit.setDirection(Direction.NORTHWEST);
//				break;
//			case SOUTHEAST:
//				fruit.setDirection(Direction.NORTHEAST);
//				break;
//			}
//		} else if (fruit.getFruitX() >= Constants.MAX_BOUNDARY_X) {
//			fruit.setFruitX(Constants.MAX_BOUNDARY_X - Constants.FRUIT_SIZE);
//			switch(fruit.getDirection()){
//			case EAST: 
//				fruit.setDirection(Direction.WEST);
//				break;
//			case NORTHEAST:
//				fruit.setDirection(Direction.SOUTHEAST);
//				break;
//			case SOUTHEAST:
//				fruit.setDirection(Direction.SOUTHWEST);
//				break;
//			}
//		} else if (fruit.getFruitY() >= Constants.MAX_BOUNDARY_Y) {
//			fruit.setFruitY(Constants.MAX_BOUNDARY_Y - Constants.FRUIT_SIZE);
//			switch(fruit.getDirection()){
//			case NORTH: 
//				fruit.setDirection(Direction.SOUTH);
//				break;
//			case NORTHWEST:
//				fruit.setDirection(Direction.SOUTHWEST);
//				break;
//			case NORTHEAST:
//				fruit.setDirection(Direction.SOUTHEAST);
//				break;
//			}
//		} 
//			else if (fruit.getFruitX() <= Constants.MIN_BOUNDARY_X && fruit.getFruitY() <= Constants.MIN_BOUNDARY_Y) {
//			fruit.setFruitX(Constants.MIN_BOUNDARY_X + 1);
//			fruit.setFruitY(Constants.MIN_BOUNDARY_Y + 1);
//			fruit.setDirection(Direction.NORTHEAST);
//		} else if (fruit.getFruitX() <= Constants.MIN_BOUNDARY_X && fruit.getFruitY() >= Constants.MAX_BOUNDARY_Y) {
//			fruit.setFruitX(Constants.MIN_BOUNDARY_X + 1);
//			fruit.setFruitY(Constants.MAX_BOUNDARY_Y - 1);
//			fruit.setDirection(Direction.SOUTHEAST);
//		} else if (fruit.getFruitX() >= Constants.MAX_BOUNDARY_X && fruit.getFruitY() >= Constants.MAX_BOUNDARY_Y) {
//			fruit.setFruitX(Constants.MAX_BOUNDARY_X - 1);
//			fruit.setFruitY(Constants.MAX_BOUNDARY_Y - 1);
//			fruit.setDirection(Direction.SOUTHWEST);
//		} else if (fruit.getFruitX() >= Constants.MAX_BOUNDARY_X && fruit.getFruitY() <= Constants.MIN_BOUNDARY_Y) {
//			fruit.setFruitX(Constants.MAX_BOUNDARY_X - 1);
//			fruit.setFruitY(Constants.MIN_BOUNDARY_Y + 1);
//			fruit.setDirection(Direction.NORTHWEST);
//		}
//		
//	}
	
public void setGameBoundaries(Snake snake, FruitGenerator fruitGen) {
		
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
		for(Fruit f : fruitGen.getGroup()){
			if (f.getFruitX() <= Constants.MIN_BOUNDARY_X) {
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
				
			} else if (f.getFruitY() <= Constants.MIN_BOUNDARY_Y) {
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
			} else if (f.getFruitX() >= Constants.MAX_BOUNDARY_X) {
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
			} else if (f.getFruitY() >= Constants.MAX_BOUNDARY_Y) {
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
				else if (f.getFruitX() <= Constants.MIN_BOUNDARY_X && f.getFruitY() <= Constants.MIN_BOUNDARY_Y) {
				f.setFruitX(Constants.MIN_BOUNDARY_X + 1);
				f.setFruitY(Constants.MIN_BOUNDARY_Y + 1);
				f.setDirection(Direction.NORTHEAST);
			} else if (f.getFruitX() <= Constants.MIN_BOUNDARY_X && f.getFruitY() >= Constants.MAX_BOUNDARY_Y) {
				f.setFruitX(Constants.MIN_BOUNDARY_X + 1);
				f.setFruitY(Constants.MAX_BOUNDARY_Y - 1);
				f.setDirection(Direction.SOUTHEAST);
			} else if (f.getFruitX() >= Constants.MAX_BOUNDARY_X && f.getFruitY() >= Constants.MAX_BOUNDARY_Y) {
				f.setFruitX(Constants.MAX_BOUNDARY_X - 1);
				f.setFruitY(Constants.MAX_BOUNDARY_Y - 1);
				f.setDirection(Direction.SOUTHWEST);
			} else if (f.getFruitX() >= Constants.MAX_BOUNDARY_X && f.getFruitY() <= Constants.MIN_BOUNDARY_Y) {
				f.setFruitX(Constants.MAX_BOUNDARY_X - 1);
				f.setFruitY(Constants.MIN_BOUNDARY_Y + 1);
				f.setDirection(Direction.NORTHWEST);
			}
		}
	}
	
//	public void pause(){
//		this.snake.pause();
//		this.fruit.pause();
//	}

	public void pause(){
		this.snake.pause();
		this.fruitGen.pause();
	}

	
	public int getGameTime(){
		return this.gameTime;
	}

}
