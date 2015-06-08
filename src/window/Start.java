package window;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import snake.Snake;
import utility.Constants;
import utility.Constants.Direction;
import controllers.GameController;
import fruit.FruitGenerator;

public class Start extends JFrame implements Runnable, ActionListener{

	private static final long serialVersionUID = 1L;
	private Snake snake;

	private FruitGenerator fruitGenerator;
	private GameController controller;
	Timer timer;

	private FruitGroupView fruitGroupView;
	private SnakeView snakeView;

	private MainMenu mainMenuPanel;
	private SettingsMenu settingsPanel;
	private MainGame mainGamePanel;
	private JPanel card;
	private CardLayout cardLayout = new CardLayout();
	Frame frame;
	

	public Start() {
		init();
	}

	public void init() {

		frame = this;
		
		frame.setFocusable(true);

		snake = Snake.getUniqueInstance();
		fruitGenerator = FruitGenerator.getUniqueInstance();

		controller = GameController.getUniqueInstance();
		buildGame();
		startView();
		
		timer = new Timer(Constants.REFRESH_RATE, this);
		timer.start();
	}

	private void buildGame() {
		frame.setTitle("Snake");
		frame.setResizable(false);
		frame.setSize(Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
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
				controller.setIsStarted();
			}
		});
		settingsPanel.getBackButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(card, "1");
			}
		});

		add(card);
		setVisible(true);
	}

	public void startView() {
		fruitGroupView = new FruitGroupView(fruitGenerator);
		snakeView = new SnakeView(snake);
	}

	public void run() {			
		mainGamePanel.update();
		fruitGenerator.update();
		snake.update();
		if(controller.isStarted()){
			snakeView.update();
			fruitGroupView.update();
			controller.applyRules(snake, fruitGenerator, snakeView, fruitGroupView);
		}
		frame.repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if(controller.isStarted()){
			fruitGroupView.draw(g);
			snakeView.draw(g);
		}

		Toolkit.getDefaultToolkit().sync();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		run();
	}
}
