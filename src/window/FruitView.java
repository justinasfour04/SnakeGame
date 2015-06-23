package window;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import utility.Constants;
import fruit.Fruit;
import fruit.LinearFruit;
import fruit.RegularFruit;

/**
 * Display class for fruits
 * @author Justin
 *
 */
public class FruitView {

	private Rectangle fruitDisplay;
	private Fruit fruit;
	private BufferedImage grape, radish;

	/**
	 * Constructs a new fruitView
	 * @param fruit
	 */
	public FruitView(Fruit fruit) {
		this.fruit = fruit;
		this.fruitDisplay = new Rectangle(fruit.getFruitX(),fruit.getFruitY(), 
				Constants.FRUIT_SIZE, Constants.FRUIT_SIZE);
		try {
			grape = ImageIO.read(new File("src/window/Grape.png"));
			radish = ImageIO.read(new File("src/window/Radish.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * draws the fruit
	 * @param g
	 */
	public void draw(Graphics g){
		if(!fruit.isEaten()){
			if (fruit instanceof LinearFruit)
				g.drawImage(radish, fruitDisplay.x, fruitDisplay.y, fruitDisplay.width, fruitDisplay.height, null);
			else if (fruit instanceof RegularFruit)
				g.drawImage(grape, fruitDisplay.x, fruitDisplay.y, fruitDisplay.width, fruitDisplay.height, null);
			else {
				g.setColor(fruit.getColor());
				//g.fillRect(fruit.getFruitX(), fruit.getFruitY(), fruitDisplay.width, fruitDisplay.height);
				g.fillRect(fruitDisplay.x, fruitDisplay.y, fruitDisplay.width, fruitDisplay.height);
			}
		}

	}

	public void update(){
		this.fruitDisplay = new Rectangle(fruit.getFruitX(),fruit.getFruitY(), 
				Constants.FRUIT_SIZE, Constants.FRUIT_SIZE);
	}

	/**
	 * Returns the display rectangle
	 * @return fruitDisplay
	 */
	public Rectangle getFruitDisplay(){
		return this.fruitDisplay;
	}

	/**
	 * Returns the fruit being displayed
	 * @return fruit
	 */
	public Fruit getFruit(){
		return this.fruit;
	}
}
