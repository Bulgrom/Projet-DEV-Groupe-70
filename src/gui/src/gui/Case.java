package gui;

import javax.swing.*;

public class Case extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xCoord;
	private int yCoord;
	private ImageIcon icon;
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
	
	public int getXCoord() {
		return xCoord;
	}
	
	public int getYCoord() {
		return yCoord;
	}
	
	public void setXCoord(int x) {
		this.xCoord = x;
	}
	
	public void setYCoord(int y) {
		this.yCoord = y;
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
