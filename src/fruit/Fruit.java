package fruit;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

import snake.Snake;
import utility.Constants;

public abstract class Fruit {

	protected Random r1;
	protected Random r2;

	protected int fruitXPos, fruitYPos;

	protected boolean eaten;
	protected boolean isPaused;
	protected int value;
	protected int defaultSpeed;
	protected int currentSpeed;
	
	protected Color color;
	
//	protected static Rectangle fruit;//TODO: Move to FruitView
	
	public Fruit() {
		r1 = new Random();
		r2 = new Random();
		
		//scoreBoard = INITIAL_SCORE;
		//TODO: Move to FruitView
//		fruit = new Rectangle(0, 0, 0, 0);
				
		this.fruitXPos = r1.nextInt(799); 
		this.fruitYPos = r2.nextInt(479);
		this.eaten = false;
	}
	
	public int getFruitX() {
		return fruitXPos;
	}

	public int getFruitY() {
		return fruitYPos;
	}

	public void setFruitX(int fruitX) {
		this.fruitXPos = fruitX;
	}

	public void setFruitY(int fruitY) {
		this.fruitYPos = fruitY;
	}

	public boolean isEaten() {
		return eaten;
	}

	public void setEaten(boolean eaten) {
		this.eaten = eaten;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void pause(){
		if(!isPaused){
			this.currentSpeed = Constants.PAUSE;
		} else{
			this.currentSpeed = this.defaultSpeed;
		}
		this.isPaused = !this.isPaused;
	}
	
	
}
