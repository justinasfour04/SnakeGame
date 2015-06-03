package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import controllers.GameController;
import fruit.Fruit;
import snake.Snake;
import utility.Constants;

public class FruitView {

	private Rectangle fruitDisplay;
	private Fruit fruit;
	private GameController controller;
	
	public FruitView(Fruit fruit) {
		this.fruit = fruit;
		this.fruitDisplay = new Rectangle(fruit.getFruitX(),fruit.getFruitY(), 
											Constants.FRUIT_SIZE, Constants.FRUIT_SIZE);
		this.controller = GameController.getUniqueInstance();
	}
	
	public void draw(Graphics g){
		
		if(!fruit.isEaten()){
			g.setColor(fruit.getColor());
			g.fillRect(fruit.getFruitX(), fruit.getFruitY(), fruitDisplay.width, fruitDisplay.height);
		}
		
	}
	
	public void update(){
			
		this.fruitDisplay = new Rectangle(fruit.getFruitX(),fruit.getFruitY(), 
											Constants.FRUIT_SIZE, Constants.FRUIT_SIZE);

//		if (controller.checkCollision(this.fruit)) {
//			this.fruit.setEaten(true);
//			controller.incrementScore();
//		}
	}
}
