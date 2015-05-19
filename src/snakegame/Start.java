package snakegame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Start extends Applet implements Runnable, KeyListener {

	final int REFRESH_RATE = 20;

	private Snake snake;
	private Fruit fruit;
	private Image image;
	private Graphics second;

	@Override
	public void init() {
		this.setSize(1000, 480);
		this.setBackground(Color.WHITE);
		this.setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Snake Game");
		this.addKeyListener(this);

	}

	@Override
	public void start() {

		fruit = new Fruit();
		snake = new Snake();

		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {

			fruit.update();
			snake.update();
			this.repaint();
			try {
				Thread.sleep(REFRESH_RATE);
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

		// Game border drawing happening over here
		g.drawLine(10, 10, 10, 478); // Left border
		g.drawLine(10, 10, 800, 10); // Top border
		g.drawLine(10, 478, 800, 478); // Bottom border
		g.drawLine(800, 10, 800, 478); // Right border 
		

		// The snake is being drawn
		g.setColor(Color.BLUE);
		g.fillRect((int) Snake.r.getCenterX(), (int) Snake.r.getCenterY(),
				(int) Snake.r.getWidth(), (int) Snake.r.getHeight());

		// The fruit is to get painted
		g.setColor(Color.RED);
		g.fillOval((int) Fruit.fruit.getCenterX(),
				(int) Fruit.fruit.getCenterY(), (int) Fruit.fruit.getWidth(),
				(int) Fruit.fruit.getHeight());

		g.setColor(Color.BLACK);
		g.drawString("The Snake Game", 870, 90);
		g.drawString("Score: " + Fruit.getScore(), 900, 120);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.move(Direction.UP);
			break;

		case KeyEvent.VK_DOWN:
			snake.move(Direction.DOWN);
			break;

		case KeyEvent.VK_RIGHT:
			snake.move(Direction.RIGHT);
			break;

		case KeyEvent.VK_LEFT:
			snake.move(Direction.LEFT);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		switch (e.getKeyCode()) {
//		case KeyEvent.VK_UP:
//			snake.stopAllExcept(Direction.UP);
//			break;
//
//		case KeyEvent.VK_DOWN:
//			snake.stopAllExcept(Direction.DOWN);
//			break;
//
//		case KeyEvent.VK_RIGHT:
//			snake.stopAllExcept(Direction.RIGHT);
//			break;
//
//		case KeyEvent.VK_LEFT:
//			snake.stopAllExcept(Direction.LEFT);
//			break;
//		}
	}

}