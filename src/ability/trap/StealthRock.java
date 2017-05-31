package ability.trap;

import map.Character;

public class StealthRock extends Trap {

	private int damage;

	public StealthRock(){
		super("StealthRock");
	}

	
	public void setParameters(String[] parameters) {
		if (parameters.length != 1) System.out.println("Erreur dans setParameters de Punch");
		
		damage = Integer.parseInt(parameters[0]);
		
	}


	public void activation(Character character) {
		physicalDamage(character, damage);
		
	}


}
