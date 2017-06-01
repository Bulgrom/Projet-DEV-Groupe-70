package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.imageio.ImageIO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MenuButton extends JButton implements MouseListener {
	
	public static Font newFont = new Font("Times New Roman",Font.ITALIC,30);
	public static Font font2 = new Font("Times New Roman",Font.ITALIC,30);
	private String name;
	private Image img;
	private Color color;
	
	GraphicsEnvironment ge = null ;
	{try {
	    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		newFont = Font.createFont(Font.TRUETYPE_FONT,new File("newFont.ttf"));
		ge.registerFont(newFont);
	} catch (FontFormatException e) {
		System.out.print("Nope");
	} catch (IOException e1) {
		System.out.print("Nopebis");
	}}
	
	{try {
	    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		font2 = Font.createFont(Font.TRUETYPE_FONT,new File("font2.ttf"));
		ge.registerFont(font2);
	} catch (FontFormatException e) {
		System.out.print("Nope");
	} catch (IOException e1) {
		System.out.print("Nopebis");
	}}
	
	public MenuButton(String str, Color color){
		super(str);
		this.color = color;
		this.name = str;
		try {
			img = ImageIO.read(new File("img/BlackBackground.jpg"));
			this.setBorderPainted(false);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		this.setMaximumSize(new Dimension(500,40));
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g){
		int width = this.getWidth();
		int height = this.getHeight();
		g.drawImage(img,0,0, width, height, this);
		g.setColor(color);
		this.drawCenteredString(g,this.name,new Rectangle(width,height),newFont.deriveFont((float) 55));
	}
	
	
	public void mouseClicked(MouseEvent event) { 
		color = Color.BLUE;
		try {
			img = ImageIO.read(new File("img/WhiteBackground.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void mouseEntered(MouseEvent event) {
		color = Color.getHSBColor((float)0.7, 1, 1);
		try {
			img = ImageIO.read(new File("img/WhiteBackground.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mouseExited(MouseEvent event) { 
		color = Color.getHSBColor((float)0.14, 1, 1);
		try {
			img = ImageIO.read(new File("img/BlackBackground.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mousePressed(MouseEvent event) { 
		color = Color.blue;
		try {
			img = ImageIO.read(new File("img/WhiteBackground.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mouseReleased(MouseEvent event) { 
		  if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
			  color = Color.getHSBColor((float)0.14, 1, 1);
			  try {
				  img = ImageIO.read(new File("img/BlackBackground.jpg"));
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
		  }
	}       
	
	//method from Internet, with small changes to correspond to the font imported
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent()-6;
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	}
}

