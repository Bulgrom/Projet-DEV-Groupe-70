package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.stream.IntStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class EditMenu extends JPanel {
	
	Window w = ScreenMenu.w;
	static private MenuBackground editMenu;
	private int mapHeight = 5;
	private int mapLenght = 5;
	private String mapName;
	
	private JComboBox<Integer> lengthBox;
	private JComboBox<Integer> heightBox;
	private JTextField mapNameField;
	
	private EditMenu(){
		JLabel mapSize = new JLabel("Create a Map : size and name");
		mapSize.setForeground(Color.red);
		mapSize.setFont(MenuButton.newFont.deriveFont((float) 55));
		
		JPanel name = new JPanel();
		name.setMaximumSize(new Dimension(500,60));
		name.add(mapSize);
		name.setOpaque(false);
		
		JLabel heightLabel = new JLabel("Height");
		heightLabel.setForeground(Color.white);
		heightLabel.setFont(MenuButton.newFont.deriveFont((float) 45));
		
		JLabel lenghtLabel = new JLabel("Lenght");
		lenghtLabel.setForeground(Color.white);
		lenghtLabel.setFont(MenuButton.newFont.deriveFont((float) 45));
		
		JPanel dimensions = new JPanel();
		dimensions.setMaximumSize(new Dimension(500,60));
		dimensions.add(heightLabel);
		dimensions.add(Box.createRigidArea(new Dimension(200,0)));
		dimensions.add(lenghtLabel);
		dimensions.setOpaque(false);
		
		mapNameField = new JTextField();
		mapNameField.setPreferredSize(new Dimension(500,40));
		mapNameField.setForeground(Color.white);
		mapNameField.setBackground(Color.black);
		mapNameField.setFont(MenuButton.newFont.deriveFont((float) 35));
		
		JLabel fileName = new JLabel("Name");
		fileName.setForeground(Color.white);
		fileName.setFont(MenuButton.newFont.deriveFont((float) 45));
		
		JPanel mapName = new JPanel();
		mapName.setMaximumSize(new Dimension (600,100));
		mapName.add(fileName);
		mapName.add(mapNameField);
		mapName.setOpaque(false);
		
		Integer[] tab = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		heightBox = new JComboBox<>(tab);
		heightBox.setPreferredSize(new Dimension(250,40));
		heightBox.setSelectedItem(5);
		heightBox.setFont(MenuButton.newFont.deriveFont((float) 25));
		heightBox.setBackground(Color.black);
		heightBox.setForeground(Color.white);

		
		lengthBox = new JComboBox<>(tab);
		lengthBox.setPreferredSize(new Dimension(250,40));
		lengthBox.setSelectedItem(5);
		lengthBox.setFont(MenuButton.newFont.deriveFont((float) 25));
		lengthBox.setBackground(Color.black);
		lengthBox.setForeground(Color.white);
		
		JPanel size = new JPanel();
		size.setOpaque(false);
		size.setLayout(new BoxLayout(size,BoxLayout.LINE_AXIS));
		size.setMaximumSize(new Dimension(545,30));
		size.add(Box.createHorizontalGlue());
		size.add(heightBox);
		size.add(Box.createRigidArea(new Dimension(50,0)));
		size.add(lengthBox);
		size.add(Box.createHorizontalGlue());
		
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
		sizeContent.setPreferredSize(new Dimension(540,400));
		sizeContent.setLayout(new BoxLayout(sizeContent,BoxLayout.PAGE_AXIS));
		sizeContent.add(name);
		sizeContent.add(Box.createRigidArea(new Dimension(0,10)));
		sizeContent.add(dimensions);
		sizeContent.add(size);
		sizeContent.add(Box.createRigidArea(new Dimension(0,30)));
		sizeContent.add(mapName);
		sizeContent.add(Box.createRigidArea(new Dimension(0,30)));
		sizeContent.add(buttons);
		sizeContent.setOpaque(false);
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center,BoxLayout.LINE_AXIS));
		center.add(Box.createHorizontalGlue());
		center.add(sizeContent);
		center.add(Box.createHorizontalGlue());
		center.setOpaque(false);
		
		editMenu = new MenuBackground("img/sea.jpg");
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
			mapHeight = (int) heightBox.getSelectedItem();
			mapLenght = (int) lengthBox.getSelectedItem();
			mapName = mapNameField.getText();
		} 
	}
	
	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			w.setContentPane(ScreenMenu.getScreenMenu(w));
		} 
	}
	
//	class Height implements ActionListener{
//		public void actionPerformed(ActionEvent e){
//			
//		}
//	}
//	
//	class Length implements ActionListener{
//		public void actionPerformed(ActionEvent e){
//			
//		}
//	}
}
