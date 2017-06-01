package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadLevel extends JPanel {
	
	static MenuBackground loadLevels;
	Window w = ScreenMenu.w;
	private String[] infoMap;
	private String[] infoTurns;
	private String[] infoSize;
	private String[] infoDate;
	
	private JLabel infoTurnsDisplayed;
	private JLabel infoSizeDisplayed;
	private JLabel infoMapDisplayed;
	private JLabel infoDateDisplayed;

	File directory = new File("saveParty");
	String[] saves = directory.list();
	JComboBox<String> levelSelection = new JComboBox<String>(saves);
	
	private LoadLevel(){
		JLabel levels = new JLabel("Load a saved game");
		levels.setForeground(Color.red);
		levels.setFont(MenuButton.newFont.deriveFont((float) 55));
		
		JPanel name = new JPanel();
		name.setMaximumSize(new Dimension(500,60));
		name.add(levels);
		name.setOpaque(false);
		
		
		levelSelection.setMaximumSize(new Dimension(660,40));
		levelSelection.addActionListener(new LevelSelection());
		
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
		infos.setLayout(new BoxLayout(infos,BoxLayout.PAGE_AXIS));
		infos.setMaximumSize(new Dimension(660,200));
		infos.setOpaque(false);
		
		JLabel infoMapLabel = new JLabel(" Map");
		infoMapLabel.setForeground(Color.white);
		infoMapLabel.setFont(MenuButton.font2.deriveFont((float) 45));
		
		JLabel infoTurnsLabel = new JLabel(" Number of turns");
		infoTurnsLabel.setForeground(Color.white);
		infoTurnsLabel.setFont(MenuButton.font2.deriveFont((float) 45));
		
		JLabel infoSizeLabel = new JLabel(" Size");
		infoSizeLabel.setForeground(Color.white);
		infoSizeLabel.setFont(MenuButton.font2.deriveFont((float) 45));
		
		JLabel infoDateLabel = new JLabel(" Date");
		infoDateLabel.setForeground(Color.white);
		infoDateLabel.setFont(MenuButton.font2.deriveFont((float) 45));
		
		int numberParty = saves.length;
		infoMap = new String[numberParty];
		infoTurns = new String[numberParty];
		infoSize = new String[numberParty];
		infoDate = new String[numberParty];
		int iter = 0;
		for (String party : saves){
			try{
				BufferedReader reader = new BufferedReader(new FileReader(new File(directory+"/"+party+"/Map.txt")));
				infoMap[iter] = "  "+reader.readLine()+"  ";
				infoSize[iter] = "  "+reader.readLine()+"  ";
				reader = new BufferedReader(new FileReader(new File(directory+"/"+party+"/data.txt")));
				infoDate[iter] = "  "+reader.readLine();
				infoTurns[iter] = "  "+reader.readLine()+"  ";
			} catch (Exception e){
				e.printStackTrace();
				infoMap[iter] = "N/A";
				infoSize[iter] = "N/A";
				infoTurns[iter] = "N/A";
				infoDate[iter] = "N/A";
			} finally {
				iter++;
			}
		}
		infoMapDisplayed = new JLabel(infoMap[0]);
		infoMapDisplayed.setFont(MenuButton.font2.deriveFont((float) 35));
		infoMapDisplayed.setForeground(Color.white);
		
		infoSizeDisplayed = new JLabel(infoSize[0]);
		infoSizeDisplayed.setFont(MenuButton.font2.deriveFont((float) 35));
		infoSizeDisplayed.setForeground(Color.white);
		
		infoTurnsDisplayed = new JLabel(infoTurns[0]);
		infoTurnsDisplayed.setFont(MenuButton.font2.deriveFont((float) 35));
		infoTurnsDisplayed.setForeground(Color.white);
		
		infoDateDisplayed = new JLabel(infoDate[0]);
		infoDateDisplayed.setFont(MenuButton.font2.deriveFont((float) 35));
		infoDateDisplayed.setForeground(Color.white);
		
		JPanel infos1 = new JPanel();
		infos1.setLayout(new BoxLayout(infos1,BoxLayout.LINE_AXIS));
		infos1.setMaximumSize(new Dimension(600,40));
		infos1.add(infoMapLabel);
		infos1.add(Box.createRigidArea(new Dimension(160,0)));
		infos1.add(infoMapDisplayed);
		infos1.setOpaque(false);
		
		JPanel infos2 = new JPanel();
		infos2.setLayout(new BoxLayout(infos2,BoxLayout.LINE_AXIS));
		infos2.setMaximumSize(new Dimension(600,40));
		infos2.add(infoSizeLabel);
		infos2.add(Box.createRigidArea(new Dimension(160,0)));
		infos2.add(infoSizeDisplayed);
		infos2.setOpaque(false);

		JPanel infos3 = new JPanel();
		infos3.setLayout(new BoxLayout(infos3,BoxLayout.LINE_AXIS));
		infos3.setMaximumSize(new Dimension(600,40));
		infos3.add(infoTurnsLabel);
		infos3.add(Box.createRigidArea(new Dimension(50,0)));
		infos3.add(infoTurnsDisplayed);
		infos3.setOpaque(false);
		
		JPanel infos4 = new JPanel();
		infos4.setLayout(new BoxLayout(infos4,BoxLayout.LINE_AXIS));
		infos4.setMaximumSize(new Dimension(600,40));
		infos4.add(infoDateLabel);
		infos4.add(Box.createRigidArea(new Dimension(150,0)));
		infos4.add(infoDateDisplayed);
		infos4.setOpaque(false);

		infos.add(Box.createRigidArea(new Dimension(0,15)));
		infos.add(infos1);
		infos.add(infos2);
		infos.add(infos3);
		infos.add(infos4);

		JPanel levelContent = new JPanel();
		levelContent.setLayout(new BoxLayout(levelContent,BoxLayout.PAGE_AXIS));
		levelContent.add(name);
		levelContent.add(Box.createRigidArea(new Dimension(0,20)));
		levelContent.add(levelSelection);
		levelContent.add(Box.createRigidArea(new Dimension(0,10)));
		levelContent.add(infos);
		
		levelContent.add(buttons);
		levelContent.add(Box.createRigidArea(new Dimension(0,20)));

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
			infoMapDisplayed.setText(infoMap[levelSelection.getSelectedIndex()]);
			infoTurnsDisplayed.setText(infoTurns[levelSelection.getSelectedIndex()]);
			infoSizeDisplayed.setText(infoSize[levelSelection.getSelectedIndex()]);
			infoDateDisplayed.setText(infoDate[levelSelection.getSelectedIndex()]);
		    } 
	}
	
	private static LoadLevel screen = new LoadLevel();
	
	public static MenuBackground getLoadLevel(){
		return loadLevels;
	}
}