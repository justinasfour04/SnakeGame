package window;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import controllers.Game;
import utility.Constants;

public class MainMenu extends JFrame {

	private static MainMenu mainMenu = null;

	protected MainMenu() {
		buildMenu();
	}

	public static MainMenu getInstance() {
		if (mainMenu == null)
			mainMenu = new MainMenu();
		return mainMenu;
	}

	private void buildMenu() {
		createButton();
		setTitle("Snake Game");
		setFocusable(false);
		setResizable(false);
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	private void createButton() {
		JButton startButton = new JButton("Start");
		startButton.setMaximumSize(new Dimension(50, 50));
		JButton quitButton = new JButton("Quit");
		quitButton.setMaximumSize(new Dimension(50, 50));
		JButton settingsButton = new JButton("Settings");
		settingsButton.setMaximumSize(new Dimension(50, 50));
		JTextComponent title = new JTextArea("SNAKE GAME");

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: start game when button pressed
				Game game = new Game();
			}
		});
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO settings menu
				SettingsMenu settings = new SettingsMenu();
			}
		});

		ArrayList<JComponent> arg = new ArrayList<JComponent>();
		arg.add(startButton);
		arg.add(quitButton);
		arg.add(settingsButton);
		createLayout(arg);
	}

	private void createLayout(ArrayList<JComponent> arg) {
		Container pane = getContentPane();
		GroupLayout gLayout = new GroupLayout(pane);
		pane.setLayout(gLayout);

		gLayout.setAutoCreateContainerGaps(true);
		gLayout.setAutoCreateGaps(true);

		gLayout.setHorizontalGroup(gLayout
				.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addGap(Constants.WINDOW_WIDTH / 2).addComponent(arg.get(0))
				.addComponent(arg.get(2)).addComponent(arg.get(1)));
		gLayout.setVerticalGroup(gLayout.createSequentialGroup()
				.addGap(Constants.WINDOW_HEIGHT / 2).addComponent(arg.get(0))
				.addComponent(arg.get(2)).addComponent(arg.get(1)));
	}
}
