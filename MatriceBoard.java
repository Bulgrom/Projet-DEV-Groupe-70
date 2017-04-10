package gui;
import map.*;


public class MatriceBoard {
	int length;
	int height;
	private Square[][] matrice;
	private int xToMove = -1;
	private int yToMove = -1;
	private boolean needToMove = false;
	private Square squareToMove = new Square("0");
	private Map map;
	

	public MatriceBoard(Map map) {
		this.matrice = map.getMap();
		this.length = this.matrice.length;
		this.height = this.matrice[0].length;
		this.map = map;
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

	public void setSquareToMove (Square x) {
		this.squareToMove = x;
		}
	public Square getValueToMove () {
		return squareToMove;
	}
	
	public void moveNumber(int xcoord, int ycoord) {
		if (needToMove) {
			matrice[xToMove][yToMove] = new Square("0");
			matrice[xcoord][ycoord] = squareToMove;
			xToMove = -1;
			yToMove = -1;
			squareToMove = new Square("0");
			needToMove = false;
		}
	}
	public void setMatrice(Square[][] matrice) {
		this.matrice = matrice;
	}
		
	public Square[][] getMatrice() {
		return this.matrice;
	}
	public Map getMap() {
		return map;
	}

}