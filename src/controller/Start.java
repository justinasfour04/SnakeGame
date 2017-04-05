package controller;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.FruitFactory;
import model.Snake;
import util.Constants;
import view.MainGame;
import view.MainMenu;
import view.SettingsMenu;

public class Start extends JFrame implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;
	private Snake snake;
	private FruitFactory fruitFactory;

	private GameController controller;
	private Timer timer;
	
	private MainMenu mainMenuPanel;
	private SettingsMenu settingsPanel;
	private MainGame mainGamePanel;
	private JPanel card;
	private CardLayout cardLayout = new CardLayout();
	private Frame frame;
	

	public Start() {
		super();
		init();
	}

	public void init() {
		frame = this;
		
		frame.setFocusable(true);

		snake = Snake.getUniqueInstance();
		fruitFactory = FruitFactory.getUniqueInstance();
		controller = GameController.getUniqueInstance();
		buildGame();
		
		timer = new Timer(Constants.REFRESH_RATE, this);
		timer.start();
	}

	private void buildGame() {
		frame.setTitle("Snake");
		frame.setResizable(false);
		frame.setSize(Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

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

		frame.add(card);
		frame.setVisible(true);
	}

	public void run() {
		if (!controller.isGameOver()) {
			mainGamePanel.update();
			snake.update();
			fruitFactory.update();
			controller.fruitEaten();
			controller.isWallHit();
		} else {
			controller.setGameOver(false);
			mainGamePanel.reset();
			init();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		run();
		mainGamePanel.repaint();
	}
}
