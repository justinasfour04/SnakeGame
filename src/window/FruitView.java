package window;

import java.awt.Graphics;
import java.awt.Rectangle;

import utility.Constants;
import fruit.Fruit;

/**
 * Display class for fruits
 * @author Justin
 *
 */
public class FruitView {

	private Rectangle fruitDisplay;
	private Fruit fruit;
	
	/**
	 * Constructs a new fruitView
	 * @param fruit
	 */
	public FruitView(Fruit fruit) {
		this.fruit = fruit;
		this.fruitDisplay = new Rectangle(fruit.getFruitX(),fruit.getFruitY(), 
											Constants.FRUIT_SIZE, Constants.FRUIT_SIZE);
	}
	
	/**
	 * draws the fruit
	 * @param g
	 */
	public void draw(Graphics g){
		if(!fruit.isEaten()){
			g.setColor(fruit.getColor());
			g.fillRect(fruit.getFruitX(), fruit.getFruitY(), fruitDisplay.width, fruitDisplay.height);
		}
		
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
