package game;

import java.awt.Rectangle;

import constants.Direction;
public class Snake {

	private int currentXPos = 395;
	private int currentYPos = 235;
	
	private int currentSpeedX = 0;
	private int currentSpeedY = 0;

	

	public static Rectangle r = new Rectangle(0, 0, 0, 0);
	
	//Need to figure out a way to get the update not to stop moving my snake around
	//Right now what is happening is because of the keyReleased it stops all movement because it can't enter if statement 
	//Need to fix if statement
	public void update() {
		
		r.setRect(snakeX, snakeY, size, size);
		
		if (direction == Direction.UP)
			move(Direction.UP);
		else if (direction == Direction.DOWN)
			move(Direction.DOWN);
		else if (direction == Direction.RIGHT)
			move(Direction.RIGHT);
		else
			move(Direction.LEFT);			
			
		// prevents snake from moving out of bounds
		int posX = currentXPos + currentSpeedX;
		int posY = currentYPos + currentSpeedY;

		//need to fix boundary conditions for better collision detection later 
		//the corners of the screen don't stop snake from going out of screen
		if (posX <= Constants.MIN_BOUNDARY_X) {
			currentXPos = Constants.MIN_BOUNDARY_X + Constants.SNAKE_SIZE;
		} else if (posY <= Constants.MIN_BOUNDARY_Y) {
			currentYPos =Constants. MIN_BOUNDARY_Y + Constants.SNAKE_SIZE;
		} else if (posX >= Constants.MAX_BOUNDARY_X) {
			currentXPos = Constants.MAX_BOUNDARY_X - Constants.SNAKE_SIZE;
		} else if (posY >= Constants.MAX_BOUNDARY_Y) {
			currentYPos = Constants.MAX_BOUNDARY_Y - Constants.SNAKE_SIZE;
		} else if (posX <= Constants.MIN_BOUNDARY_X && posY <= Constants.MIN_BOUNDARY_Y) {
			currentXPos = Constants.MIN_BOUNDARY_X + 1;
			currentYPos = Constants.MIN_BOUNDARY_Y + 1;
		} else if (posX <= Constants.MIN_BOUNDARY_X && posY >= Constants.MAX_BOUNDARY_Y) {
			currentXPos = Constants.MIN_BOUNDARY_X + 1;
			currentYPos = Constants.MAX_BOUNDARY_Y - 1;
		} else if (posX >= Constants.MAX_BOUNDARY_X && posY >= Constants.MAX_BOUNDARY_Y) {
			currentXPos = Constants.MAX_BOUNDARY_X - 1;
			currentYPos = Constants.MAX_BOUNDARY_Y - 1;
		} else if (posX >= Constants.MAX_BOUNDARY_X && posY <= Constants.MIN_BOUNDARY_Y) {
			currentXPos = Constants.MAX_BOUNDARY_X - 1;
			currentYPos = Constants.MIN_BOUNDARY_Y + 1;
		}

	}

	public void move(Direction direction) {
		switch (direction) {
		case UP:
			speedX -= MOVESPEED;
			break;
		case DOWN:
			speedY += MOVESPEED;
			break;
		case RIGHT:
			speedX += MOVESPEED;
			break;
		case LEFT:
			speedY -= MOVESPEED;
			break;
		}
	}

	public int getSnakeX() {
		return currentXPos;
	}

	public int getSnakeY() {
		return currentYPos;
	}

	public int getSpeedX() {
		return currentSpeedX;
	}

	public int getSpeedY() {
		return currentSpeedY;
	}

	public void setSnakeX(int snakeX) {
		this.currentXPos = snakeX;
	}

	public void setSnakeY(int snakeY) {
		this.currentYPos = snakeY;
	}

	public void setSpeedX(int speedX) {
		this.currentSpeedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.currentSpeedY = speedY;
	}
}
