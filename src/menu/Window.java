package menu;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
  
	int i = 0;
	CardLayout cardLayout = new CardLayout();
	JPanel menu = new JPanel();

	public Window() {
		Background screenMenu = ScreenMenu.getScreenMenu(this);
		this.setContentPane(screenMenu);

	}
}