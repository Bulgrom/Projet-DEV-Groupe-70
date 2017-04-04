package gui;

public class MatriceBoard {
	int length;
	int height;
	int[][] matrice;
	private int xToMove = -1;
	private int yToMove = -1;
	private boolean needToMove = false;
	private int valueToMove = -1;
	

	public MatriceBoard(int length, int height) {
		this.length = length;
		this.height = height;
		matrice = new int[this.length][this.height];
		for (int j = 0; j < height; j++) {
			matrice[0][j] = 2;
			matrice[1][j] = 2;
			matrice[length-1][j] = 1;
			matrice[length-2][j] = 1;
		}
	}
	
	public void setXToMove( int x) {
		xToMove = x;
	}
	public void setYToMove( int y) {
		yToMove = y;
	}
	public int getXToMove () {
		return xToMove;
	}
	public int getYToMove() {
		return yToMove;
	}
	public boolean getNeedToMove () {
		return needToMove;
	}
	public void setNeedToMove (boolean x) {
		needToMove = x;
	}

	public void setValueToMove (int x) {
		this.valueToMove = x;
		}
	public int getValueToMove () {
		return valueToMove;
	}
	
	public void moveNumber(int xcoord, int ycoord) {
		if (needToMove) {
			matrice[xToMove][yToMove] = 0;
			matrice[xcoord][ycoord] = valueToMove;
			xToMove = -1;
			yToMove = -1;
			valueToMove = -1;
			needToMove = false;
		}

	}
}