package gui;

import java.awt.Dimension;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class Board extends JPanel implements ActionListener {
	int length;
	int height;
	JFrame frame;
	Case listCase[][];
	MatriceBoard matriceBoard;

	public Board(int length, int height) {
		this.length = length;
		this.height = height;
		matriceBoard = new MatriceBoard(length, height);
		listCase = new Case[length][height];
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < length; i++) {
				listCase[i][j] = new Case(i, j, matriceBoard.matrice[i][j]);
				listCase[i][j].addActionListener(this);
				int[] coordinates = new int[2];
				coordinates[0] = i;
				coordinates[1] = j;
				listCase[i][j].setActionCommand(Arrays.toString(coordinates));
			}

		}
		initUI();
		fillUI();
		frame.setVisible(true);
	}

	public void initUI() {
		frame = new JFrame();
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
		if (matriceBoard.matrice[i][j] != 0) {
			if (matriceBoard.getNeedToMove()){
				matriceBoard.setNeedToMove(false);
			}
			else {
				matriceBoard.setXToMove(i);
				matriceBoard.setYToMove(j);
				matriceBoard.setNeedToMove(true);
				matriceBoard.setValueToMove(matriceBoard.matrice[i][j]);
			}
		
		}
		else {
			if (matriceBoard.getNeedToMove()) {
				listCase[matriceBoard.getXToMove()][matriceBoard.getYToMove()].setIcon(null);	
				matriceBoard.moveNumber(i, j);
				listCase[i][j].chooseIcon(matriceBoard.matrice[i][j]);

			}
			else {
				
			}
		}


	}

	public static void main(String[] args) {
		new Board(8, 8);

	}

}


//TO DO: FIX LE COUP DU "LES MATRICES SONT PAS DANS LE BON SENS XD"