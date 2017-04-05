package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controller.GameController;
import model.FruitFactory;
import model.Snake;
import util.Constants;
import util.Constants.Direction;
import util.GameActions;

public class MainGame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7127408780600543979L;

	private JPanel sidePanel, gamePanel;
	private JLabel scoreBoard;
	private JButton pauseButton;
	private static final int HORIZONTAL_GAP = 30;
	private static final int VERTICAL_GAP = 120;
	private GameController controller;
	private Snake snake;
	private FruitFactory fruit;
	private GameActions gameActions;
	private static volatile MainGame mainGame = null;

	public JPanel getGamePanel() { return gamePanel; }

	private MainGame() {
		snake = Snake.getUniqueInstance();
		fruit = FruitFactory.getUniqueInstance();
		controller = GameController.getUniqueInstance();
		gameActions = new GameActions();
		buildGame();
	}

	public static synchronized MainGame getUniqueInstance() {
		if (mainGame == null)
			mainGame = new MainGame();
		return mainGame;
	}

	public void buildGame() {
		sidePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, HORIZONTAL_GAP, VERTICAL_GAP));
		gamePanel = new JPanel();
		scoreBoard = new JLabel();
		pauseButton = new JButton("Pause");
		setLayout(new BorderLayout());
		setBackground(null);
		setDoubleBuffered(true);

		gamePanel.setBackground(Color.WHITE);
		sidePanel.setBackground(Color.BLACK);

		scoreBoard.setFont(Constants.BUTTON_FONT);
		scoreBoard.setForeground(Color.WHITE);
		scoreBoard.setText("Score: " + controller.getScore());

		gamePanel.setPreferredSize(Constants.GAME_SIZE);
		sidePanel.setPreferredSize(Constants.SIDE_PANEL_SIZE);
		pauseButton.setPreferredSize(Constants.BUTTON_SIZE);
		pauseButton.setFont(Constants.BUTTON_FONT);
		
		pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.pause();
			}
		});

		addAction("UP", gameActions.new UpAction("NORTH", Direction.NORTH));
		addAction("DOWN", gameActions.new DownAction("SOUTH", Direction.SOUTH));
		addAction("LEFT", gameActions.new LeftAction("WEST", Direction.WEST));
		addAction("RIGHT", gameActions.new RightAction("EAST", Direction.EAST));
		
		sidePanel.add(scoreBoard);
		sidePanel.add(pauseButton);
		add(sidePanel, BorderLayout.EAST);
		add(gamePanel, BorderLayout.WEST);
		setVisible(true);
	}

	public void update(){
		scoreBoard.setText("Score: " + controller.getScore());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if (controller.isStarted()) {
			fruit.draw(g);
			snake.draw(g);
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void reset() {
		mainGame = new MainGame();
	}
	
	public void addAction(String name, AbstractAction action)
	{
		KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(name);
		InputMap inputMap = gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = gamePanel.getActionMap();
		inputMap.put(pressedKeyStroke, name);
		actionMap.put(name, action);
	}

}
