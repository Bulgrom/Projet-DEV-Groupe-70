package gui;

import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.Arrays;
import logger.*;
import map.*;

public class Board extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Case listCase[][];
	private Map map;
	private int length;
	private int height;
	private int  actionRequested;
	private map.Character charRequesting;
	private Controller controller;
	
	
	public Board(Map map) {
		this.map = map;
		this.length = map.getDim()[0];
		this.height = map.getDim()[1];
		listCase = new Case[length][height];
		actionRequested = 0;
		charRequesting = null;
		controller = new Controller(listCase);
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < length; i++) {
				listCase[i][j] = new Case(i, j, map.getMap()[i][j]);
				listCase[i][j].addActionListener(this);

			}

		}
		initUI();
		fillUI();
		frame.setVisible(true);
	}

	public void initUI() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				map.saveMap("/saveMap"); // Not Sure about the directory
				GameLogger.infoLogs("Carte sauvegardée");
				System.exit(0);
			}
		});
		frame.setTitle("C'est pas sorcier : Civil War");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 500));
		this.setLayout(new GridLayout(length, height));
		
	}

	public void fillUI() {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < height; j++) {
				this.add(listCase[i][j]);
			}
		}

		frame.add(this);

	}

	public void actionPerformed(ActionEvent e) {
		String[] commandString = e.getActionCommand().split("[^0-9]");
		int i = Integer.parseInt(commandString[1]);
		int j = Integer.parseInt(commandString[3]); 
		if (actionRequested == 0 && map.getMap()[i][j].getCharacter() != null) {
			// Premier clic sur un carré : on va demander ce qu'on veut faire avec, si ya personne on fait rien
			this.charRequesting = map.getMap()[i][j].getCharacter();
			System.out.println(Arrays.deepToString(map.getMap()));
			this.actionRequested = controller.askCommand(charRequesting);
			listCase[i][j].showAsSelected();
		}
		else {
			// 2eme clic : on applique l'action enregistrée
			Square squareFin = map.getMap()[i][j];
			controller.applyCommand(charRequesting, squareFin, actionRequested);
			this.actionRequested = 0;
			this.charRequesting = null;
			this.update();

		}
	}

	

	public void windowClosing(WindowEvent e) {
		map.saveMap("/saveMap");
	}

	
	public void update() {
		//Permet de mettre à jour l'affichage + déselectionne tout
		for (int i = 0; i< length; i++) {
			for (int j = 0; j < height; j++) {
				listCase[i][j].chooseCharacterIcon();
				listCase[i][j].showUnselected();
				
			}
		}
	}
	
}
