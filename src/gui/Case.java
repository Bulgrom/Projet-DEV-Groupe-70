package gui;

import javax.swing.*;

public class Case extends JButton {
	int xCoord;
	int yCoord;
	ImageIcon icon;
	public Case(int xCoord, int yCoord, int iconNumber) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;

		if (iconNumber == 1) {
			this.icon = new ImageIcon("img/jamy.png");
			this.setIcon(this.icon);

		}
		if (iconNumber == 2) {
			this.icon = new ImageIcon("img/fred.png");
			this.setIcon(this.icon);
		}
	
	}
	
	
	public void chooseIcon (int iconNumber) {
		if (iconNumber == 1) {

			this.icon = new ImageIcon("img/jamy.png");
			this.setIcon(this.icon);
		}
		else {
			this.icon = new ImageIcon("img/fred.png");
			this.setIcon(this.icon);
		}
		
		
	}
}
