package game;

import java.awt.Rectangle;
import java.util.Random;
import constants.Constants;

public class Fruit {

	private Random r1;
	private Random r2;

	private int fruitX, fruitY;

	private boolean eaten = false;
	
	private static int score = 0; //TODO: Make Controller class to keep track of score and fruit generation

	public static Rectangle fruit;
	
	public Fruit() {
		r1 = new Random();
		r2 = new Random();
		
		score = INITIAL_SCORE;
		
		fruit = new Rectangle(0, 0, 0, 0);
		
		size = 10;
		
		fruitX = r1.nextInt(799); 
		fruitY = r2.nextInt(479);
	}

	public void update() {

		fruit.setRect(fruitXPos, fruitYPos, Constants.FRUIT_SIZE, Constants.FRUIT_SIZE);

		if (checkCollision(Snake.r)) {
			setEaten(true);
			incrementScore();
			fruitXPos = 12 + r1.nextInt(790-12);
			fruitYPos = 12 + r2.nextInt(470-12);
			setEaten(false);
		}

	}

	public boolean checkCollision(Rectangle r) {
		if (r.intersects(fruit))
			return true;
		return false;
	}
	
	private void incrementScore() {
		if (isEaten())
			setScore(getScore() + 1);
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
