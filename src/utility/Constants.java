package utility;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Constants {

	// Snake//
	public static final int MIN_BOUNDARY_X = 0;
	public static final int MIN_BOUNDARY_Y = 0;
	public static final int MAX_BOUNDARY_X = 790;
	public static final int MAX_BOUNDARY_Y = 470;
	public static final int MOVE_SPEED = 3;
	public static final int START_SPEED = 0;
	public static final int SNAKE_SIZE = 10;
	public static final int SNAKE_STARTING_POSX = 395;
	public static final int SNAKE_STARTING_POSY = 295;

	// Fruit//
	public static final int FRUIT_SIZE = 10;
	public static final int REGULAR_FRUIT_VALUE = 1;
	public static final int LINEAR_FRUIT_VALUE = 3;
	public static final int RANDOM_FRUIT_VALUE = 5;
	public static final int LINEAR_FRUIT_SPEED = 5; // placeholder value
	public static final int RANDOM_FRUIT_SPEED = 10; // placeholder value

	// Start//
	public static final int REFRESH_RATE = 20;
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 480;
	public static final Font BUTTON_FONT = new Font("Times New Roman", Font.BOLD, 40);
	public static final Dimension BUTTON_SIZE = new Dimension(200, 100);
	public static final Font TITLE_FONT = new Font("Times New Roman", Font.BOLD, 60);
	public static final Dimension TITLE_SIZE = new Dimension(400, 100);
	public static final Image BACKGROUND = (new ImageIcon("background.jpeg")).getImage();
	public static final Dimension SIDE_PANEL_SIZE = new Dimension(WINDOW_WIDTH / 4, WINDOW_HEIGHT);
	public static final Dimension GAME_SIZE = new Dimension(WINDOW_WIDTH * 3 / 4, WINDOW_HEIGHT);

	public enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}
}
