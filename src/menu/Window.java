package menu;

import javax.swing.JFrame;

public class Window extends JFrame {
  
	public Window() {
		MenuBackground screenMenu = ScreenMenu.getScreenMenu(this);
		this.setContentPane(screenMenu);

	}
}