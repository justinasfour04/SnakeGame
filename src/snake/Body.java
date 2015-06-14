package snake;

import java.awt.Color;

import utility.Constants;

public class Body {
	private int snakeBodyPosX;
	private int snakeBodyPosY;
	private int bodyPartNumber;

	public Body(int x, int y, int bodyPartNumber) {
		snakeBodyPosX = x;
		snakeBodyPosY = y;
		this.bodyPartNumber = bodyPartNumber;
	}

	public void setBodyPosition(int x, int y, int bodyPartNumber) {
		snakeBodyPosX = x;
		snakeBodyPosY = y;
		this.bodyPartNumber = bodyPartNumber;
	}

	public int getSnakeBodyPosX() {
		return snakeBodyPosX;
	}

	public void setSnakeBodyPosX(int snakeBodyPosX) {
		this.snakeBodyPosX = snakeBodyPosX;
	}

	public int getSnakeBodyPosY() {
		return snakeBodyPosY;
	}

	public void setSnakeBodyPosY(int snakeBodyPosY) {
		this.snakeBodyPosY = snakeBodyPosY;
	}

	public int getBodyPartNumber() {
		return bodyPartNumber;
	}

	public void setBodyPartNumber(int bodyPartNumber) {
		this.bodyPartNumber = bodyPartNumber;
	}
}
