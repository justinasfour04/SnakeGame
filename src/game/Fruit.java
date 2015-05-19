package game;

import java.awt.Rectangle;
import java.util.Random;

public class Fruit {

	private Random r1 = new Random();
	private Random r2 = new Random();

	private int fruitX = r1.nextInt(799), fruitY = r2.nextInt(479);

	private boolean eaten = false;

	private int size = 10;
	private static int score = 0;

	public static Rectangle fruit = new Rectangle(0, 0, 0, 0);

	public void update() {

		fruit.setRect(fruitX, fruitY, size, size);

		if (checkCollision(Snake.r)) {
			setEaten(true);
			incrementScore();
			fruitX = 12 + r1.nextInt(790-12);
			fruitY = 12 + r2.nextInt(470-12);
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
		return fruitX;
	}

	public int getFruitY() {
		return fruitY;
	}

	public void setFruitX(int fruitX) {
		this.fruitX = fruitX;
	}

	public void setFruitY(int fruitY) {
		this.fruitY = fruitY;
	}

	public boolean isEaten() {
		return eaten;
	}

	public void setEaten(boolean eaten) {
		this.eaten = eaten;
	}

	public static int getScore() {
		return score;
	}

	public void setScore(int score) {
		Fruit.score = score;
	}
}
