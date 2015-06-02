//package window;
//
//import java.awt.CardLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import utility.Constants;
// 
//public class GameGUI extends JFrame{
//     
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 656188609855005208L;
//	private static GameGUI gameGUI = null;
//	
//	private MainMenu mainMenuPanel;
//	private SettingsMenu settingsPanel;
//	private MainGame mainGamePanel;
//	private JPanel card;
//	private CardLayout cardLayout = new CardLayout();
//
//	protected GameGUI() {
//		buildGame();
//	}
//	
//	public static GameGUI getInstance() {
//		if (gameGUI == null)
//			gameGUI = new GameGUI();
//		return gameGUI;
//	}
//	
//	private void buildGame() {
//		setTitle("Snake");
//		setFocusable(false);
//		setResizable(false);
//		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//		card = new JPanel(cardLayout);
//		mainMenuPanel = MainMenu.getInstance();
//		settingsPanel = SettingsMenu.getInstance();
//		mainGamePanel = MainGame.getInstance();
//		card.add(mainMenuPanel, "1");
//		card.add(settingsPanel, "2");
//		card.add(mainGamePanel, "3");
//		
//		mainMenuPanel.getSettingsButton().addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(card, "2");
//			}
//		});
//		mainMenuPanel.getStartButton().addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(card, "3");
//			}
//		});
//		
//		add(card);
//		setVisible(true);
//	}
//}