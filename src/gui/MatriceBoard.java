package gui;

import java.util.Arrays;

public class MatriceBoard {
	int length;
	int height;
	int [] [] matrice;
	int xOneCoord;
	int yOneCoord;
	public MatriceBoard(int length, int height) {
		this.length = length;
		this.height = height;
		matrice = new int [this.length] [this.height];
		matrice[0][0] = 1;
		xOneCoord = 0;
		yOneCoord = 0;
	}
	
	public void moveOne(int xcoord, int ycoord) {
		matrice[xOneCoord][yOneCoord] = 0;
		matrice[xcoord][ycoord] = 1;
		xOneCoord = xcoord;
		yOneCoord = ycoord;

	}


}