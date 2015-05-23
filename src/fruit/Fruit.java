package fruit;

import java.awt.Rectangle;
import java.util.Random;

import snake.Snake;
import utility.Constants;

public abstract class Fruit {

	protected Random r1;
	protected Random r2;

	protected int fruitXPos, fruitYPos;

	protected boolean eaten;
	protected int value;
	
	
//	protected static Rectangle fruit;//TODO: Move to FruitView
	
	public Fruit() {
		r1 = new Random();
		r2 = new Random();
		
		//score = INITIAL_SCORE;
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
	
	//TODO: Move to FruitView
//	public void update() {
//
//		fruit.setRect(fruitXPos, fruitYPos, Constants.FRUIT_SIZE, Constants.FRUIT_SIZE);
//
//		if (checkCollision(Snake.r)) {
//			setEaten(true);
//			incrementScore();
//			fruitXPos = 12 + r1.nextInt(790-12);
//			fruitYPos = 12 + r2.nextInt(470-12);
//			setEaten(false);
//		}
//
//	}
	
}
