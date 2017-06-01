package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadLevel extends JPanel {
	
	static MenuBackground loadLevels;
	static Window w = ScreenMenu.w;
	
	private LoadLevel(){
		JLabel levels = new JLabel("Load a saved game");
		levels.setForeground(Color.red);
		levels.setFont(MenuButton.newFont.deriveFont((float) 55));
		
		JComboBox<String> levelSelection = new JComboBox<String>();
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
		
		loadLevels = new MenuBackground("img/darkforest.jpg");
		loadLevels.setLayout(new BoxLayout(loadLevels,BoxLayout.PAGE_AXIS));
		loadLevels.add(Box.createVerticalGlue());
		loadLevels.add(centerLevels);
		loadLevels.add(Box.createVerticalGlue());
		loadLevels.setOpaque(false);
	}
	
	class Load implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		    } 
	}
	
	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			w.setContentPane(ScreenMenu.getScreenMenu(w));
		    } 
	}
	
	class LevelSelection implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		    } 
	}
	
	private static LoadLevel screen = new LoadLevel();
	
	public static MenuBackground getLoadLevel(){
		return loadLevels;
	}
}