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
	private BufferedImage fruitImage;
	/**
	 * Constructs a new fruitView
	 * @param fruit
	 */
	public FruitView(Fruit fruit) {
		this.fruit = fruit;
		this.fruitDisplay = new Rectangle(fruit.getFruitX(),fruit.getFruitY(), 
											23, 40); //TODO: make fruitXsize and ysize constants
	}

	/**
	 * draws the fruit
	 * @param g
	 */
	public void draw(Graphics g){
		try {
			fruitImage = ImageIO.read(new File(fruit.getImage()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(!fruit.isEaten()){
			g.drawImage(fruitImage, fruit.getFruitX(), fruit.getFruitY(), 23, 40, null);
		}

	}

	public void update(){
		this.fruitDisplay = new Rectangle(fruit.getFruitX(),fruit.getFruitY(), 
				23, 40);
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
