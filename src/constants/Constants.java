package constants;

public class Constants {
	
	//Snake//
	public static final int MIN_BOUNDARY_X = 0;
	public static final int MIN_BOUNDARY_Y = 0;
	public static final int MAX_BOUNDARY_X = 790;
	public static final int MAX_BOUNDARY_Y = 470;
	public static final int MOVE_SPEED = 3;
	public static final int SNAKE_SIZE = 10;
	
	//Fruit//
	public static final int FRUIT_SIZE = 10;
	
	//Start//
	public static final int REFRESH_RATE = 20;
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 480;
	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}
}
