import java.io.IOException;

public class TestMap {

	public static void main(String[] args) throws IOException {
		Map mapTest = new Map("D:/Documents/Java/test/test.txt");
		mapTest.setName("Save");
		System.out.println("Nom change");
		mapTest.save();
		System.out.println("Sauvegarde execute");

	}

}
