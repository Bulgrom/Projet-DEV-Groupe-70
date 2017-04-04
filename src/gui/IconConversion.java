package gui;

import javax.swing.*;

public class IconConversion {
	public ImageIcon getImageIcon (IconEnum param) {
		if (param.equals(IconEnum.JAMY)) 
			return new ImageIcon("src/gui/jamy.png");
		else return new ImageIcon("src/gui/fred.png");
		
			
		
	}



}
