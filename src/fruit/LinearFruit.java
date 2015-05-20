package fruit;

import utility.Constants;

public class LinearFruit extends Fruit{
	
	private int speed;
	
	public LinearFruit(){
		super();
		this.value = Constants.LINEAR_FRUIT_VALUE;
		this.speed = Constants.LINEAR_FRUIT_SPEED;
	}
	
}
