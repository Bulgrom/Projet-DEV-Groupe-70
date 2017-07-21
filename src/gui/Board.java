package gui;

import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.util.Arrays;
import logger.*;
import map.*;
import party.*;
import javax.sound.sampled.*;
import menu.*;
import menu.Window;

public class Board extends JPanel implements ActionListener {

	/**
	 * 
	 */

	/* Dernieres modifs : modifié un peu actionperformed et controller */

	private static final long serialVersionUID = 1L;
	private Case listCase[][];
	private Map map;
	private int length;
	private int height;
	private int actionRequested;
	private map.Character charRequesting;
	private Controller controller;
	private PartyInterface partyInterface;
	private String partyName;
	private Window frame;

	public Board(PartyInterface partyInterface, Window w, String name) {
		this.map = partyInterface.getParty().getMap();
		this.partyInterface = partyInterface;
		this.partyName = name;
		this.frame = w;
		this.length = map.getDim()[0];
		this.height = map.getDim()[1];
		listCase = new Case[length][height];
		actionRequested = -1; // signifie absence d'action, 0 et plus sont des
								// actions
		charRequesting = null;
		controller = new Controller(listCase, partyInterface);
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < length; i++) {
				listCase[i][j] = new Case(i, j, map.getMap()[i][j]);
				listCase[i][j].addActionListener(this);

			}

		}
		initUI();
		fillUI();
		playMusic();
		listCase[controller.currentCharacter.getPosition().getCoord()[0]][controller.currentCharacter.getPosition()
				.getCoord()[1]].showAsCurrentPLayer();
		frame.setVisible(true);

	}

	public void initUI() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				map.saveMap("saveParty/" + partyName + "/"); // Not Sure about
																// the directory
				GameLogger.infoLogs("Carte sauvegardée");
				System.exit(0);
			}
		});
		this.setLayout(new GridLayout(length, height));

	}

	public void fillUI() {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < height; j++) {
				this.add(listCase[i][j]);
			}
		}

		frame.setContentPane(this);

	}

	/*
	 * public void playMusic() { try { AudioInputStream audioInputStream =
	 * AudioSystem.getAudioInputStream(new
	 * File("Music/Rivals of Aether - Blazing Hideout Theme.wav").
	 * getAbsoluteFile()); Clip clip = AudioSystem.getClip();
	 * clip.open(audioInputStream); clip.start(); } catch(Exception ex) {
	 * System.out.println("Error with playing sound."); ex.printStackTrace(); }
	 * }
	 */

	public void playMusic() {
		try {
			String audioFilePath = "Music/Rivals of Aether - Blazing Hideout Theme.wav";
			Thread soundThread = new Thread(new SoundPlayer(audioFilePath));
			soundThread.start();
		} catch (Exception ex) {
			System.out.println("Erreur lors de la lecture de la musique.");
			ex.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		String[] commandString = e.getActionCommand().split("[^0-9]");
		int i = Integer.parseInt(commandString[1]);
		int j = Integer.parseInt(commandString[3]);
		if (actionRequested == -1 && map.getMap()[i][j].getCharacter() == null) {
			System.out.println("Clic sur case vide");
		} else if (actionRequested == -1 && map.getMap()[i][j].getCharacter() != null) {
			// Premier clic sur un carré : on va demander ce qu'on veut faire
			// avec, si ya personne on fait rien
			this.charRequesting = map.getMap()[i][j].getCharacter();
			if (charRequesting.equals(controller.getCurrentCharacter())) {
				this.actionRequested = controller.askCommand();
				if (actionRequested == 0) {
					this.actionRequested = -1;
					this.charRequesting = null;
					this.update();
				} else {
					listCase[i][j].showAsSelected();
				}
				;
			}
		}

		else {
			// 2eme clic : on applique l'action enregistrée
			Square squareFin = map.getMap()[i][j];
			controller.applyCommand(squareFin, actionRequested);
			this.actionRequested = -1;
			this.charRequesting = null;
			this.update();

		}
	}

	public void showStats(map.Character chara) {
		System.out.println(chara.getName());
	}

	public void windowClosing(WindowEvent e) {
		map.saveMap("/saveMap");
	}

	public void update() {
		// Permet de mettre à jour l'affichage + déselectionne tout
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < height; j++) {
				listCase[i][j].chooseCharacterIcon();
				listCase[i][j].showUnselected();

			}
		}
		listCase[controller.currentCharacter.getPosition().getCoord()[0]][controller.currentCharacter.getPosition()
				.getCoord()[1]].showAsCurrentPLayer(); // CurrentPLayer est
														// maintenant entouré de
														// gris foncé
	}

}
