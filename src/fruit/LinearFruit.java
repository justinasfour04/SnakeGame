package fruit;

import java.awt.Color;
import java.util.Random;

import utility.Constants;

public class LinearFruit extends Fruit{
	
	boolean linearType; //True = up and down, False = left and right
	boolean isPaused;
	
	public LinearFruit(){
		super();
		this.value = Constants.LINEAR_FRUIT_VALUE;
		this.currentSpeed = Constants.LINEAR_FRUIT_SPEED;
		this.defaultSpeed = Constants.LINEAR_FRUIT_SPEED;
		this.color = Constants.LINEAR_FRUIT_COLOR;
		Random r = new Random();
		this.linearType = r.nextBoolean();
		this.isPaused = false;
	}
	
	
	public int getSpeed() {
		return this.currentSpeed;
	}
	
	
}
