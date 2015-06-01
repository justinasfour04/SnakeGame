package window;

import fruit.*;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controllers.GameController;
import snake.Snake;
import utility.Constants;
import utility.Constants.Direction;

public class Start extends Applet implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	private Snake snake;
	private Fruit fruit;
	private GameController controller;
	private Image image;
	private Graphics second;

	@Override
	public void init() {
		this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		this.setBackground(Color.WHITE);
		this.setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Snake GuiController");
		this.addKeyListener(this);

	}

	@Override
	public void start() {

		fruit = new RegularFruit();
		controller = GameController.getInstance();
		snake = Snake.getInstance();

		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {

			this.repaint();
			// fruit.update();
			snake.update();
			try {
				Thread.sleep(Constants.REFRESH_RATE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {

		// GuiController border drawing happening over here
		g.drawLine(10, 10, 10, 478); // Left border
		g.drawLine(10, 10, 800, 10); // Top border
		g.drawLine(10, 478, 800, 478); // Bottom border
		g.drawLine(800, 10, 800, 478); // Right border

		// The snake is being drawn
		g.setColor(Color.BLUE);
		g.fillRect((int) snake.getSnakeX(), (int) snake.getSnakeY(),
				(int) Constants.SNAKE_SIZE, (int) Constants.SNAKE_SIZE);

		// The fruit is to get painted
		// g.setColor(Color.RED);
		// g.fillOval((int) fruit.getCenterX(),
		// (int) fruit.getCenterY(), (int) fruit.getWidth(),
		// (int) fruit.getHeight());

		g.setColor(Color.BLACK);
		g.drawString("The Snake GuiController", 870, 90);
		g.drawString("Score: " + controller.getScore(), 900, 120);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP && snake.getDirection() != Direction.DOWN) {
			snake.setDirection(Direction.UP);
		} else if (key == KeyEvent.VK_DOWN && snake.getDirection() != Direction.UP) {
			snake.setDirection(Direction.DOWN);
		} else if (key == KeyEvent.VK_RIGHT && snake.getDirection() != Direction.LEFT) {
			snake.setDirection(Direction.RIGHT);
		} else if (key == KeyEvent.VK_LEFT && snake.getDirection() != Direction.RIGHT) {
			snake.setDirection(Direction.LEFT);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
