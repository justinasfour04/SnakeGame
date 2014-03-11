package snakegame;

import java.awt.Rectangle;

public class Snake {

	final int MIN_BOUNDARY_X = 10;
	final int MIN_BOUNDARY_Y = 10;
	final int MAX_BOUNDARY_X = 790;
	final int MAX_BOUNDARY_Y = 470;
	final int MOVESPEED = 2;
	private int snakeX = 399;
	private int snakeY = 239;

	private int speedX = 0;
	private int speedY = 0;

	private boolean movingInX = false;
	private boolean movingInY = false;

	private int size = 10;

	public static Rectangle r = new Rectangle(0, 0, 0, 0);

	
	//Need to figure out a way to get the update not to stop moving my snake around
	//Right now what is happening is because of the keyReleased it stops all movement because it can't enter if statement 
	//Need to fix if statement
	public void update() {

		// updates x position
		if (movingInX && !movingInY) {
			snakeX += speedX;
		}
		// updates y position
		if (movingInY && !movingInX) {
			snakeY += speedY;
		}
		// prevents snake from moving out of bounds
		int posX = snakeX + speedX;
		int posY = snakeY + speedY;

		//need to fix boundary conditions for better collision detection later 
		//the corners of the screen don't stop snake from going out of screen
		if (posX <= MIN_BOUNDARY_X) {
			snakeX = MIN_BOUNDARY_X + 1;
		} else if (posY <= MIN_BOUNDARY_Y) {
			snakeY = MIN_BOUNDARY_Y + 1;
		} else if (posX >= MAX_BOUNDARY_X) {
			snakeX = MAX_BOUNDARY_X - 1;
		} else if (posY >= MAX_BOUNDARY_Y) {
			snakeY = MAX_BOUNDARY_Y - 1;
		} else if (posX <= MIN_BOUNDARY_X && posY <= MIN_BOUNDARY_Y) {
			snakeX = MIN_BOUNDARY_X + 1;
			snakeY = MIN_BOUNDARY_Y + 1;
		} else if (posX <= MIN_BOUNDARY_X && posY >= MAX_BOUNDARY_Y) {
			snakeX = MIN_BOUNDARY_X + 1;
			snakeY = MAX_BOUNDARY_Y - 1;
		} else if (posX >= MAX_BOUNDARY_X && posY >= MAX_BOUNDARY_Y) {
			snakeX = MAX_BOUNDARY_X - 1;
			snakeY = MAX_BOUNDARY_Y - 1;
		} else if (posX >= MAX_BOUNDARY_X && posY <= MIN_BOUNDARY_Y) {
			snakeX = MAX_BOUNDARY_X - 1;
			snakeY = MIN_BOUNDARY_Y + 1;
		}

		r.setRect(snakeX, snakeY, size, size);

	}

	public void move(Direction direction) {
		switch (direction) {
		case UP:
			setSpeedY(-MOVESPEED);
			break;
		case DOWN:
			setSpeedY(MOVESPEED);
			break;
		case RIGHT:
			setSpeedX(MOVESPEED);
			break;
		case LEFT:
			setSpeedX(-MOVESPEED);
			break;
		}
	}

	// This method needs to be looked at to stop the snake from moving in one axis while continuing to move in other
	public void stop() {
		if (movingInX) {
			setSpeedY(0);
			if (speedX < 0)
				setSpeedX(-MOVESPEED);
			else
				setSpeedX(MOVESPEED);
		}
		if (movingInY) {
			setSpeedX(0);
			if (speedY < 0)
				setSpeedY(-MOVESPEED);
			else
				setSpeedY(MOVESPEED);
		}
	}

	public int getSnakeX() {
		return snakeX;
	}

	public int getSnakeY() {
		return snakeY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public int getSize() {
		return size;
	}

	public void setSnakeX(int snakeX) {
		this.snakeX = snakeX;
	}

	public void setSnakeY(int snakeY) {
		this.snakeY = snakeY;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isMovingInX() {
		return movingInX;
	}

	public boolean isMovingInY() {
		return movingInY;
	}

	public void setMovingInX(boolean movingInX) {
		this.movingInX = movingInX;
	}

	public void setMovingInY(boolean movingInY) {
		this.movingInY = movingInY;
	}
}
