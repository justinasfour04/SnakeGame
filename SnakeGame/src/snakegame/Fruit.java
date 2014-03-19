package snakegame;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Fruit {
	
	private Random r1 = new Random();
	private Random r2 = new Random();
	
	private int fruitX = r1.nextInt(799), fruitY = r2.nextInt(479);
	private boolean eaten = false;
	
	private int size = 10;
	
	public static Rectangle circle = new Rectangle(0, 0, 0, 0);
	
	public void update() {
		
		circle.setRect(fruitX, fruitY, size, size);
		
		if (isEaten()) {
			fruitX = r1.nextInt(799);
			fruitY = r2.nextInt(479);
		}
		
		
	}

	public int getFruitX() {
		return fruitX;
	}

	public int getFruitY() {
		return fruitY;
	}

	public boolean isEaten() {
		return eaten;
	}

	public void setFruitX(int fruitX) {
		this.fruitX = fruitX;
	}

	public void setFruitY(int fruitY) {
		this.fruitY = fruitY;
	}

	public void setEaten(boolean eaten) {
		this.eaten = eaten;
	}
}
