package fr.game;

import java.awt.Color; 

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class Window extends JFrame {
  
	
	public Window() throws InterruptedException {
		
		int i = 0;
		int height;
		int width;
		
		JButton resume = new JButton("Resume");	
		JButton newGame = new JButton("New Game");
		JButton levelSelect = new JButton("Select a level");

		Background[] backgrounds = {new Background("forest.jpg"), 
				new Background("longforest.jpg"), new Background ("darkforest.jpg")};
		
		resume.setMaximumSize(new Dimension(500,40));
		newGame.setMaximumSize(new Dimension(500,40));
		levelSelect.setMaximumSize(new Dimension(500,40));
		
		this.setTitle("Game");
		this.setSize(1000, 600);
		this.setMinimumSize(new Dimension(600,438));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		height = this.getHeight();
		width = this.getWidth();
		System.out.print(width);
		
		while(true){

			
			Background currentBackground = backgrounds[i%3];
			currentBackground.setLayout(new BoxLayout(currentBackground,BoxLayout.PAGE_AXIS));

			currentBackground.add(Box.createVerticalGlue());
			currentBackground.add(resume);
			currentBackground.add(newGame);
			currentBackground.add(Box.createRigidArea(new Dimension((width/2)-250,10)));
			currentBackground.add(levelSelect);
			currentBackground.add(Box.createVerticalGlue());
			this.setContentPane(currentBackground);;

			this.setVisible(true);
			Thread.sleep(7000);
			i++;
		}
  }

}