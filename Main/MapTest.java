package Main;

import static org.junit.Assert.*;
import java.io.IOException;
import Ability.*;

import org.junit.Test;

public class MapTest {

	@Test
	public void test() {
		Map m = new Map(4,5);
		System.out.println(m);
		Character pers1 = new Character("pers1", 1, 1000, 5, 6, 50, 50);
		Character pers2 = new Character("pers2", 1, 1000, 5, 6, 50, 50);
		
		Ability[] atk = new Ability[1];
		atk[0] = new Punch(50);
		pers1.setAbilities(atk);
		
		m.getMap()[0][0].setCharacter(pers1);
		m.getMap()[3][4].setCharacter(pers2);
		
		System.out.println(m);
		System.out.println("");
		
		
		System.out.println(pers2.getPV());
		
		pers1.getAbility(0).use(m.getMap()[3][4]);
		System.out.println(pers2.getPV());
		
		pers1.getAbility(0).use(m.getMap()[3][3]);
		System.out.println(pers2.getPV());
		
	}

}
