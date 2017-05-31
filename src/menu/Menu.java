package menu;

import java.awt.Dimension;

import javax.swing.JFrame;


public class Menu {
	public static void main(String[] args){
			Window window = new Window();
			
			window.setTitle("Game");
			window.setSize(1000, 600);
			window.setMinimumSize(new Dimension(600,438));
			window.setLocationRelativeTo(null);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);
		
	}       
}
