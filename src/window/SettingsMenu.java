package window;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingsMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -313446727191253729L;

	private static SettingsMenu settingsMenu = null;

	private SettingsMenu() {
		buildSettingsMenu();
	}

	private void buildSettingsMenu() {
		//JLabel test = new JLabel("HELOO");
		add(new JButton("Back"));
		setVisible(true);
	}

	public static synchronized SettingsMenu getUniqueInstance() {
		if (settingsMenu == null)
			settingsMenu = new SettingsMenu();
		return settingsMenu;
	}

}
