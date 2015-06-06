package window;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingsMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -313446727191253729L;

	private static SettingsMenu settingsMenu = null;
	private JButton backButton;

	private SettingsMenu() {
		buildSettingsMenu();
	}

	private void buildSettingsMenu() {
		backButton = new JButton("Back");
		add(backButton);
		
		setVisible(true);
	}

	public static synchronized SettingsMenu getUniqueInstance() {
		if (settingsMenu == null)
			settingsMenu = new SettingsMenu();
		return settingsMenu;
	}
	
	public JButton getBackButton() {
		return backButton;
	}

}
