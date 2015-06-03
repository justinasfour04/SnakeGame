package fruit;

import java.awt.Color;

import utility.Constants;

public class RandomFruit extends Fruit{
	
	private int speed;
	private boolean isPaused;
	
	public RandomFruit(){
		super();
		this.value = Constants.RANDOM_FRUIT_VALUE;
		this.currentSpeed = Constants.RANDOM_FRUIT_SPEED;
		this.defaultSpeed = Constants.RANDOM_FRUIT_SPEED;
		this.color = Constants.RANDOM_FRUIT_COLOR;
		this.isPaused = false;
	}

	public int getSpeed() {
		return speed;
	}
	
	public void pause(){
		if(!isPaused){
			this.speed = Constants.PAUSE;
		} else{
			this.speed = Constants.RANDOM_FRUIT_SPEED;
		}
		this.isPaused = !this.isPaused;
	}
	
}
