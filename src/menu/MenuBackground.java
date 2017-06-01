package menu;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JPanel;
 
public class MenuBackground extends JPanel {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int perfectHeight;
	int perfectWidth;
	String name;

	public MenuBackground(String name){
		super();
		this.name = name;
	}
	
	public void paintComponent(Graphics g){
		int currentWidth = this.getWidth();
		int currentHeight = this.getHeight();
		try {
			File imgFile = new File(name);
			Image img = ImageIO.read(imgFile);
			
			int[] table = MenuBackground.getImageDimension(imgFile);
			int height = table[0];
			int width = table[1];
			this.perfectImageSize(height,width);
			
			g.drawImage(img, 0, 0, perfectWidth, perfectHeight ,this);
			g.drawImage(ImageIO.read(new File("img/Cadre.png")), (currentWidth/2)-300,(currentHeight/2)-200,600,400,this);
			g.drawImage(ImageIO.read(new File("img/BlackBackground.jpg")), (currentWidth/2)-277,(currentHeight/2)-185,550,370,this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}               
	
	private void perfectImageSize(int heigth, int width){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double ratio;
		ratio = Math.max((screenSize.getHeight()/(double) heigth),screenSize.getWidth()/((double) width));
		perfectHeight = (int) ((double) heigth * ratio);
		perfectWidth = (int) ((double) width * ratio);
	}

	
	/**
	 * Gets image dimensions for given file 
	 * @param imgFile image file
	 * @return dimensions of image
	 * @throws IOException if the file is not a known image
	 */
	//Taken from Internet, to improve speed of reading size of images
	public static int[] getImageDimension(File imgFile) throws IOException {
	  int pos = imgFile.getName().lastIndexOf(".");
	  if (pos == -1)
	    throw new IOException("No extension for file: " + imgFile.getAbsolutePath());
	  String suffix = imgFile.getName().substring(pos + 1);
	  Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
	  while(iter.hasNext()) {
	    ImageReader reader = iter.next();
	    try {
	      ImageInputStream stream = new FileImageInputStream(imgFile);
	      reader.setInput(stream);
	      int width = reader.getWidth(reader.getMinIndex());
	      int height = reader.getHeight(reader.getMinIndex());
	      int[] table = {height,width};
	      return table;
	      
	    } catch (IOException e) {
	      //log.warn("Error reading: " + imgFile.getAbsolutePath(), e);
	    } finally {
	      reader.dispose();
	    }
	  }
	  
	  throw new IOException("Not a known image file: " + imgFile.getAbsolutePath());
	}
}