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
import javax.swing.text.JTextComponent;

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
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void createButton() {
		JButton startButton = new JButton("Start");
		startButton.setMaximumSize(new Dimension(50, 50));
		JButton quitButton = new JButton("Quit");
		quitButton.setMaximumSize(new Dimension(50, 50));
		
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: start game when button pressed
			}
		});
		quitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JComponent[] arg = new JComponent[2];
		arg[0] = startButton;
		arg[1] = quitButton;
		createLayout(arg);
	}

	private void createLayout(JComponent... components ) {
		Container pane = getContentPane();
		GroupLayout gLayout = new GroupLayout(pane);
		pane.setLayout(gLayout);

		gLayout.setAutoCreateContainerGaps(true);
		gLayout.setAutoCreateGaps(true);

		gLayout.setHorizontalGroup(gLayout.createSequentialGroup().addGroup(
				gLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(components[0])
						.addComponent(components[1])));
		gLayout.setVerticalGroup(gLayout.createSequentialGroup()
				.addComponent(components[0])
				.addComponent(components[1]));

	}
}
