package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

import util.Constants;

public class MainMenu extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2492018684141315849L;
	protected JButton startButton, quitButton, settingsButton;
	protected JTextComponent title;
	protected JLabel titleGame;

	private static MainMenu mainMenu = null;

	private MainMenu() {
		buildMenu();
	}

	public static synchronized MainMenu getUniqueInstance() {
		if (mainMenu == null)
			mainMenu = new MainMenu();
		return mainMenu;
	}

	public void buildMenu() {
		JPanel buttonPanel = new JPanel(new FlowLayout());
		JPanel titlePanel = new JPanel(new BorderLayout());
		titleGame = new JLabel("Snake."); 
		setLayout(new BorderLayout());
		setEnabled(true);
		setBackground(Color.WHITE);
		setDoubleBuffered(true);
		startButton = new JButton("Start");
		settingsButton = new JButton("Settings");
		quitButton = new JButton("Quit");
		
		startButton.setPreferredSize(Constants.BUTTON_SIZE);
		settingsButton.setPreferredSize(Constants.BUTTON_SIZE);
		quitButton.setPreferredSize(Constants.BUTTON_SIZE);
		titleGame.setPreferredSize(Constants.TITLE_SIZE);
		
		startButton.setFont(Constants.BUTTON_FONT);
		settingsButton.setFont(Constants.BUTTON_FONT);
		quitButton.setFont(Constants.BUTTON_FONT);
		titleGame.setFont(Constants.TITLE_FONT);
		
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		titlePanel.add(titleGame);
		buttonPanel.add(startButton, FlowLayout.LEFT);
		buttonPanel.add(settingsButton, FlowLayout.CENTER);
		buttonPanel.add(quitButton, FlowLayout.RIGHT);
		buttonPanel.setBackground(null);
		titlePanel.setBackground(null);
		
		add(titlePanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public JButton getStartButton() {
		return startButton;
	}

	public JButton getSettingsButton() {
		return settingsButton;
	}
}
