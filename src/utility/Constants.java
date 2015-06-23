package utility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * Class of Constants
 * @author Justin, Justin
 *
 */
public class Constants {
	
	//Snake//
	public static final int MIN_BOUNDARY_X = 5;
	public static final int MIN_BOUNDARY_Y = 40;
	public static final int MAX_BOUNDARY_X = 790;
	public static final int MAX_BOUNDARY_Y = 560;
	public static final int MOVE_SPEED = 3;
	public static final int START_SPEED = 0;
	public static final int SNAKE_SIZE = 40;
	public static final int SNAKE_STARTING_POSX = 395;
	public static final int SNAKE_STARTING_POSY = 295;
	public static final Color SNAKE_COLOR = new Color(123,86,32);
	public static final String SNAKE_HEAD_SHEET = "source/image/snakeHeadSheet.png"; 
	public static final String SNAKE_BODY_SHEET = "source/image/snakeBodySheet.png";

	//Fruit//
	public static final int FRUIT_SIZE = 40;
	public static final int REGULAR_FRUIT_VALUE = 1;
	public static final int LINEAR_FRUIT_VALUE = 3;
	public static final int RANDOM_FRUIT_VALUE = 5;
	public static final int LINEAR_FRUIT_SPEED = 2; // placeholder value
	public static final int RANDOM_FRUIT_SPEED = 3; // placeholder value
	public static final Color REGULAR_FRUIT_COLOR = new Color(255,0,0); // placeholder value
	public static final Color LINEAR_FRUIT_COLOR = new Color(0,255,0); // placeholder value
	public static final Color RANDOM_FRUIT_COLOR = new Color(0,0,255); // placeholder value
	public static final int FRUIT_SPAWN_RATE = 5;
	public static final int MAX_FRUITS = 4;
	public static final int LINEAR_FRUIT_SPAWN_TIME = 15;
	public static final int RANDOM_FRUIT_SPAWN_TIME = 30;
	public static final String REGULAR_FRUIT_IMAGE = "source/image/Radish.png";
	public static final String LINEAR_FRUIT_IMAGE = "source/image/Grape.png";

	//Start//
	public static final int REFRESH_RATE = 30;
	public static final int WINDOW_WIDTH = 1100;
	public static final int WINDOW_HEIGHT = 580;
	public static final Font BUTTON_FONT = new Font("Times New Roman", Font.BOLD, 40);
	public static final Dimension BUTTON_SIZE = new Dimension(200, 100);
	public static final Font TITLE_FONT = new Font("Times New Roman", Font.BOLD, 60);
	public static final Dimension TITLE_SIZE = new Dimension(400, 100);
	public static final Image BACKGROUND = (new ImageIcon("background.jpeg")).getImage();
	public static final Dimension SIDE_PANEL_SIZE = new Dimension(WINDOW_WIDTH / 4, WINDOW_HEIGHT);
	public static final Dimension GAME_SIZE = new Dimension(WINDOW_WIDTH * 3 / 4, WINDOW_HEIGHT);
	
	//MISC//
	public static final int PAUSE = 0;
	
	//Directions//
	public enum Direction {
		NORTH, SOUTH, WEST, EAST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST, NONE;
	}
}
