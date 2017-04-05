package model;

import util.Constants;
import util.Constants.Direction;

/**
 * A regular non-moving Fruit
 * @author Justin
 *
 */
public class RegularFruit extends Fruit {

	public RegularFruit(){
		super();
		this.value = Constants.REGULAR_FRUIT_VALUE;
		this.color = Constants.REGULAR_FRUIT_COLOR;
		this.currentSpeed = 0;
		this.defaultSpeed = 0;
		this.fruitImage = Constants.REGULAR_FRUIT_IMAGE;
	}

	@Override
	public void update() {
		
	}

	@Override
	public int getSpeed() {
		return this.currentSpeed;
	}

	@Override
	public void setDirection(Direction d) {
		
	}
	
	@Override
	public Direction getDirection() {
		return Direction.NONE;
	}
}
