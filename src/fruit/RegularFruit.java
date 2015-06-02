package fruit;

import java.awt.Color;

import utility.Constants;
public class RegularFruit extends Fruit {

	public RegularFruit(){
		super();
		this.value = Constants.REGULAR_FRUIT_VALUE;
		this.color = Constants.REGULAR_FRUIT_COLOR;
		this.currentSpeed = 0;
		this.defaultSpeed = 0;
	}
	
	
}
