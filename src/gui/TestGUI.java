package gui;

public class TestGUI {
	public static void main(String[] args) {
		int [] [] matrice = new int [3][3];
		matrice[0][1] = 1;
		new Board(new MatriceBoard(matrice));

	}

}
