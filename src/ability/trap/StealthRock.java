package ability.trap;

import map.Character;
import map.Square;

public class StealthRock extends Trap {

	private int damage;

	public StealthRock(){
		super("StealthRock");
	}

	
	public void setParameters(String[] parameters) {
		if (parameters.length != 2) System.out.println("Erreur dans setParameters de StealthRock");
		
		damage = Integer.parseInt(parameters[0]);
		setRadius(Integer.parseInt(parameters[1]));
		
	}

	public String getCodex(){
		return getId() + "_ability.trap." + getName() + "-" + damage + "-" + getRadius(); 
	}
	
	public void activation(Character character) {
		physicalDamage(character, damage);
		
	}

	public void use(Square userLoc, Square aim) {
		if(checkPa(userLoc.getCharacter())){
			if(range(userLoc, aim)){
				if(aim.getTrap() == null) aim.setTrap(this);
			}
		}
	}

	public boolean equals(Object trap) {
		{
			if(!(trap instanceof StealthRock)) return false;
			
			StealthRock t = (StealthRock) trap;
			
			return (this.damage == t.damage);
		}
	}


}
