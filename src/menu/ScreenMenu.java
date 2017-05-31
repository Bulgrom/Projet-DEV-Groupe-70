package menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ScreenMenu extends JPanel{
	
	Color yellow = Color.getHSBColor((float)0.14, 1, 1);	
	MenuButton startNewGame = new MenuButton("New Game", yellow);
	MenuButton loadLevel = new MenuButton("Load a level", yellow);
	MenuButton options = new MenuButton ("Options", yellow);
	MenuButton quit = new MenuButton("Quit", yellow);
	static Background screen;
	Background screenLevels;
	static Window w;
	
	private ScreenMenu(){
		startNewGame.addActionListener(new StartNewGame());
		loadLevel.addActionListener(new LevelSelect());
		options.addActionListener(new Options());
		quit.addActionListener(new Quit());
		
		JPanel content = new JPanel(); 
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS));
		content.add(startNewGame);
		content.add(Box.createRigidArea(new Dimension(0,40)));
		content.add(loadLevel);
		content.add(Box.createRigidArea(new Dimension(0,40)));
		content.add(options);
		content.add(Box.createRigidArea(new Dimension(0,40)));
		content.add(quit);
		
		JPanel centerMenu = new JPanel();
		centerMenu.setLayout(new BoxLayout(centerMenu,BoxLayout.LINE_AXIS));
		centerMenu.add(Box.createVerticalGlue());
		centerMenu.add(content);
		centerMenu.add(Box.createVerticalGlue());
		centerMenu.setOpaque(false);
		
		screen = new Background("img/forest.jpg");
		screen.setOpaque(false);
		screen.setLayout(new BoxLayout(screen,BoxLayout.PAGE_AXIS));
		screen.add(Box.createHorizontalGlue());
		screen.add(centerMenu);
		screen.add(Box.createHorizontalGlue());
		
		
	}
	
	private static ScreenMenu screenMenu = new ScreenMenu();
	
	public static Background getScreenMenu(Window window){
		w = window;
		return screen;
	}
	
	class StartNewGame implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			w.setContentPane(NewGame.getNewGame());
			w.setVisible(true);
		}
	}	
	
	class LevelSelect implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			w.setContentPane(LoadLevel.getLoadLevel());
			w.setVisible(true);
		}
	}

	class Options implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.out.print("Options");
			ComingSoon tmp_screen = new ComingSoon();
		}
	}
	class Quit implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.exit(0);
		}
	}

}
