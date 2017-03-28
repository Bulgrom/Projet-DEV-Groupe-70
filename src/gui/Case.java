package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Case extends JButton{
	int xCoord;
	int yCoord;
	ImageIcon Icon;
	public Case (int xCoord, int yCoord, boolean isJamy) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.Icon = new ImageIcon("src/gui/jamy.png");  
		if (isJamy) {
			this.setIcon(this.Icon);
		}	
	}

		
	}


