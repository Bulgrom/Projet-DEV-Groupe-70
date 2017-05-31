package menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewGame extends JPanel {
	
	static Background newGame;
	static Window w = ScreenMenu.w;
	
	private NewGame(){
		JLabel levels = new JLabel("Load a saved game");
		levels.setForeground(Color.red);
		levels.setFont(MenuButton.newFont.deriveFont((float) 55));
		
		JComboBox levelSelection = new JComboBox();
		levelSelection.setMaximumSize(new Dimension(660,40));
		
		MenuButton load = new MenuButton("Load",Color.getHSBColor((float)0.14, 1, 1));
		load.addActionListener(new Load());
		MenuButton back = new MenuButton("Back",Color.getHSBColor((float)0.14, 1, 1));
		back.addActionListener(new Back());
		back.setMinimumSize(new Dimension(300,40));
		load.setMinimumSize(new Dimension(300,40));
		
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setLayout(new BoxLayout(buttons,BoxLayout.LINE_AXIS));
		buttons.setMaximumSize(new Dimension(545,50));
		buttons.add(back);
		buttons.add(Box.createRigidArea(new Dimension(50,0)));
		buttons.add(load);

		JPanel infos = new JPanel();
		infos.setMaximumSize(new Dimension(660,200));
		
		JPanel levelContent = new JPanel();
		levelContent.setLayout(new BoxLayout(levelContent,BoxLayout.PAGE_AXIS));
		levelContent.add(levels);
		levelContent.add(Box.createRigidArea(new Dimension(0,20)));
		levelContent.add(levelSelection);
		levelContent.add(Box.createRigidArea(new Dimension(0,10)));
		levelContent.add(infos);
		levelContent.add(buttons);

		levelContent.setPreferredSize(new Dimension(540,400));
		levelContent.setOpaque(false);

		JPanel centerLevels = new JPanel();
		centerLevels.setLayout(new BoxLayout(centerLevels,BoxLayout.LINE_AXIS));
		centerLevels.add(Box.createHorizontalGlue());
		centerLevels.add(levelContent);
		centerLevels.add(Box.createHorizontalGlue());
		centerLevels.setOpaque(false);
		
		newGame = new Background("img/longforest.jpg");
		newGame.setLayout(new BoxLayout(newGame,BoxLayout.PAGE_AXIS));
		newGame.add(Box.createVerticalGlue());
		newGame.add(centerLevels);
		newGame.add(Box.createVerticalGlue());
		newGame.setOpaque(false);
	}
	
	class Load implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		    } 
	}
	
	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			w.setContentPane(ScreenMenu.screen);
		    } 
	}
	
	class LevelSelection implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		    } 
	}
	
	private static NewGame screen = new NewGame();
	
	public static Background getNewGame(){
		return newGame;
	}
}