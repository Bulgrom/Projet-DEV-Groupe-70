package gui;
import java.awt.Dimension;
import javax.swing.border.*;
import java.awt.*;



import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class Board extends JPanel implements ActionListener{
	int length;
	int height;
	JFrame frame;
	Case listCase [][];
	MatriceBoard matriceBoard;
	public Board(int length, int height) {
		this.length = length;
		this.height = height;
		matriceBoard = new MatriceBoard(length, height);
		listCase = new Case [length] [height];
		for (int i = 0; i<length; i++) {
			for (int j = 0; j< height; j++) {
				listCase [i] [j] = new Case(i, j, !(matriceBoard.matrice[i][j] == 0));
				listCase[i][j].addActionListener(this);
				int [] coordinates = new int[2];
				coordinates [0] = i;
				coordinates [1] = j;
				listCase[i][j].setActionCommand(Arrays.toString(coordinates));
			}

	
		}
	    initUI();
	    fillUI();
	    frame.setVisible(true);
	}
	public void initUI () {
		frame = new JFrame();
		frame.setTitle("Jamy le retour");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		this.setLayout(new GridLayout(height,length));
		
		
	}
	public void fillUI () {
		for (int i =0; i< length; i++){
			for (int j = 0; j < height; j++) {
				this.add(listCase[i][j]);
			}
		}
		frame.add(this);
	} 

	
	public void actionPerformed (ActionEvent e) {
		String [] commandString = e.getActionCommand().split("[^0-9]");
		int i = Integer.parseInt(commandString[1]);
		int j = Integer.parseInt(commandString[3]);
		int xOneCoord = matriceBoard.xOneCoord;
		int yOneCoord = matriceBoard.yOneCoord;
		matriceBoard.moveOne(i, j);
		listCase[xOneCoord][yOneCoord].setIcon(null);
		listCase[i][j].setIcon(listCase[i][j].Icon);

		
	}
	
	public static void main (String [] args) {
		new Board(4,4);
		
		
	}
	
}


// TO DO : PRINT TUPLE, PUIS APPELER MOVEONE, BOUGER SUR MATRICEBOARD ET SUR BOARD
