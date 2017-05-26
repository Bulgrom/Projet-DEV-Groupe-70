package gui;

import javax.swing.*;
import map.Square;
import java.awt.Dimension;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.border.*;
import java.awt.*;

public class Case extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xCoord;
	private int yCoord;
	private ImageIcon icon;
	private Square square;
	public Case(int xCoord, int yCoord, Square square) {

		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.setPreferredSize(new Dimension(50,50));
		int[] coordinates = new int[2];
		coordinates[0] = xCoord;
		coordinates[1] = yCoord;
		this.setActionCommand(Arrays.toString(coordinates));
		this.square = square;
		this.chooseBackground(square);
		this.chooseCharacterIcon();
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
	
	public Square getSquare() {
		return square;
	}
	
	public void chooseBackground (Square square) { // Ya du rififi dans background qui contient déjà le sprite? idk
		if (square.getBackground() != null) {
			int backgroundID = square.getBackground().getId();
			if (backgroundID == 1) {
				this.setBackground(Color.blue);
			}
			if (backgroundID ==2 ){
				this.setBackground(Color.red);
			}
		}
	}
	
	
	public void chooseCharacterIcon () { //imo c'est plus simple de faire comme avant et de donner un sprite au personnage
										 //tant qu'on y est on lui donne un sprite de cadavre? ou rien du tout?
		if (square.getCharacter() != null) {
			int characterID = square.getCharacter().getId();
			
			if (characterID == 1) {
				this.icon = new ImageIcon("img/jamy.png");
				this.setIcon(this.icon);
			}
			if (characterID ==2 ){
				this.icon = new ImageIcon("img/fred.png");
				this.setIcon(this.icon);
			}
			
			
		}
		else {
			this.icon = null;
			this.setIcon(null);
		}
		this.revalidate();
		this.repaint();
		
	}

	public void showAsSelected() {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	public void showUnselected() {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
	}

	
	public void showInRange() {
		this.setBorder(BorderFactory.createLineBorder(Color.red));
	}
}
