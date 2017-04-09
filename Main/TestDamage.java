package Main;

import Ability.*;

public class TestDamage {

	public static void main(String[] args) {
		Ability[] atk = new Ability[2];
		atk[0] = new BasicAttack(10);
		atk[1] = new BasicAttack(20);
		System.out.println(atk[0].getName());
		Personage perso1 = new Personage("Albeeeeert", 100, atk);
		System.out.println(perso1.name);
		Personage perso2 = new Personage("Philipe", 200, atk);
		System.out.println(perso2.name);
		perso1.ability[0].use(perso2);
		System.out.println(perso2.pv);
		perso1.ability[1].use(perso2);
		System.out.println(perso2.pv);
	}

}
