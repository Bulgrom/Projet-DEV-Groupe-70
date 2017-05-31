package map ;

import static org.junit.Assert.*;

import java.io.IOException;
import ability.*;
import ability.damageAbility.*;
import element.*;

import org.junit.Before;
import org.junit.Test;

public class MapTest {

	private final static String backSpace = System.lineSeparator();
	private Map m;
	private Character pers1;
	private Character pers2;
	private Ability[] atk;
	
	@Before
	public void before(){
		System.out.println(backSpace + "Nouveau Test");
		m = new Map(4,5);
		m.setName("Test");
		System.out.println(m);
		
		pers1 = new Character("pers1", 1, 1000, 3, 6, 80, 30, 10);
		pers2 = new Character("pers2", 2, 1000, 5, 6, 50, 100, 20);
		System.out.println(pers1);
		System.out.println(pers2);
		
		atk = new Ability[2];
		atk[0] = new Punch(50);
		atk[1] = new BasicArrow(50, 4);
		pers1.setAbilities(atk);
		//pers2.setAbilities(atk);
		
		System.out.println("Fin du before" + backSpace);
	}
	
	@Test
	public void testPunch() {
		System.out.println("testPunch");
		
		m.getSquare(0,0).setCharacter(pers1);
		m.getSquare(0,1).setCharacter(pers2);
		
		System.out.println(m);
		System.out.println("");
		
		
		System.out.println(pers2.getPV());
		assertTrue(pers2.getPV() == 1000);
		
		pers1.useAbility(pers1.getAbility(0), m.getSquare(0,1));
		assertTrue(pers2.getPV() == 950);
		System.out.println(pers2.getPV());
		
		pers1.useAbility(new Punch(50), m.getSquare(0,1));
		assertTrue(pers2.getPV() == 950);
		System.out.println(pers2.getPV());
		
		pers1.useAbility(pers1.getAbility(0), m.getSquare(0,2));
		assertTrue(pers2.getPV() == 950);
		System.out.println(pers2.getPV());
		
		pers1.useAbility(pers1.getAbility(0), m.getSquare(1,0));
		assertTrue(pers2.getPV() == 950);
		System.out.println(pers2.getPV());
		
	}
	
	@Test
	public void testBasicArrow(){
		System.out.println("testBasicArrow");
		
		m.getSquare(0, 0).setCharacter(pers2);
		m.getSquare(0, 1).setCharacter(pers2);
		m.getSquare(1, 3).setCharacter(pers2);
		m.getSquare(2, 1).setCharacter(pers2);
		m.getSquare(2, 2).setCharacter(pers2);
		m.getSquare(3, 2).setCharacter(pers2);
		m.getSquare(3, 4).setCharacter(pers2);
		m.getSquare(1, 4).setCharacter(pers1);
		m.getSquare(2, 3).setElement((Element) new Wall());
		m.getSquare(2, 4).setElement(new SmallRock());
		
		System.out.println(m);
		System.out.println("");
		
		
		System.out.println(pers2.getPV());
		assertTrue(pers2.getPV() == 1000);
		
		pers1.useAbility(pers1.getAbility(1), m.getSquare(0,0));
		assertTrue(pers2.getPV() == 1000);
		System.out.println(pers2.getPV());
		
		pers1.useAbility(pers1.getAbility(1), m.getSquare(0,1));
		assertTrue(pers2.getPV() == 950);
		System.out.println(pers2.getPV());
		
		pers1.useAbility(pers1.getAbility(1), m.getSquare(1,3));
		assertTrue(pers2.getPV() == 900);
		System.out.println(pers2.getPV());
		
		pers1.useAbility(pers1.getAbility(1), m.getSquare(2,1));
		assertTrue(pers2.getPV() == 900);
		System.out.println(pers2.getPV());
		
		pers1.useAbility(pers1.getAbility(1), m.getSquare(2,2));
		assertTrue(pers2.getPV() == 900);
		System.out.println(pers2.getPV());
		
		pers1.useAbility(pers1.getAbility(1), m.getSquare(3,2));
		assertTrue(pers2.getPV() == 900);
		System.out.println(pers2.getPV());
		
		pers1.useAbility(pers1.getAbility(1), m.getSquare(3,4));
		assertTrue(pers2.getPV() == 850);
		System.out.println(pers2.getPV());
		
	}
	
	@Test
	public void testSaveMap() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		System.out.println("TestSaveMap");
		
		m.getSquare(0,1).setBackground(Background.SAND);
		m.getSquare(0, 2).setElement(new Wall());
		m.getSquare(0, 2).getElement().setId(1);
		
		m.getSquare(1,0).setBackground(Background.WATER);
		m.getSquare(1,0).setElement(new SmallRock());
		m.getSquare(1,0).getElement().setId(2);
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
		System.out.println("TestSaveCharacter");
		
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
		
		assertTrue(c2.equals(pers2));
	}
	

	@Test
	public void testMoveCharacter(){
		System.out.println("testMoveCharacter");
		
		m.getSquare(0, 0).setCharacter(pers1);
		m.getSquare(3, 4).setCharacter(pers2);
		System.out.println(m);
		
		assertFalse(pers1.checkMove(m.getSquare(0, 4)));
		pers1.move(m.getSquare(0, 4));
		System.out.println(m);
		
		
		assertTrue(pers1.checkMove(m.getSquare(1, 2)));
		pers1.move(m.getSquare(1, 2));
		System.out.println(m);
		
		pers1.move(m.getSquare(3, 2));
		
		assertFalse(pers1.checkMove(m.getSquare(3, 4)));
		pers1.move(m.getSquare(3, 4));
		
		System.out.println(m);
		
		
		
	}
	
	
}
