package snakegame;

public class Snake {
	
	final int MOVESPEED = 5;
	private int snakeX = 399; 
	private int snakeY = 239; 
	
	private int speedX = MOVESPEED;
	private int speedY = MOVESPEED;
	
	private int size = 40;
	
	
	public void update() {
		
	}
	
	public void moveRight() {
		
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
	
	
	
	
}
