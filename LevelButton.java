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


public class LevelButton extends JButton implements MouseListener {
	String imgName;
	String comments = "base";
	String name;
	Image img;
	String levelNumber;
	
	public LevelButton(String name,String levelNumber, String imgName, String comments){
		super(name);
		this.levelNumber = levelNumber;
		this.imgName = imgName;
		this.comments = comments;
		this.addMouseListener(this);
		try {
			img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g){
		int height = this.getHeight() - 250;
		int width = this.getWidth();
		
		g.drawImage(img, 0,height, 250, 250, this);
		g.setColor(Color.WHITE);
		g.drawRect(0, height, 250, 250);
		g.setColor(Color.BLUE);
		g.drawString(comments,270,height +20);
		g.setColor(Color.WHITE);
		this.drawCenteredString(g,levelNumber,new Rectangle(width,height),(MenuButton.newFont).deriveFont((float)45));
	}
	
	public void mouseClicked(MouseEvent event) { }

	
	public void mouseEntered(MouseEvent event) {}


	public void mouseExited(MouseEvent event) {	}

	
	public void mousePressed(MouseEvent event) { }

	
	public void mouseReleased(MouseEvent event) { }       

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
