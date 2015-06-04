package window;

import fruit.*;

import java.applet.Applet;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

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
	
	private FruitView fruitView;
	private SnakeView snakeView;
	
	private MainMenu mainMenuPanel;
	private SettingsMenu settingsPanel;
	private MainGame mainGamePanel;
	private JPanel card;
	private CardLayout cardLayout = new CardLayout();
	Frame frame;
	
	private boolean inGame;
	
	@Override
	public void init() {
//		this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
//		this.setBackground(Color.WHITE);
		this.setFocusable(true);
		frame = (Frame) this.getParent().getParent();
//		frame.setTitle("Snake GuiController");
		this.addKeyListener(this);
		
		this.inGame = false;
		
		//fruit = new RegularFruit();
		//fruit = new LinearFruit();
		fruit = new RandomFruit();
		snake = Snake.getUniqueInstance();
		controller = GameController.getUniqueInstance(snake, fruit);
		
		buildGame();
		
	}
	
	private void buildGame() {
		frame.setTitle("Snake");
		frame.setResizable(false);
		frame.setSize(Constants.WINDOW_WIDTH+100, Constants.WINDOW_HEIGHT+100);
		frame.setLocationRelativeTo(null);
		
		
		card = new JPanel(cardLayout);
		mainMenuPanel = MainMenu.getUniqueInstance();
		settingsPanel = SettingsMenu.getUniqueInstance();
		mainGamePanel = MainGame.getUniqueInstance();
		card.add(mainMenuPanel, "1");
		card.add(settingsPanel, "2");
		card.add(mainGamePanel, "3");
		
		mainMenuPanel.getSettingsButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(card, "2");
			}
		});
		mainMenuPanel.getStartButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(card, "3");
				setInGame(true);
			}
		});
		
		add(card);
		setVisible(true);
	}
	
	@Override
	public void start() {

		
		fruitView = new FruitView(fruit);
		snakeView = new SnakeView(snake);
		
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {

			this.repaint();
			fruit.update();
			snake.update();
			if(inGame){
				snakeView.update();
				fruitView.update();
				controller.setGameBoundaries(snake, fruit);
			}
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
		
		if(this.inGame){
			fruitView.draw(g);
			snakeView.draw(g);
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP && (snake.getDirection() != Direction.SOUTH || snake.getDirection() == null)) {
			snake.setDirection(Direction.NORTH);
		} else if (key == KeyEvent.VK_DOWN && (snake.getDirection() != Direction.NORTH || snake.getDirection() == null)) {
			snake.setDirection(Direction.SOUTH);
		} else if (key == KeyEvent.VK_RIGHT && (snake.getDirection() != Direction.WEST || snake.getDirection() == null)) {
			snake.setDirection(Direction.EAST);
		} else if (key == KeyEvent.VK_LEFT && (snake.getDirection() != Direction.EAST || snake.getDirection() == null)) {
			snake.setDirection(Direction.WEST);
		}
//		System.out.println("From Start");
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

}
