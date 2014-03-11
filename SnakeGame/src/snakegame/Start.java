package snakegame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Start extends Applet implements Runnable, KeyListener {
	
	final int REFRESH_RATE = 17;
	
	private Snake snake;
	private Image image;
	private Graphics second; 
	
	@Override
	public void init() {
		setSize(800, 480);
		setBackground(Color.WHITE);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Snake Game");
		addKeyListener(this);
		
	}
	
	@Override
	public void start() {
		
		snake = new Snake();

		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			
			snake.update();
			repaint();
			try {
				Thread.sleep(REFRESH_RATE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
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
		g.setColor(Color.BLUE);
		g.fillRect((int) Snake.r.getX(), (int) Snake.r.getY(), (int) Snake.r.getWidth(), (int) Snake.r.getHeight());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.setMovingInY(true);
			snake.move(Direction.UP);
			break;
		
		case KeyEvent.VK_DOWN:
			snake.setMovingInY(true);
			snake.move(Direction.DOWN);
			break;
			
		case KeyEvent.VK_RIGHT:
			snake.setMovingInX(true);
			snake.move(Direction.RIGHT);
			break;
			
		case KeyEvent.VK_LEFT:
			snake.setMovingInX(true);
			snake.move(Direction.LEFT);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.setMovingInY(false);
			snake.stop();
			break;
		
		case KeyEvent.VK_DOWN:
			snake.setMovingInY(false);
			snake.stop();
			break;
			
		case KeyEvent.VK_RIGHT:
			snake.setMovingInX(false);
			snake.stop();
			break;
			
		case KeyEvent.VK_LEFT:
			snake.setMovingInX(false);
			snake.stop();
			break;
		}
	}

}
