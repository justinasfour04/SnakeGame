package controllers;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utility.Constants;
import window.MainMenu;
import window.SettingsMenu;
import window.Start;
 
public class Game extends JFrame{
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 656188609855005208L;
	private static Game game = null;
	
	private MainMenu mainMenuPanel;
	private SettingsMenu settingsPanel;
	private JPanel card;
	private CardLayout cardLayout = new CardLayout();

	protected Game() {
		buildGame();
	}
	
	public static Game getInstance() {
		if (game == null)
			game = new Game();
		return game;
	}
	
	private void buildGame() {
		setTitle("Snake Game");
		setFocusable(false);
		setResizable(false);
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		card = new JPanel(cardLayout);
		mainMenuPanel = MainMenu.getInstance();
		settingsPanel = SettingsMenu.getInstance();
		card.add(mainMenuPanel, "1");
		card.add(settingsPanel, "2");
		
		mainMenuPanel.getSettingsButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(card, "2");
			}
		});
		mainMenuPanel.getStartButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		add(card);
		setVisible(true);
	}
}