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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
  
	MenuButton resume = new MenuButton("Resume");	
	MenuButton newGame = new MenuButton("New Game");
	MenuButton levelSelect = new MenuButton("Select a level");
	MenuButton options = new MenuButton ("Options");
	MenuButton quit = new MenuButton("Quit");
	
	public Window() throws InterruptedException {
		int i = 0;

		resume.addActionListener(new Resume());
		newGame.addActionListener(new NewGame());
		levelSelect.addActionListener(new LevelSelect());
		options.addActionListener(new Options());
		quit.addActionListener(new Quit());

		resume.setMaximumSize(new Dimension(500,40));
		newGame.setMaximumSize(new Dimension(500,40));
		levelSelect.setMaximumSize(new Dimension(500,40));
		options.setMaximumSize(new Dimension(500,40));
		quit.setMaximumSize(new Dimension(500,40));
		
		JPanel content = new JPanel(); 
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS));
		content.add(resume);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(newGame);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(levelSelect);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(options);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(quit);
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BoxLayout(centerPane,BoxLayout.LINE_AXIS));
		centerPane.add(Box.createVerticalGlue());
		centerPane.add(content);
		centerPane.add(Box.createVerticalGlue());
		centerPane.setOpaque(false);

		Background[] backgrounds = {new Background("forest.jpg"), new Background("longforest.jpg"), new Background ("darkforest.jpg")};
		
		this.setTitle("Game");
		this.setSize(1000, 600);
		this.setMinimumSize(new Dimension(600,438));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while(true){

			Background currentBackground = backgrounds[i%3];
			currentBackground.setLayout(new BoxLayout(currentBackground,BoxLayout.PAGE_AXIS));
			currentBackground.add(Box.createHorizontalGlue());
			currentBackground.add(centerPane);
			currentBackground.add(Box.createHorizontalGlue());

			this.setContentPane(currentBackground);;
			this.setVisible(true);
			Thread.sleep(7000);
			i++; 
			//pour faire varier l'image de fond
		}
	}
	class Resume implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.out.print("Resume");

		}
	}
	class NewGame implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.out.print("New Game !");
		}
	}	
	class LevelSelect implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.out.print("Choosing Level");
		}
	}
	class Options implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.out.print("Options");
		}
	}
	class Quit implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.exit(0);
		}
	}
}