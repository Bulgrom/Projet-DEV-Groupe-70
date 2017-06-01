package ability.damageAbility;

import map.Character;
import map.Square;
import ability.Ability;

public class BasicArrow extends Ability{
	private int damage;
	
	public BasicArrow(){
		super("BasicArrow");
	}
	
	public BasicArrow(int damage, int radius){
		super("BasicArrow");
		this.damage = damage;
		setRadius(radius);
	}
	
	public String getCodex(){
		return "ability.damageAbility.BasicArrow" + "-" + damage + "-" + getRadius(); 
	}
	
	public void setDamage(int dmg){
		this.damage = dmg;
	}
	
	public void setParameters(String[] parameters){
		if (parameters.length != 2) System.out.println("Erreur dans setParameters de BasicArrow");
		
		setDamage(Integer.parseInt(parameters[0]));
		setRadius(Integer.parseInt(parameters[1]));
	}
	
	public void use(Square userLocation, Square aim){
		if(checkPa(userLocation.getCharacter())){
			if(range(userLocation, aim)){
				Character p = aim.getCharacter();
				if (p != null) physicalDamage(p, damage);
			}
		}
	}
	
}
