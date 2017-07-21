package gui;

import javax.swing.*;
import map.Square;
import java.awt.Dimension;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.border.*;
import java.awt.*;
import map.Background;

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
			Background background = square.getBackground();
			this.setBackground(background.getColor());
		}
	}
	
	
	public void chooseCharacterIcon () {
		if (square.getCharacter() != null) {
			this.icon = new ImageIcon("img/" + square.getCharacter().getSpriteLoc() + ".png");
			this.setIcon(icon);
			}
		else {
			this.icon = null;
			this.setIcon(null);
		}
		this.revalidate();
		this.repaint();
		
	}

	public void showAsSelected() {
		this.setBorder(BorderFactory.createLineBorder(Color.black,3));
	}
	public void showUnselected() {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
	}

	
	public void showInRange() {
		this.setBorder(BorderFactory.createLineBorder(Color.red));
	}
	
	public void showAsCurrentPLayer() {
		this.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
	}

}


