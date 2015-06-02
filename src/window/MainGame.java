package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.GameController;
import utility.Constants;

public class MainGame extends JPanel{

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
	private static MainGame mainGame = null;

	private MainGame() {
		controller = GameController.getUniqueInstance();
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
		
		sidePanel.add(scoreBoard);
		sidePanel.add(pauseButton);
		add(sidePanel, BorderLayout.EAST);
		add(gamePanel, BorderLayout.WEST);
		setVisible(true);
	}
}
