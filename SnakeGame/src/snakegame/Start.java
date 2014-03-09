package snakegame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Start extends Applet implements Runnable, KeyListener {
	
	final int REFRESH_RATE = 17;
	
	private Snake snake;

	
	@Override
	public void init() {
		setSize(800, 480);
		setBackground(Color.BLACK);
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

	}
	
	@Override
	public void paint(Graphics g) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
