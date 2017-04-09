package fr.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Point;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton implements MouseListener {
	private Font newFont = new Font("Times New Roman",Font.ITALIC,30);
	private String name;
	private Image img;
	
	GraphicsEnvironment ge = null ;
	{try {
		URL url = new URL("file:///C:/Users/Thaveau/workspace/Menu/newFont.ttf");
	    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		newFont = Font.createFont(Font.TRUETYPE_FONT,url.openStream());
		ge.registerFont(newFont);
	} catch (FontFormatException e) {
		System.out.print("Nope");
	} catch (IOException e1) {
		System.out.print("Nopebis");
	}}
	
	public MenuButton(String str){
		super(str);
		this.name = str;
		try {
			img = ImageIO.read(new File("BlackBackground.jpg"));
			//this.setBorderPainted(false);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g){
		int width = this.getWidth();
		int height = this.getHeight();
		g.drawImage(img,0,0, width, height, this);
		g.setColor(Color.getHSBColor((float)0.14, 1, 1));
		this.drawCenteredString(g,this.name,new Rectangle(width,height),newFont.deriveFont((float) 50));
	}
	
	
	public void mouseClicked(MouseEvent event) { 
		try {
			img = ImageIO.read(new File("WhiteBackground.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void mouseEntered(MouseEvent event) {
		try {
			img = ImageIO.read(new File("WhiteBackground.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void mouseExited(MouseEvent event) { 
		try {
			img = ImageIO.read(new File("BlackBackground.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void mousePressed(MouseEvent event) { 
		try {
			img = ImageIO.read(new File("WhiteBackground.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void mouseReleased(MouseEvent event) { 
		try {
			img = ImageIO.read(new File("BlackBackground.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}       

	
	
	//method from Internet, with small changes to correspond to the font imported
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent()-5;
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	}
}

