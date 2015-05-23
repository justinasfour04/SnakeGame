package controllers;

import snake.Snake;
import fruit.Fruit;

public class GameController {

	private int score = 0; // TODO: Move to controller
	private boolean isEaten;
	private Fruit fruit;
	private Snake snake;

	// TODO: Move to controller
	public boolean checkCollision() {
		if (snake.intersects(fruit))
			return true;
		return false;
	}

	// TODO: Move to controller
	private void incrementScore() {
		if (isEaten)
			setScore(getScore() + 1);
	}

	// TODO: Move to controller
	public int getScore() {
		return score;
	}

	// TODO: Move to controller
	public void setScore(int score) {
		this.score = score;
	}
}
