package fruit;

import utility.Constants;

public class RandomFruit extends Fruit{
	
	private int speed;
	
	public RandomFruit(){
		super();
		this.value = Constants.RANDOM_FRUIT_VALUE;
		this.speed = Constants.RANDOM_FRUIT_SPEED;
	}
	
}
