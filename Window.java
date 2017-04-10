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
	int i = 0;
	
	Background screenMenu;
	
	
	
	public Window() throws InterruptedException {
		
		
		resume.addActionListener(new Resume());
		newGame.addActionListener(new NewGame());
		levelSelect.addActionListener(new LevelSelect());
		options.addActionListener(new Options());
		quit.addActionListener(new Quit());
		
		JPanel screen = new JPanel();
		screen.setLayout(new CardLayout());
		
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
		
		JPanel centerMenu = new JPanel();
		centerMenu.setLayout(new BoxLayout(centerMenu,BoxLayout.LINE_AXIS));
		centerMenu.add(Box.createVerticalGlue());
		centerMenu.add(content);
		centerMenu.add(Box.createVerticalGlue());
		centerMenu.setOpaque(false);
		

			screenMenu = new Background("forest.jpg");
			screenMenu.setOpaque(false);
			screenMenu.setLayout(new BoxLayout(screenMenu,BoxLayout.PAGE_AXIS));
			screenMenu.add(Box.createHorizontalGlue());
			screenMenu.add(centerMenu);
			screenMenu.add(Box.createHorizontalGlue());
			
			
			this.setContentPane(screenMenu);
			this.setVisible(true);

	}
	class Resume implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.out.print("Resume");
			Window.this.setContentPane(new Background("darkforest.jpg"));
			Window.this.setVisible(true);
		}
	}
	class NewGame implements ActionListener {
		public void actionPerformed(ActionEvent arg0){

		}
	}	
	class LevelSelect implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			
			LevelButton levelButton = new LevelButton("levelButton","Level 1","BlackBackground.jpg","test");
			levelButton.setOpaque(false);
			JPanel comeBack = new JPanel();
			comeBack.setPreferredSize(new Dimension(0,30));
			JButton rightArrow = new JButton();
			JButton leftArrow = new JButton();
			JPanel pageLevel = new JPanel();
			pageLevel.setPreferredSize(new Dimension(0,20));
			
			JPanel levelContent = new JPanel(new BorderLayout(5,5));
			levelContent.setMaximumSize(new Dimension(545,363));
			levelContent.setOpaque(false);
			levelContent.add(comeBack,BorderLayout.NORTH);
			levelContent.add(rightArrow,BorderLayout.EAST);
			levelContent.add(leftArrow,BorderLayout.WEST);
			levelContent.add(pageLevel,BorderLayout.SOUTH);
			levelContent.add(levelButton,BorderLayout.CENTER);
			
			JPanel centerLevels = new JPanel();
			centerLevels.setLayout(new BoxLayout(centerLevels,BoxLayout.PAGE_AXIS));
			centerLevels.add(Box.createHorizontalGlue());
			centerLevels.add(levelContent);
			centerLevels.add(Box.createHorizontalGlue());
			centerLevels.setOpaque(false);
			
			Background screenLevels = new Background("longforest.jpg");
			screenLevels.setLayout(new BoxLayout(screenLevels,BoxLayout.LINE_AXIS));
			screenLevels.add(Box.createVerticalGlue());
			screenLevels.add(centerLevels);
			screenLevels.add(Box.createVerticalGlue());
			screenLevels.setOpaque(false);
			
			Window.this.setContentPane(screenLevels);
			Window.this.setVisible(true);
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