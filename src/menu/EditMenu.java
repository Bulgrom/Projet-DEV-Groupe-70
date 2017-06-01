package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import menu.LoadLevel.Back;
import menu.LoadLevel.Load;

public class EditMenu extends JPanel {
	
	Window w = ScreenMenu.w;
	static private MenuBackground editMenu;
	
	private EditMenu(){
		JLabel mapSize = new JLabel("Choose a Map size");
		mapSize.setForeground(Color.red);
		mapSize.setFont(MenuButton.newFont.deriveFont((float) 55));
		
		MenuButton create = new MenuButton("Create",Color.getHSBColor((float)0.14, 1, 1));
		create.addActionListener(new Create());
		MenuButton back = new MenuButton("Back",Color.getHSBColor((float)0.14, 1, 1));
		back.addActionListener(new Back());
		back.setMinimumSize(new Dimension(300,40));
		create.setMinimumSize(new Dimension(300,40));
		
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setLayout(new BoxLayout(buttons,BoxLayout.LINE_AXIS));
		buttons.setMaximumSize(new Dimension(545,50));
		buttons.add(back);
		buttons.add(Box.createRigidArea(new Dimension(50,0)));
		buttons.add(create);
		
		JPanel sizeContent = new JPanel();
		sizeContent.setLayout(new BoxLayout(sizeContent,BoxLayout.PAGE_AXIS));
		sizeContent.add(mapSize);
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center,BoxLayout.LINE_AXIS));
		center.add(Box.createHorizontalGlue());
		center.add(sizeContent);
		center.add(Box.createHorizontalGlue());
		center.setOpaque(false);
		
		editMenu = new MenuBackground("img/darkforest.jpg");
		editMenu.setLayout(new BoxLayout(editMenu,BoxLayout.PAGE_AXIS));
		editMenu.add(Box.createVerticalGlue());
		editMenu.add(center);
		editMenu.add(Box.createVerticalGlue());
		editMenu.setOpaque(false);
	}
	
	
	private static EditMenu edit = new EditMenu();
	
	public static MenuBackground getEditMenu(){
		return editMenu;
	}
	
	class Create implements ActionListener{
		public void actionPerformed(ActionEvent e) {

		    } 
	}
	
	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			w.setContentPane(ScreenMenu.getScreenMenu(w));
		    } 
	}
}
