package gui;

public class MatriceBoard {
	int length;
	int height;
	private int[][] matrice;
	private int xToMove = -1;
	private int yToMove = -1;
	private boolean needToMove = false;
	private int valueToMove = -1;
	

	public MatriceBoard(int[][] matrice) {
		
		this.length = matrice.length;
		this.height = matrice[0].length;
		this.matrice = matrice;
		
		}
	
	
	public void setXToMove( int x) {
		xToMove = x;
	}
	public void setYToMove( int y) {
		yToMove = y;
	}
	
	public int[][] zeroMatrice(int length, int height) {
		int [][] resultMatrice = new int[length] [height];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j<height; j++) {
				resultMatrice[i][j] = 0;
			}
		}
		return resultMatrice;
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
	public void setMatrice(int[][] matrice) {
		this.matrice = matrice;
	}
		
	public int[][] getMatrice() {
		return this.matrice;
	}
}