package map ;

import static org.junit.Assert.*;

import java.io.IOException;
import ability.*;

import org.junit.Before;
import org.junit.Test;

public class MapTest {

	private final static String backSpace = System.lineSeparator();
	private Map m;
	private Character pers1;
	private Character pers2;
	
	@Before
	public void before(){
		m = new Map(4,5);
		m.setName("Test");
		System.out.println(m);
		
		pers1 = new Character("pers1", 1, 1000, 5, 6, 80, 30, 10);
		pers2 = new Character("pers2", 2, 1000, 5, 6, 50, 100, 20);
		System.out.println(pers1);
		System.out.println(pers2);
		
		Ability[] atk = new Ability[1];
		atk[0] = new Punch(50);
		pers1.setAbilities(atk);
		//pers2.setAbilities(atk);
		
		System.out.println("Fin du before");
	}
	
	@Test
	public void testAttack() {
		
		m.getSquare(0,0).setCharacter(pers1);
		m.getSquare(3,4).setCharacter(pers2);
		
		System.out.println(m);
		System.out.println("");
		
		
		System.out.println(pers2.getPV());
		
		pers1.getAbility(0).use(m.getMap()[3][4]);
		System.out.println(pers2.getPV());
		
		pers1.getAbility(0).use(m.getMap()[3][3]);
		System.out.println(pers2.getPV());
		
	}
	
	@Test
	public void testSaveMap() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		m.getSquare(0,1).setBackground(new Background(2));
		m.getSquare(0, 2).setElement(new Element(1));
		m.getSquare(1,0).setBackground(new Background(0));
		m.getSquare(1,0).setElement(new Element(2));
		System.out.println(m);
		
		m.saveMap("mapSave/Test/");
		System.out.println("Map sauvegarde");
		
		Map m2 = new Map("mapSave/Test/");
		System.out.println("Map Chargee" + backSpace);
		
		assertTrue(m.getName().equals(m2.getName()));
		
		System.out.println(m2);
		assertTrue(m2.getSquare(0,0).equals(m.getSquare(0,0)));
		
		assertTrue(m2.equals(m));

	}

	
	@Test
	public void testSaveCharacter() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		pers1.saveCharacterWithName("characterSave/");
		System.out.println("pers1 sauvegarde avec nom");
		
		pers2.saveCharacterWithName("characterSave/");
		System.out.println("pers2 sauvegarde avec nom");
		
		pers2.saveCharacterWithId("characterSave/");
		System.out.println("pers2 sauvegarde avec Id");
		
		Character c = new Character("characterSave/pers1.txt");
		System.out.println("Character Chargee");
		
		assertTrue(c.equals(pers1));
		
		Character c2 = new Character("characterSave/pers2.txt");
		System.out.println("Character Chargee");
	}
	

	
	
	
}
